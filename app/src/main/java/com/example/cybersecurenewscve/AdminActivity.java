package com.example.cybersecurenewscve;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class AdminActivity extends AppCompatActivity {

    private Spinner spinnerTipoContenido;
    private EditText etTituloNoticia;
    private EditText etDescripcionPrincipal;
    private EditText etImpacto;
    private EditText etEjemploPractico;
    private EditText etMitigacion;
    private EditText etOpinionAnalista;
    private EditText etReferencia;

    private SharedPreferences preferencias;
    private JSONArray contenidos;

    private int indiceEdicion = -1;
    private Button btnGuardar;
    private Button btnEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        spinnerTipoContenido = findViewById(R.id.spinnerTipoContenido);
        etTituloNoticia = findViewById(R.id.etTituloNoticia);
        etDescripcionPrincipal = findViewById(R.id.etDescripcionPrincipal);
        etImpacto = findViewById(R.id.etImpacto);
        etEjemploPractico = findViewById(R.id.etEjemploPractico);
        etMitigacion = findViewById(R.id.etMitigacion);
        etOpinionAnalista = findViewById(R.id.etOpinionAnalista);
        etReferencia = findViewById(R.id.etReferencia);

        btnGuardar = findViewById(R.id.btnAgregarNoticia);
        btnEditar = findViewById(R.id.btnEditarNoticia);

        preferencias = getSharedPreferences(
                "CyberSecureNewsCVE", MODE_PRIVATE);

        cargarContenidos();

        String[] tipos = {"Noticia", "Análisis de CVE"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                tipos);

        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        spinnerTipoContenido.setAdapter(adapter);

        spinnerTipoContenido.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(
                            AdapterView<?> parent,
                            View view,
                            int position,
                            long id) {

                        if (position == 0) {
                            etDescripcionPrincipal.setHint("¿Qué ocurrió?");
                        } else {
                            etDescripcionPrincipal.setHint(
                                    "¿Qué es la vulnerabilidad?");
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });

        btnGuardar.setOnClickListener(v -> guardarContenido());

        btnEditar.setOnClickListener(v -> mostrarContenidosParaEditar());

        Button btnInicio = findViewById(R.id.btnInicioAdmin);
        Button btnNoticias = findViewById(R.id.btnNoticiasAdmin);
        Button btnVulnerabilidades =
                findViewById(R.id.btnVulnerabilidadesAdmin);

        btnInicio.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });

        btnNoticias.setOnClickListener(v ->
                startActivity(new Intent(this, NoticiasActivity.class)));

        btnVulnerabilidades.setOnClickListener(v ->
                startActivity(new Intent(
                        this, VulnerabilidadesActivity.class)));
    }

    private void cargarContenidos() {
        String json = preferencias.getString("contenidos", "[]");

        try {
            contenidos = new JSONArray(json);
        } catch (JSONException e) {
            contenidos = new JSONArray();
        }
    }

    private void guardarContenidos() {
        preferencias.edit()
                .putString("contenidos", contenidos.toString())
                .apply();
    }

    private void guardarContenido() {
        String titulo = etTituloNoticia.getText().toString().trim();
        String descripcion =
                etDescripcionPrincipal.getText().toString().trim();

        if (titulo.isEmpty()) {
            etTituloNoticia.setError("Introduce un título");
            etTituloNoticia.requestFocus();
            return;
        }

        if (descripcion.isEmpty()) {
            etDescripcionPrincipal.setError("Introduce una descripción");
            etDescripcionPrincipal.requestFocus();
            return;
        }

        try {
            JSONObject contenido = new JSONObject();

            contenido.put("tipo",
                    spinnerTipoContenido.getSelectedItem().toString());
            contenido.put("titulo", titulo);
            contenido.put("descripcion", descripcion);
            contenido.put("impacto",
                    etImpacto.getText().toString().trim());
            contenido.put("ejemplo",
                    etEjemploPractico.getText().toString().trim());
            contenido.put("mitigacion",
                    etMitigacion.getText().toString().trim());
            contenido.put("opinion",
                    etOpinionAnalista.getText().toString().trim());
            contenido.put("referencia",
                    etReferencia.getText().toString().trim());

            if (indiceEdicion >= 0) {
                // Conservar la fecha original al editar.
                JSONObject anterior = contenidos.optJSONObject(indiceEdicion);

                if (anterior != null) {
                    contenido.put("fecha",
                            anterior.opt("fecha") == null
                                    ? System.currentTimeMillis()
                                    : anterior.opt("fecha"));
                }

                contenidos.put(indiceEdicion, contenido);
                indiceEdicion = -1;

                btnGuardar.setText("Guardar contenido");

                guardarContenidos();
                Toast.makeText(this,
                        "Cambios guardados correctamente",
                        Toast.LENGTH_LONG).show();

            } else {
                contenido.put("fecha", System.currentTimeMillis());
                contenidos.put(contenido);

                guardarContenidos();
                Toast.makeText(this,
                        "Contenido guardado correctamente",
                        Toast.LENGTH_LONG).show();
            }

            limpiarFormulario();

        } catch (JSONException e) {
            Toast.makeText(this,
                    "Error al guardar el contenido",
                    Toast.LENGTH_LONG).show();
        }
    }

    private void mostrarContenidosParaEditar() {
        cargarContenidos();

        if (contenidos.length() == 0) {
            Toast.makeText(this,
                    "No hay contenidos para editar",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        ArrayList<Integer> indices = new ArrayList<>();
        ArrayList<String> opciones = new ArrayList<>();

        for (int i = 0; i < contenidos.length(); i++) {
            JSONObject item = contenidos.optJSONObject(i);

            if (item != null) {
                indices.add(i);

                String tipo = item.optString("tipo", "Contenido");
                String titulo = item.optString("titulo", "Sin título");

                opciones.add(tipo + " — " + titulo);
            }
        }

        if (opciones.isEmpty()) {
            Toast.makeText(this,
                    "No se encontraron contenidos válidos",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        new AlertDialog.Builder(this)
                .setTitle("Selecciona el contenido que deseas editar")
                .setItems(opciones.toArray(new String[0]),
                        (dialog, which) -> {
                            int indice = indices.get(which);
                            JSONObject seleccionado =
                                    contenidos.optJSONObject(indice);

                            if (seleccionado != null) {
                                cargarFormulario(seleccionado, indice);
                            }
                        })
                .setNegativeButton("Cancelar", null)
                .show();
    }

    private void cargarFormulario(JSONObject item, int indice) {
        indiceEdicion = indice;

        String tipo = item.optString("tipo", "Noticia");
        spinnerTipoContenido.setSelection(
                tipo.equalsIgnoreCase("Análisis de CVE") ? 1 : 0);

        etTituloNoticia.setText(item.optString("titulo", ""));
        etDescripcionPrincipal.setText(item.optString("descripcion", ""));
        etImpacto.setText(item.optString("impacto", ""));
        etEjemploPractico.setText(item.optString("ejemplo", ""));
        etMitigacion.setText(item.optString("mitigacion", ""));
        etOpinionAnalista.setText(item.optString("opinion", ""));
        etReferencia.setText(item.optString("referencia", ""));

        btnGuardar.setText("Guardar cambios");

        Toast.makeText(this,
                "Edita los campos y pulsa Guardar cambios",
                Toast.LENGTH_LONG).show();
    }

    private void limpiarFormulario() {
        etTituloNoticia.setText("");
        etDescripcionPrincipal.setText("");
        etImpacto.setText("");
        etEjemploPractico.setText("");
        etMitigacion.setText("");
        etOpinionAnalista.setText("");
        etReferencia.setText("");

        indiceEdicion = -1;
        btnGuardar.setText("Guardar contenido");
        etTituloNoticia.requestFocus();
    }
}
