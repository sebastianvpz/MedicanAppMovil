package com.example.veterinariaproject.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.veterinariaproject.apirest.AuthClient;

public class AuthViewModelFactory implements ViewModelProvider.Factory {

    private final AuthClient authClient;

    public AuthViewModelFactory(AuthClient authClient) {
        this.authClient = authClient;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(AuthViewModel.class)) {
            return (T) new AuthViewModel(authClient);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
