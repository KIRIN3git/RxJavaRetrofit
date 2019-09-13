package com.example.rxjavaretrofit;

import retrofit2.Response;

public class ResponseData {

    String name;
    String description;
    String language;
    String url;

    public ResponseData(String name,String description,String language,String url){
        this.name = name;
        this.description = description;
        this.language = language;
        this.url = url;
    }
}

