package com.example.mvvmexample1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.databinding.DataBindingUtil;

import com.example.mvvmexample1.R;
import com.example.mvvmexample1.databinding.CategoryBinding;
import com.example.mvvmexample1.viewmodel.CategoryViewModel;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomView> {

    private ArrayList<CategoryViewModel> categoryViewModels;
    private Context context;

    private LayoutInflater layoutInflater;

    public CustomAdapter(ArrayList<CategoryViewModel> categoryViewModels, Context context) {
        this.categoryViewModels = categoryViewModels;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        CategoryBinding categoryBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_recyclerview, parent, false);
        return new CustomView(categoryBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomView holder, int position) {
        CategoryViewModel categoryViewModel = categoryViewModels.get(position);
        holder.bind(categoryViewModel);
    }

    @Override
    public int getItemCount() {
        return categoryViewModels.size();
    }

    public class CustomView extends RecyclerView.ViewHolder {

        private CategoryBinding categoryBinding;

        public CustomView(@NonNull CategoryBinding categoryBinding) {
            super(categoryBinding.getRoot());
            this.categoryBinding = categoryBinding;
        }

        public void bind(CategoryViewModel categoryViewModel) {
            this.categoryBinding.setCategorymodel(categoryViewModel);
            categoryBinding.executePendingBindings();
        }

        public CategoryBinding getCategoryBinding() {
            return categoryBinding;
        }
    }
}
