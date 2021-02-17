package com.example.testsharedpreferences.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testsharedpreferences.R;
import com.example.testsharedpreferences.session.SessionManager;

public class PengajarActivity extends AppCompatActivity {

    private TextView tv_name, tv_username, tv_password, tv_role;
    private Button btn_logout;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengajar);

        sessionManager = new SessionManager(getApplicationContext());

        backToLogin();

        tv_name = findViewById(R.id.tv_name);
        tv_username = findViewById(R.id.tv_username);
        tv_password = findViewById(R.id.tv_password);
        tv_role = findViewById(R.id.tv_role);
        btn_logout = findViewById(R.id.btn_logout);

        tv_name.setText(sessionManager.getDataCommit().get(SessionManager.NAME));
        tv_username.setText(sessionManager.getDataCommit().get(SessionManager.USERNAME));
        tv_password.setText(sessionManager.getDataCommit().get(SessionManager.PASSWORD));
        tv_role.setText(sessionManager.getDataCommit().get(SessionManager.JOB));


        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionManager.logOut();

                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                Toast.makeText(PengajarActivity.this, "Berhasil Logout", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    private void backToLogin() {
        if (!sessionManager.isLogin()) {
            startActivity(new Intent(PengajarActivity.this, LoginActivity.class));
            finish();
        }
    }
}
