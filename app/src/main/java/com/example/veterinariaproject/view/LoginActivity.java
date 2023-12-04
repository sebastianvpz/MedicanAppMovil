package com.example.veterinariaproject.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.veterinariaproject.R;
import com.example.veterinariaproject.apirest.AuthClient;
import com.example.veterinariaproject.apirest.RetrofitClient;
import com.example.veterinariaproject.databinding.ActivityLoginBinding;
import com.example.veterinariaproject.viewmodel.AuthViewModel;
import com.example.veterinariaproject.viewmodel.AuthViewModelFactory;

public class LoginActivity extends AppCompatActivity {

    private AuthViewModel authViewModel;
    private ActivityLoginBinding binding;
    private AuthClient authClient;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        authClient = RetrofitClient.getAuthClient();

        if (authClient == null) {
            Log.e("LoginActivity", "El objeto authClient es nulo");
            return;
        }

        // Usa la AuthViewModelFactory para crear AuthViewModel con el AuthClient
        AuthViewModelFactory factory = new AuthViewModelFactory(authClient);
        authViewModel = new ViewModelProvider(this, factory).get(AuthViewModel.class);

        binding.btnIngresar.setOnClickListener(v -> iniciarSesion());

        authViewModel.getAuthenticationResult().observe(this, authenticationResult -> {
            if (authenticationResult) {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "Autenticación fallida", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void iniciarSesion() {
        String email = binding.txtEmail.getText().toString();
        String password = binding.txtPassword.getText().toString();

        if (authClient != null) {
            authViewModel.authenticateUser(email, password);
        } else {
            Log.e("LoginActivity", "El objeto authClient es nulo");
        }
    }
}