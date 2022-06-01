package com.rottrak.tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_RotTrak);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        //Hide the Action Bar
        getSupportActionBar().hide();
    }
}