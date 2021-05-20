package com.abhishek.pwassignment2;

import android.os.Bundle;

import com.abhishek.pwassignment2.fragments.ControlFragment;
import com.abhishek.pwassignment2.fragments.ListFragment;
import com.abhishek.pwassignment2.viewmodel.MainViewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainViewModel mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.list_fragment, ListFragment.newInstance());
        fragmentTransaction.replace(R.id.control_fragment, ControlFragment.newInstance());
        fragmentTransaction.commit();
    }
}