package com.example.testsharedpreferences.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testsharedpreferences.R;
import com.example.testsharedpreferences.api.ApiClient;
import com.example.testsharedpreferences.api.ApiInterface;
import com.example.testsharedpreferences.model.ResponseUsername;
import com.example.testsharedpreferences.model.ResultMahasiswa;
import com.example.testsharedpreferences.session.SessionManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private SessionManager sessionManager;
    private ResultMahasiswa resultMahasiswa;
    private TextView username, password;
    private Button login;
    private String Ruser, Rpass;
    private String job;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sessionManager = new SessionManager(LoginActivity.this);
        job = sessionManager.getDataCommit().get(SessionManager.JOB);

        if (sessionManager.isLogin()) {
            if (job.equalsIgnoreCase("pengajar")) {
                startActivity(new Intent(getApplicationContext(), PengajarActivity.class));
                finish();

            } else if (job.equalsIgnoreCase("pengurus")) {
                startActivity(new Intent(getApplicationContext(), PengurusActivity.class));
                finish();

            } else if (job.equalsIgnoreCase("peserta")) {
                startActivity(new Intent(getApplicationContext(), PesertaActivity.class));
                finish();
            }
        }

        username = findViewById(R.id.et_username);
        password = findViewById(R.id.et_password);
        login = findViewById(R.id.btn_masuk);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Ruser = username.getText().toString();
                Rpass = password.getText().toString();

                getData();
            }
        });
    }

    private void getData() {

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<ResponseUsername> call = apiInterface.login(Ruser);
        call.enqueue(new Callback<ResponseUsername>() {
            @Override
            public void onResponse(Call<ResponseUsername> call, Response<ResponseUsername> response) {
                resultMahasiswa = response.body().getResultMahasiswa();

                if (response.isSuccessful()) {
                    moveToJob(resultMahasiswa.getRole());

                    Toast.makeText(LoginActivity.this, "Login berhasil", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseUsername> call, Throwable t) {

                Toast.makeText(LoginActivity.this, "Terjadi Kesalahan", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void moveToJob(String role) {
        if (role.equalsIgnoreCase("pengajar")) {
            sessionManager.CreatLoginSession(resultMahasiswa.getName(),
                    resultMahasiswa.getUsername(),
                    resultMahasiswa.getPassword(),
                    resultMahasiswa.getRole());

            startActivity(new Intent(LoginActivity.this, PengajarActivity.class));
            finish();

        } else if (role.equalsIgnoreCase("pengurus")) {
            sessionManager.CreatLoginSession(resultMahasiswa.getName(),
                    resultMahasiswa.getUsername(),
                    resultMahasiswa.getPassword(),
                    resultMahasiswa.getRole());

            startActivity(new Intent(LoginActivity.this, PengurusActivity.class));
            finish();

        } else if (role.equalsIgnoreCase("peserta")) {
            sessionManager.CreatLoginSession(resultMahasiswa.getName(),
                    resultMahasiswa.getUsername(),
                    resultMahasiswa.getPassword(),
                    resultMahasiswa.getRole());

            startActivity(new Intent(LoginActivity.this, PesertaActivity.class));
            finish();
        }
    }
}