package com.rottrak.tracker;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class LoginActivity extends AppCompatActivity {

    Button btnLogIn;
    TextView skip;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_RotTrak);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        //Hide the Action Bar
        getSupportActionBar().hide();

        btnLogIn = (Button)findViewById(R.id.btnLogIn);
        skip = (TextView)findViewById(R.id.txt_skip);

        skip.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(LoginActivity.this);
                alertDialogBuilder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(getApplicationContext(), "enter a text here", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Log-in", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                     }
                });

                alertDialogBuilder.create();
            }
        });
        btnLogIn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                i.putExtra("login","true");
                startActivity(i);
                finish();
            }
        });

    }




}