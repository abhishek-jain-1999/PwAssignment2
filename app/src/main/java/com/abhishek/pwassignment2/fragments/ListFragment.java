package com.abhishek.pwassignment2.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abhishek.pwassignment2.R;
import com.abhishek.pwassignment2.adapters.ListAdapter;
import com.abhishek.pwassignment2.viewmodel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

public class ListFragment extends Fragment {

    private List<ListAdapter.Data> list = new ArrayList<>();
    private ListAdapter listAdapter;

    public static ListFragment newInstance() {
        return new ListFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.list_recycler_view);

        MainViewModel mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        listAdapter = new ListAdapter(list, mainViewModel::OnCheckedChange);
        mainViewModel.getData().observe(requireActivity(), list -> {
            int size = listAdapter.getItemCount();
            listAdapter.setData(list);
            listAdapter.notifyDataSetChanged();
            if (!list.isEmpty() && list.size() - size == 1) {
                recyclerView.smoothScrollToPosition(list.size() - 1);
            }
        });

        recyclerView.setAdapter(listAdapter);
        return view;
    }

}