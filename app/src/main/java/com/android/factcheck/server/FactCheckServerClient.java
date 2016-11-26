package com.android.factcheck.server;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by divyanshunegi on 11/14/16.
 * Project : QuestionaireApp
 */
public class FactCheckServerClient {

    private final Retrofit retrofit;
    private static FactCheckServerClient _instance;
    private API api;

    public FactCheckServerClient(String url) {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

    }

    public API getApi() {
        api = retrofit.create(API.class);
        return api;
    }

}
