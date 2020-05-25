package com.example.mvvmexample1.remote;

import com.example.mvvmexample1.model.Categories;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

class CatetoryList {

    /* exampleAPI
    {
        "record":[
            {
              "id": "1",
              "title" : "Levan",
              "decs": "Decs",
              "imageUrl": "ImageURL"
            },

            {
              "id": "2",
              "title" : "Levan",
              "decs": "Decs",
              "imageUrl": "ImageURL"
            },

            {
              "id": "3",
              "title" : "Levan",
              "decs": "Decs",
              "imageUrl": "ImageURL"
            }
        ]
    }
     */

    @SerializedName("record")
    @Expose
    private ArrayList<Categories> categories = new ArrayList<>();

    public ArrayList<Categories> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Categories> categories) {
        this.categories = categories;
    }
}
