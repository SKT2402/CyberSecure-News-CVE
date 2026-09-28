package com.example.cybersecurenewscve;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.cybersecurenewscve.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(
            @NonNull View view,
            Bundle savedInstanceState
    ) {
        super.onViewCreated(view, savedInstanceState);

        // Noticias
        binding.btnNoticias.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), NoticiasActivity.class);
            startActivity(intent);
        });

        // Vulnerabilidades
        binding.btnVulnerabilidades.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), VulnerabilidadesActivity.class);
            startActivity(intent);
        });

        // Administrador
        binding.btnAdministrador.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), AdminActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}