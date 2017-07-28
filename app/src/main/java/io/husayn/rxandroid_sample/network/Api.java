package io.husayn.rxandroid_sample.network;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by husaynhakeem on 7/28/17.
 */

public class Api {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    private static Api instance;
    private ApiInterface apiInterface;


    public static Api instance() {
        if (instance == null)
            instance = new Api();
        return instance;
    }


    private Api() {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();
        apiInterface = retrofit.create(ApiInterface.class);
    }


    public ApiInterface apiInterface() {
        return apiInterface;
    }
}
