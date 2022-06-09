package com.rottrak.tracker;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.rottrak.tracker.databinding.ActivityMainBinding;

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


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("My Notification","My Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        Bitmap myBitmap = BitmapFactory.decodeResource(getResources(),
                R.drawable.ic_image_banana);

        NotificationCompat.Style style = new NotificationCompat.BigPictureStyle().bigPicture(myBitmap);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this,"My Notification")
        .setContentTitle("Expiration Alert! ⌛ ")
        .setContentText("Banana expires in 3 days. You have items in your list that is about to expire")
        .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(myBitmap)
                .setAutoCancel(true)
                .setStyle(style);


        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(MainActivity.this);
        managerCompat.notify(1, builder.build());

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

                    ImageButton btnDone = mView.findViewById(R.id.btnCart);
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

                    ImageView item_image = mView.findViewById(R.id.item_image);
                    item_image.setImageResource(R.drawable.ic_item_image_placeholder);

                    item_image.setOnClickListener(new View.OnClickListener(){
                        public void onClick(View v){

                        }
                    });

                    CardView set_expiration_date = mView.findViewById(R.id.item_expiration);
                    set_expiration_date.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {

                            MaterialDatePicker datePicker =
                                    MaterialDatePicker.Builder.datePicker()
                                            .setTitleText("Select Expiration Date")
                                            .build();

                            datePicker.show(getSupportFragmentManager(), "tag");

                        }
                    });

                    CardView set_purchase_date = mView.findViewById(R.id.item_category);
                    set_purchase_date.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {

                            MaterialDatePicker datePicker =
                                    MaterialDatePicker.Builder.datePicker()
                                            .setTitleText("Select Purchase Date")
                                            .build();

                            datePicker.show(getSupportFragmentManager(), "tag");

                        }
                    });

                    CardView set_mfg_date = mView.findViewById(R.id.item_shelf);
                    set_mfg_date.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {

                            MaterialDatePicker datePicker =
                                    MaterialDatePicker.Builder.datePicker()
                                            .setTitleText("Set Manufacturing Date")
                                            .build();

                            datePicker.show(getSupportFragmentManager(), "tag");

                        }
                    });

                    CardView set_category = mView.findViewById(R.id.set_category);
                    set_category.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {

                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                            View mView = getLayoutInflater().inflate(R.layout.dialog_select_category, null);
                            builder.setView(mView);
                            AlertDialog dialog = builder.create();
                            dialog.show();


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