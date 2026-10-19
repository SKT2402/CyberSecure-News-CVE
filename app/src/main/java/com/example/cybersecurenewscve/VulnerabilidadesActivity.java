package com.example.cybersecurenewscve;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VulnerabilidadesActivity extends AppCompatActivity {

    private LinearLayout layoutListaVulnerabilidades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vulnerabilidades);

        Button btnInicio = findViewById(R.id.btnInicio);
        Button btnNoticias = findViewById(R.id.btnNoticias);
        Button btnAdministrador = findViewById(R.id.btnAdministrador);

        layoutListaVulnerabilidades =
                findViewById(R.id.layoutListaVulnerabilidades);

        btnInicio.setOnClickListener(v -> {
            Intent intent = new Intent(
                    this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });

        btnNoticias.setOnClickListener(v -> {
            startActivity(new Intent(
                    this, NoticiasActivity.class));
        });

        btnAdministrador.setOnClickListener(v -> {
            startActivity(new Intent(
                    this, AdminActivity.class));
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        cargarVulnerabilidades();
    }

    private void cargarVulnerabilidades() {
        layoutListaVulnerabilidades.removeAllViews();

        SharedPreferences preferencias =
                getSharedPreferences(
                        "CyberSecureNewsCVE",
                        MODE_PRIVATE);

        String jsonGuardado =
                preferencias.getString("contenidos", "[]");

        try {
            JSONArray contenidos = new JSONArray(jsonGuardado);
            int cantidad = 0;

            // Mostrar primero los análisis más recientes.
            for (int i = contenidos.length() - 1; i >= 0; i--) {
                JSONObject contenido =
                        contenidos.optJSONObject(i);

                if (contenido == null) {
                    continue;
                }

                String tipo = contenido.optString("tipo", "");

                if (tipo.equalsIgnoreCase("Análisis de CVE")) {
                    agregarTarjeta(contenido);
                    cantidad++;
                }
            }

            if (cantidad == 0) {
                agregarMensaje(
                        "Todavía no hay análisis de vulnerabilidades registrados.");
            }

        } catch (JSONException e) {
            agregarMensaje(
                    "No fue posible cargar los análisis guardados.");
        }
    }

    private void agregarTarjeta(JSONObject contenido) {
        LinearLayout tarjeta = new LinearLayout(this);
        tarjeta.setOrientation(LinearLayout.VERTICAL);
        tarjeta.setPadding(20, 20, 20, 20);
        tarjeta.setBackgroundColor(0xFFF0F4F8);

        LinearLayout.LayoutParams parametros =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);

        parametros.setMargins(0, 0, 0, 20);
        tarjeta.setLayoutParams(parametros);

        TextView titulo = new TextView(this);
        titulo.setText(contenido.optString(
                "titulo", "CVE sin título"));
        titulo.setTextSize(19);
        titulo.setTypeface(null, Typeface.BOLD);
        titulo.setTextColor(0xFF172B4D);

        tarjeta.addView(titulo);

        agregarCampo(
                tarjeta,
                "Descripción",
                contenido.optString("descripcion", ""));

        agregarCampo(
                tarjeta,
                "Impacto",
                contenido.optString("impacto", ""));

        agregarCampo(
                tarjeta,
                "Ejemplo práctico",
                contenido.optString("ejemplo", ""));

        agregarCampo(
                tarjeta,
                "Mitigación",
                contenido.optString("mitigacion", ""));

        agregarCampo(
                tarjeta,
                "Opinión del analista",
                contenido.optString("opinion", ""));

        agregarCampo(
                tarjeta,
                "Referencia",
                contenido.optString("referencia", ""));

        agregarCampo(
                tarjeta,
                "Fecha",
                contenido.optString("fecha", ""));

        layoutListaVulnerabilidades.addView(tarjeta);
    }

    private void agregarCampo(
            LinearLayout tarjeta,
            String etiqueta,
            String valor) {

        if (valor == null || valor.trim().isEmpty()) {
            return;
        }

        TextView campo = new TextView(this);
        campo.setText(etiqueta + ": " + valor);
        campo.setTextSize(14);
        campo.setTextColor(0xFF263238);
        campo.setPadding(0, 8, 0, 0);

        tarjeta.addView(campo);
    }

    private void agregarMensaje(String mensaje) {
        TextView texto = new TextView(this);
        texto.setText(mensaje);
        texto.setTextSize(16);
        texto.setGravity(Gravity.CENTER);
        texto.setPadding(16, 24, 16, 24);

        layoutListaVulnerabilidades.addView(texto);
    }
}
