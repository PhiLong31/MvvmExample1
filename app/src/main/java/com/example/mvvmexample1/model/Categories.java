package com.example.mvvmexample1.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Categories {
    @SerializedName("id")
    @Expose
    public String id = "";

    @SerializedName("title")
    @Expose
    public String title = "";

    @SerializedName("desc")
    @Expose
    public String desc = "";

    @SerializedName("iamgePath")
    @Expose
    public String imagePath = "";

    public Categories(String id, String title, String desc, String imagePath) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.imagePath = imagePath;
    }

    public Categories() {
    }
}
