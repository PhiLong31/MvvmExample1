package com.example.mvvmexample1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mvvmexample1.adapter.CustomAdapter;
import com.example.mvvmexample1.viewmodel.CategoryViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CategoryViewModel categoryViewModel;
    private CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        categoryViewModel = new ViewModelProvider(this).get(CategoryViewModel.class);

        categoryViewModel.getArrayListMutableLiveData().observe(this, new Observer<ArrayList<CategoryViewModel>>() {
            @Override
            public void onChanged(ArrayList<CategoryViewModel> categoryViewModels) {
                customAdapter = new CustomAdapter(categoryViewModels, MainActivity.this);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerView.setAdapter(customAdapter);
            }
        });
    }
}
