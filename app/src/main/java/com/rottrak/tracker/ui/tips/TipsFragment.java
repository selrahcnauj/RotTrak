package com.rottrak.tracker.ui.tips;

import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.rottrak.tracker.MainActivity;
import com.rottrak.tracker.R;
import com.rottrak.tracker.databinding.FragmentHomeBinding;
import com.rottrak.tracker.databinding.FragmentTipsBinding;

public class TipsFragment extends Fragment {

    private TipsViewModel mViewModel;
    private FloatingActionButton fab;
    private CardView TipsFruits;
    private FragmentTipsBinding binding;

    public static TipsFragment newInstance() {
        return new TipsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentTipsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        fab = getActivity().findViewById(R.id.fabMain);
        fab.hide();

        TipsFruits = binding.TipsFruits;

        TipsFruits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.AlertDialog_Fullscreen);


                    View mView = getLayoutInflater().inflate(R.layout.dialog_tips_item, null);
                    builder.setView(mView);
                    AlertDialog dialog = builder.create();
                    dialog.show();
            }
        });

        return root;
    }

    /*@Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(TipsViewModel.class);
        // TODO: Use the ViewModel
    }*/

}