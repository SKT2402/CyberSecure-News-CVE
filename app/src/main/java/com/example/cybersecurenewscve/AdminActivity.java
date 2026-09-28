package com.example.cybersecurenewscve;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        Button btnInicio = findViewById(R.id.btnInicioAdmin);
        Button btnNoticias = findViewById(R.id.btnNoticiasAdmin);
        Button btnVulnerabilidades = findViewById(R.id.btnVulnerabilidadesAdmin);

        // Ir a Inicio
        btnInicio.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });

        // Ir a Noticias
        btnNoticias.setOnClickListener(v -> {
            Intent intent = new Intent(this, NoticiasActivity.class);
            startActivity(intent);
        });

        // Ir a Vulnerabilidades
        btnVulnerabilidades.setOnClickListener(v -> {
            Intent intent = new Intent(this, VulnerabilidadesActivity.class);
            startActivity(intent);
        });
    }
}