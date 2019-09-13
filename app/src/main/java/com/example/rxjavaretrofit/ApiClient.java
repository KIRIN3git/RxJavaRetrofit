package com.example.rxjavaretrofit;

import android.util.Log;

import java.util.List;
import java.util.Random;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {


    static String BASE_URL ="https://api.github.com/";
    static String ACCOUNT_NAME = "KIRIN3git";


    public static Retrofit restClient(){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static Response<List<ResponseData>> fetchResponsLit(){

        /*
        ResponseService service = restClient().create(ResponseService.class);
        try {
            return service.fetchReposList(ACCOUNT_NAME, "desc").execute();

        }
        catch (Exception e){
            Log.w("DEBUG_DATA","e" + e.toString());
            return null;
        }
        */

        ResponseService service = restClient().create(ResponseService.class);


        Observable<List<ResponseData>> repos = service.fetchReposList(ACCOUNT_NAME, "desc");

        repos
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                list -> {
                    Thread.sleep( 1000);
                    Log.w("DEBUG_DATA",list.get(0).name);
                    },
                throwable -> {Log.w("DEBUG_DATA","throwable" + throwable.toString());},
                () -> {Log.w("DEBUG_DATA","comp");}
        );


        return null;

    }


}


