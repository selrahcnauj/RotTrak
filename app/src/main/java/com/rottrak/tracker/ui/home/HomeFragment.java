package com.rottrak.tracker.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.rottrak.tracker.R;
import com.rottrak.tracker.databinding.FragmentHomeBinding;
import com.rottrak.tracker.databinding.FragmentNotificationsBinding;
import com.rottrak.tracker.ui.notifications.NotificationsFragment;

import java.util.ArrayList;
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

                Toast.makeText(getContext(), itemList.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        };
    }
    private void setItemsInfo(){
        itemList.add(new expiryListData("Apple", "", "lmao", "", "Fruits & Vegetables"));
        itemList.add(new expiryListData("Banana", "", "lmao", "", "Fish"));
        itemList.add(new expiryListData("Chicken Nuggets", "", "lmao", "", "Fish"));
        itemList.add(new expiryListData("Chicken", "", "lmao", "", "Fish"));
        itemList.add(new expiryListData("Milk", "", "lmao", "", "Fish"));
        itemList.add(new expiryListData("Chicken Nuggets", "", "lmao", "", "Fish"));
        itemList.add(new expiryListData("Chicken Nuggets", "", "lmao", "", "Fish"));
        itemList.add(new expiryListData("Chicken Nuggets", "", "lmao", "", "Fish"));
        itemList.add(new expiryListData("Chicken Nuggets", "", "lmao", "", "Fish"));

        itemList.add(new expiryListData("Chicken Nuggets", "", "lmao", "", "Fish"));
        itemList.add(new expiryListData("Chicken Nuggets", "", "lmao", "", "Fish"));
        itemList.add(new expiryListData("Chicken Nuggets", "", "lmao", "", "Fish"));

        itemList.add(new expiryListData("Chicken Nuggets", "", "lmao", "", "Fish"));

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}