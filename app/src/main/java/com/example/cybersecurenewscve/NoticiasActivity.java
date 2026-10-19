
package com.example.cybersecurenewscve;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NoticiasActivity extends AppCompatActivity {

    private LinearLayout layoutListaNoticias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);

        layoutListaNoticias = findViewById(R.id.layoutListaNoticias);

        Button btnInicio = findViewById(R.id.btnInicio);
        Button btnVulnerabilidades =
                findViewById(R.id.btnVulnerabilidades);
        Button btnAdministrador = findViewById(R.id.btnAdministrador);

        btnInicio.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });

        btnVulnerabilidades.setOnClickListener(v -> {
            Intent intent = new Intent(
                    this, VulnerabilidadesActivity.class);
            startActivity(intent);
        });

        btnAdministrador.setOnClickListener(v -> {
            Intent intent = new Intent(this, AdminActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        cargarNoticias();
    }

    private void cargarNoticias() {
        layoutListaNoticias.removeAllViews();

        SharedPreferences preferencias =
                getSharedPreferences(
                        "CyberSecureNewsCVE", MODE_PRIVATE);

        String jsonGuardado =
                preferencias.getString("contenidos", "[]");

        try {
            JSONArray contenidos = new JSONArray(jsonGuardado);
            int cantidadNoticias = 0;

            for (int i = 0; i < contenidos.length(); i++) {
                JSONObject contenido = contenidos.getJSONObject(i);

                String tipo = contenido.optString("tipo", "");

                if (tipo.equalsIgnoreCase("Noticia")) {
                    agregarNoticia(contenido);
                    cantidadNoticias++;
                }
            }

            if (cantidadNoticias == 0) {
                mostrarMensaje(
                        "Todavía no hay noticias publicadas. "
                                + "Agrega una desde Administrador.");
            }

        } catch (JSONException e) {
            mostrarMensaje(
                    "No se pudieron leer las noticias guardadas.");
            Toast.makeText(
                    this,
                    "Error al leer los contenidos",
                    Toast.LENGTH_SHORT
            ).show();
        }
    }

    private void agregarNoticia(JSONObject noticia) {
        LinearLayout tarjeta = new LinearLayout(this);
        tarjeta.setOrientation(LinearLayout.VERTICAL);
        tarjeta.setPadding(16, 16, 16, 16);

        LinearLayout.LayoutParams parametrosTarjeta =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);

        parametrosTarjeta.setMargins(0, 0, 0, 16);
        tarjeta.setLayoutParams(parametrosTarjeta);
        tarjeta.setBackgroundColor(0xFFF0F4F8);

        String titulo = noticia.optString(
                "titulo", "Noticia sin título");

        String descripcion = noticia.optString(
                "descripcion", "Sin descripción disponible.");

        String fecha = noticia.optString("fecha", "");

        TextView tvTitulo = new TextView(this);
        tvTitulo.setText(titulo);
        tvTitulo.setTextSize(20);
        tvTitulo.setTypeface(null, Typeface.BOLD);
        tvTitulo.setTextColor(0xFF172B4D);

        TextView tvFecha = new TextView(this);
        tvFecha.setText(fecha.isEmpty() ? "" : "Fecha: " + fecha);
        tvFecha.setTextSize(12);
        tvFecha.setPadding(0, 6, 0, 10);

        TextView tvDescripcion = new TextView(this);
        tvDescripcion.setText(descripcion);
        tvDescripcion.setTextSize(16);
        tvDescripcion.setTextColor(0xFF263238);

        tarjeta.addView(tvTitulo);
        tarjeta.addView(tvFecha);
        tarjeta.addView(tvDescripcion);

        layoutListaNoticias.addView(tarjeta);
    }

    private void mostrarMensaje(String mensaje) {
        TextView tvMensaje = new TextView(this);
        tvMensaje.setText(mensaje);
        tvMensaje.setTextSize(16);
        tvMensaje.setPadding(12, 20, 12, 20);

        layoutListaNoticias.addView(tvMensaje);
    }
}
