package com.rottrak.tracker.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.rottrak.tracker.ItemActivity;
import com.rottrak.tracker.MainActivity;
import com.rottrak.tracker.R;
import com.rottrak.tracker.databinding.FragmentHomeBinding;
import com.rottrak.tracker.databinding.FragmentNotificationsBinding;
import com.rottrak.tracker.ui.notifications.NotificationsFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HomeFragment extends Fragment {

    private ArrayList<expiryListData> itemList;
    private RecyclerView recyclerView;
    private FragmentHomeBinding binding;
    private FragmentNotificationsBinding notificationsBinding;
    private ImageButton btnNotifications;
    private recyclerAdapter.RecyclerViewClickListener clickListener;
    private FloatingActionButton fab;


    @Override

    public void onResume() {
        super.onResume();
        fab = getActivity().findViewById(R.id.fabMain);
        fab.show();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        recyclerView = binding.rvExpiryList;
        itemList = new ArrayList<>();


        setItemsInfo();
        setAdapter();

        main();


        return root;

    }

    private void main(){
        /*recyclerView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

            }
        });*/

        // Spinner element
        Spinner spinner = binding.spinner;

        // Spinner click listener


        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("All");
        categories.add("Almost Expired");
        categories.add("Expired");



        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        btnNotifications = binding.btnNotifications;
        btnNotifications.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                NotificationsFragment newFragment = new NotificationsFragment();

                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_host_fragment_activity_main, newFragment)
                        .addToBackStack(null)
                        .commit();
                fab = getActivity().findViewById(R.id.fabMain);
                fab.hide();
            }
        });


    }



    private void setAdapter(){
        setOnClickListener();
        recyclerAdapter adapter = new recyclerAdapter(itemList, clickListener);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setOnClickListener(){
        clickListener = new recyclerAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent i = new Intent(getActivity(), ItemActivity.class);
                getActivity().startActivity(i);

            }
        };
    }
    private void setItemsInfo(){
        itemList.add(new expiryListData("Banana", 5,"6/12/2022", "lmao", R.drawable.ic_image_banana, "Fruits & Vegetables"));
        itemList.add(new expiryListData("Nestle Fresh Milk", 1,"6/12/2022", "lmao", R.drawable.ic_image_milk, "Beverages"));
        itemList.add(new expiryListData("PureFoods Chicken Nuggets", 1,"6/15/2022", "lmao", R.drawable.ic_image_nuggets, ""));
        itemList.add(new expiryListData("Croissant", 3,"6/16/2022", "lmao", R.drawable.ic_image_croissant , "Bread"));
        itemList.add(new expiryListData("Yakult", 6,"6/25/2022", "lmao", R.drawable.ic_image_yakult, "Beverages"));
        itemList.add(new expiryListData("Wagyu A1", 2,"7/04/2022", "lmao", R.drawable.ic_image_wagyu, "Live Stock"));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}