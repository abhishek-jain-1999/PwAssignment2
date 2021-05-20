package com.abhishek.pwassignment2.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.abhishek.pwassignment2.R;
import com.abhishek.pwassignment2.viewmodel.MainViewModel;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class ControlFragment extends Fragment {


    EditText editView;
    private MainViewModel mainViewModel;

    public static ControlFragment newInstance() {
        return new ControlFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.control_fragment, container, false);
        mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        editView = view.findViewById(R.id.name_edit_view);
        view.findViewById(R.id.add_view).setOnClickListener(ControlFragment.this::onClick);
        view.findViewById(R.id.del_view).setOnClickListener(v -> mainViewModel.deleteSelectedItem());
        return view;
    }

    private void onClick(View view) {
        mainViewModel.addData(editView.getText().toString().trim());
    }
}