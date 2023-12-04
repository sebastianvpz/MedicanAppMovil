package com.example.veterinariaproject.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.veterinariaproject.apirest.AuthClient;
import com.example.veterinariaproject.model.AuthResponse;
import com.example.veterinariaproject.model.LoginRequestDTO;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthViewModel extends ViewModel {


    private final AuthClient authClient;

    private final MutableLiveData<Boolean> authenticationResult = new MutableLiveData<>();
    private final MutableLiveData<Long> userId = new MutableLiveData<>();

    public AuthViewModel(AuthClient authClient) {
        this.authClient = authClient;
    }

    // Método para realizar la autenticación
    public void authenticateUser(String email, String password) {
        LoginRequestDTO loginRequest = new LoginRequestDTO(email, password);

        authClient.login(loginRequest).enqueue(new Callback<AuthResponse>() {
            @Override
            public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    AuthResponse authResponse = response.body();
                    authenticationResult.setValue(authResponse.isAutenticacionExitosa());
                    userId.setValue(authResponse.getIdUsuario());
                } else {
                    // Manejar el caso en que la autenticación falla
                    authenticationResult.setValue(false);
                    userId.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<AuthResponse> call, Throwable t) {
                // Manejar el caso en que la solicitud falle
                authenticationResult.setValue(false);
                userId.setValue(null);
                t.printStackTrace();
            }
        });
    }

    // Métodos para observar el resultado de la autenticación y el ID del usuario
    public LiveData<Boolean> getAuthenticationResult() {
        return authenticationResult;
    }

    public LiveData<Long> getUserId() {
        return userId;
    }
}
