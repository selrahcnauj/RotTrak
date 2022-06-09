package com.rottrak.tracker.ui.cart;

import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.rottrak.tracker.R;
import com.rottrak.tracker.databinding.FragmentCartBinding;
import com.rottrak.tracker.databinding.FragmentNotificationsBinding;

import java.util.ArrayList;

public class CartFragment extends Fragment {

    private FragmentCartBinding binding;
    private CartViewModel mViewModel;
    private FloatingActionButton fab;
    private ListView listView;
    private ArrayList<String> items;
    private ListViewAdapter adapter;


    public static CartFragment newInstance() {
        return new CartFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentCartBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        fab = getActivity().findViewById(R.id.fabMain);
        fab.show();

        listView = binding.lvGrocery;
        items =  new ArrayList<>();
        items.add("Apple");
        items.add("Cheese");
        items.add("Milk");
        items.add("Chicken");
        items.add("Fish");
        items.add("Wagyu");
        items.add("Bread");

        adapter = new ListViewAdapter(getContext(), items);
        listView.setAdapter(adapter);
        //return inflater.inflate(R.layout.fragment_cart, container, false);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(CartViewModel.class);
        // TODO: Use the ViewModel
    }

}