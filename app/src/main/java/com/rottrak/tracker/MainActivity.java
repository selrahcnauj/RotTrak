package com.rottrak.tracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.rottrak.tracker.databinding.ActivityMainBinding;
import com.rottrak.tracker.ui.notifications.NotificationsFragment;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        //Intent Go to Splash Screen
        if(!getIntent().getStringExtra("login").equals("true")) {
            Intent i = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(i);
        }

        BottomNavigationView navView = (BottomNavigationView) findViewById(R.id.nav_view);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_tips, R.id.navigation_tips, R.id.navigation_account)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);



        fab = binding.fabMain;

        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                MenuItem str = navView.getMenu().findItem(navView.getSelectedItemId());
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, R.style.AlertDialog_Fullscreen);

                if(str.toString().toLowerCase().equals("home")) {
                    View mView = getLayoutInflater().inflate(R.layout.dialog_new_item_expiry, null);
                    builder.setView(mView);
                    AlertDialog dialog = builder.create();
                    dialog.show();

                    ImageButton btnDone = mView.findViewById(R.id.btnDone);
                    ImageButton btnClose = mView.findViewById(R.id.btnClose);
                    btnClose.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });

                    btnDone.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });

                }else if (str.toString().toLowerCase().equals("cart")){
                    Toast.makeText(getApplicationContext(),"Cart",Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

    private int getSelectedItem(BottomNavigationView bottomNavigationView) {
        Menu menu = bottomNavigationView.getMenu();
        for (int i = 0; i < bottomNavigationView.getMenu().size(); i++) {
            MenuItem menuItem = menu.getItem(i);
            if (menuItem.isChecked()) {
                return menuItem.getItemId();
            }
        }
        return 0;
    }

}