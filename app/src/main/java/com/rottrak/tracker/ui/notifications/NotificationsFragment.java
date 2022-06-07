package com.rottrak.tracker.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.rottrak.tracker.R;
import com.rottrak.tracker.databinding.FragmentNotificationsBinding;
import com.rottrak.tracker.ui.notifications.notifListData;
import com.rottrak.tracker.ui.notifications.recyclerAdapter;

import java.util.ArrayList;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;
    private FloatingActionButton fab;
    private ArrayList<notifListData> itemList;
    private RecyclerView recyclerView;
    private recyclerAdapter.RecyclerViewClickListener clickListener;

    public NotificationsFragment() {
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //final TextView textView = binding.textNotifications;
        //notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        recyclerView = binding.rvNotifsList;
        itemList = new ArrayList<>();

        fab = getActivity().findViewById(R.id.fabMain);
        fab.hide();

        setItemsInfo();
        setAdapter();


        return root;
    }

    private void setAdapter(){
        setOnClickListener();
        com.rottrak.tracker.ui.notifications.recyclerAdapter adapter = new com.rottrak.tracker.ui.notifications.recyclerAdapter(itemList, clickListener);
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
        itemList.add(new notifListData("Banana is gonna expire in 3 days!","d","Learn how to prolong your product’s shelf life",""));
        itemList.add(new notifListData("Milk has spoiled!","d","Do not consume product","d"));

    }
    
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}