package com.example.cybersecurenewscve;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class NoticiasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);

        Button btnInicio = findViewById(R.id.btnInicio);
        Button btnVulnerabilidades = findViewById(R.id.btnVulnerabilidades);
        Button btnAdministrador = findViewById(R.id.btnAdministrador);

        // Ir a Inicio
        btnInicio.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });

        // Ir a Vulnerabilidades
        btnVulnerabilidades.setOnClickListener(v -> {
            Intent intent = new Intent(this, VulnerabilidadesActivity.class);
            startActivity(intent);
        });

        // Ir a Administrador
        btnAdministrador.setOnClickListener(v -> {
            Intent intent = new Intent(this, AdminActivity.class);
            startActivity(intent);
        });
    }
}