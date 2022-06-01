package com.rottrak.tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.google.android.material.button.MaterialButton;

public class LoginActivity extends AppCompatActivity {

    Button btnLogIn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_RotTrak);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        //Hide the Action Bar
        getSupportActionBar().hide();

        btnLogIn = (Button)findViewById(R.id.btnLogIn);
        btnLogIn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                i.putExtra("login","true");
                startActivity(i);
            }
        });

    }




}