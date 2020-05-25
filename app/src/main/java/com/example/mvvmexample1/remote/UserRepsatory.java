package com.example.mvvmexample1.remote;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvmexample1.model.Categories;
import com.example.mvvmexample1.viewmodel.CategoryViewModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepsatory {
    public MutableLiveData<ArrayList<CategoryViewModel>> arrayListMutableLiveData = new MutableLiveData<>();
    private ArrayList<CategoryViewModel> categoryViewModels;
    private ArrayList<Categories> items;

    public UserRepsatory() {
    }

    public MutableLiveData<ArrayList<CategoryViewModel>> getArrayListMutableLiveData() {

        APIService apiService = new RetrofitClass().getRetrofitInstance("url").create(APIService.class);
        Call<CatetoryList> catetoryListCall = apiService.getCatetoryList();

        catetoryListCall.enqueue(new Callback<CatetoryList>() {
            @Override
            public void onResponse(Call<CatetoryList> call, Response<CatetoryList> response) {
                items = response.body().getCategories();
                Categories categories;
                CategoryViewModel categoryViewModel;

                categoryViewModels = new ArrayList<>();
                for(Categories item : items){
                    categories =  new Categories(item.id, item.title, item.desc, item.imagePath);

                    categoryViewModel = new CategoryViewModel(categories);
                    categoryViewModels.add(categoryViewModel);
                }

                arrayListMutableLiveData.setValue(categoryViewModels);
            }

            @Override
            public void onFailure(Call<CatetoryList> call, Throwable t) {

            }
        });
        return arrayListMutableLiveData;
    }
}
