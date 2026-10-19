package com.example.cybersecurenewscve;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.cybersecurenewscve.databinding.FragmentFirstBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private LinearLayout layoutResumenInicio;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentFirstBinding.inflate(
                inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(
            @NonNull View view,
            Bundle savedInstanceState
    ) {
        super.onViewCreated(view, savedInstanceState);

        layoutResumenInicio =
                view.findViewById(R.id.layoutResumenInicio);

        binding.btnNoticias.setOnClickListener(v -> {
            Intent intent = new Intent(
                    requireContext(), NoticiasActivity.class);
            startActivity(intent);
        });

        binding.btnVulnerabilidades.setOnClickListener(v -> {
            Intent intent = new Intent(
                    requireContext(), VulnerabilidadesActivity.class);
            startActivity(intent);
        });

        binding.btnAdministrador.setOnClickListener(v -> {
            Intent intent = new Intent(
                    requireContext(), AdminActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void onResume() {
        super.onResume();

        if (layoutResumenInicio != null) {
            cargarResumen();
        }
    }

    private void cargarResumen() {
        layoutResumenInicio.removeAllViews();

        SharedPreferences preferencias =
                requireContext().getSharedPreferences(
                        "CyberSecureNewsCVE",
                        android.content.Context.MODE_PRIVATE);

        String jsonGuardado =
                preferencias.getString("contenidos", "[]");

        try {
            JSONArray contenidos = new JSONArray(jsonGuardado);

            agregarEncabezado("Noticias recientes");

            int noticiasMostradas = mostrarContenidos(
                    contenidos, "Noticia", 3);

            if (noticiasMostradas == 0) {
                agregarMensaje("Todavía no hay noticias guardadas.");
            }

            agregarEncabezado("Análisis de vulnerabilidades (CVE)");

            int cvesMostrados = mostrarContenidos(
                    contenidos, "Análisis de CVE", 3);

            if (cvesMostrados == 0) {
                agregarMensaje("Todavía no hay análisis de CVE guardados.");
            }

        } catch (JSONException e) {
            agregarMensaje(
                    "No fue posible leer los contenidos guardados.");
        }
    }

    private int mostrarContenidos(
            JSONArray contenidos,
            String tipoBuscado,
            int limite
    ) {
        int mostrados = 0;

        // Recorrer desde el último registro para mostrar primero
        // los contenidos agregados más recientemente.
        for (int i = contenidos.length() - 1;
             i >= 0 && mostrados < limite; i--) {

            JSONObject contenido = contenidos.optJSONObject(i);

            if (contenido == null) {
                continue;
            }

            String tipo = contenido.optString("tipo", "");

            if (tipo.equalsIgnoreCase(tipoBuscado)) {
                agregarTarjeta(contenido, tipoBuscado);
                mostrados++;
            }
        }

        return mostrados;
    }

    private void agregarEncabezado(String titulo) {
        TextView encabezado = new TextView(requireContext());
        encabezado.setText(titulo);
        encabezado.setTextSize(19);
        encabezado.setTypeface(null, Typeface.BOLD);
        encabezado.setPadding(0, 12, 0, 8);

        layoutResumenInicio.addView(encabezado);
    }

    private void agregarTarjeta(JSONObject contenido, String tipo) {
        LinearLayout tarjeta = new LinearLayout(requireContext());
        tarjeta.setOrientation(LinearLayout.VERTICAL);
        tarjeta.setPadding(12, 12, 12, 12);
        tarjeta.setBackgroundColor(0xFFF0F4F8);

        LinearLayout.LayoutParams parametros =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);

        parametros.setMargins(0, 0, 0, 10);
        tarjeta.setLayoutParams(parametros);

        TextView titulo = new TextView(requireContext());
        titulo.setText(contenido.optString(
                "titulo", "Contenido sin título"));
        titulo.setTextSize(17);
        titulo.setTypeface(null, Typeface.BOLD);
        titulo.setTextColor(0xFF172B4D);

        TextView descripcion = new TextView(requireContext());
        descripcion.setText(contenido.optString(
                "descripcion", "Sin descripción disponible."));
        descripcion.setTextSize(14);
        descripcion.setTextColor(0xFF263238);
        descripcion.setPadding(0, 6, 0, 0);

        tarjeta.addView(titulo);
        tarjeta.addView(descripcion);

        if (tipo.equalsIgnoreCase("Análisis de CVE")) {
            agregarCampoSiExiste(
                    tarjeta, "Impacto",
                    contenido.optString("impacto", ""));

            agregarCampoSiExiste(
                    tarjeta, "Mitigación",
                    contenido.optString("mitigacion", ""));
        }

        layoutResumenInicio.addView(tarjeta);
    }

    private void agregarCampoSiExiste(
            LinearLayout tarjeta,
            String etiqueta,
            String valor
    ) {
        if (valor == null || valor.trim().isEmpty()) {
            return;
        }

        TextView campo = new TextView(requireContext());
        campo.setText(etiqueta + ": " + valor);
        campo.setTextSize(13);
        campo.setPadding(0, 5, 0, 0);

        tarjeta.addView(campo);
    }

    private void agregarMensaje(String mensaje) {
        TextView texto = new TextView(requireContext());
        texto.setText(mensaje);
        texto.setTextSize(14);
        texto.setPadding(0, 0, 0, 12);

        layoutResumenInicio.addView(texto);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        layoutResumenInicio = null;
        binding = null;
    }
}
