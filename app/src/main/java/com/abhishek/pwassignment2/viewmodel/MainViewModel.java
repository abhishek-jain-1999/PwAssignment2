package com.abhishek.pwassignment2.viewmodel;

import com.abhishek.pwassignment2.adapters.ListAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private MutableLiveData<List<ListAdapter.Data>> list;

    public MainViewModel() {
        list = new MutableLiveData<>(new ArrayList<>());
    }

    public MutableLiveData<List<ListAdapter.Data>> getData() {
        return list;
    }

    public void OnCheckedChange(int position, boolean isChecked) {
        Objects.requireNonNull(list.getValue()).get(position).setSelected(isChecked);
    }

    public void addData(String name) {
        List<ListAdapter.Data> values = list.getValue();
        values.add(new ListAdapter.Data(name, false));
        list.postValue(values);
    }

    public void deleteSelectedItem() {
        List<ListAdapter.Data> values = list.getValue();
        values.removeIf(ListAdapter.Data::isSelected);
        list.postValue(values);

    }
}