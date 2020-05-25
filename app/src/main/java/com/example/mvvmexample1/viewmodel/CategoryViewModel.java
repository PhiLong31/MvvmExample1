package com.example.mvvmexample1.viewmodel;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.bumptech.glide.Glide;
import com.example.mvvmexample1.R;
import com.example.mvvmexample1.model.Categories;
import com.example.mvvmexample1.remote.UserRepsatory;

import java.util.ArrayList;

public class CategoryViewModel extends ViewModel {

    public MutableLiveData<ArrayList<CategoryViewModel>> arrayListMutableLiveData = new MutableLiveData<>();

    private UserRepsatory userRepsatory;

    public String id = "";
    public String title = "";
    public String desc = "";
    public String imagePath = "";

    public CategoryViewModel() {
        userRepsatory = new UserRepsatory();
        userRepsatory.getArrayListMutableLiveData();
    }

    public CategoryViewModel(Categories categories){
        this.id = categories.id;
        this.title = categories.title;
        this.desc = categories.desc;
        this.imagePath = categories.imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView imageView, String imagePath){
        Glide.with(imageView.getContext()).load(imagePath).placeholder(R.drawable.ic_launcher_foreground).into(imageView);
    }

    public MutableLiveData<ArrayList<CategoryViewModel>> getArrayListMutableLiveData() {
        return arrayListMutableLiveData;
    }
}
