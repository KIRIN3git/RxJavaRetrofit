package com.example.rxjavaretrofit;

import java.util.List;


import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ResponseService {
    @GET("users/{user}/repos")

    //Call<List<ResponseData>> fetchReposList(@Path("user") String user, @Query("sort") String sort);
    Observable<List<ResponseData>> fetchReposList(@Path("user") String user, @Query("sort") String sort);
}

