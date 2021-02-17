package com.example.testsharedpreferences.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.testsharedpreferences.R;
import com.example.testsharedpreferences.session.SessionManager;

public class PesertaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peserta);

        SessionManager sessionManager = new SessionManager(getApplicationContext());
        Log.e("session", sessionManager.getDataCommit().get(SessionManager.NAME));
    }
}