package com.rottrak.tracker.ui.tips;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.rottrak.tracker.R;

public class TipsFragment extends Fragment {

    private TipsViewModel mViewModel;
    private FloatingActionButton fab;

    public static TipsFragment newInstance() {
        return new TipsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        fab = getActivity().findViewById(R.id.fabMain);
        fab.hide();

        return inflater.inflate(R.layout.fragment_tips, container, false);
    }

    /*@Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(TipsViewModel.class);
        // TODO: Use the ViewModel
    }*/

}