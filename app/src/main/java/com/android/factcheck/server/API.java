package com.android.factcheck.server;


import com.android.factcheck.server.callback.GithubAccessTokenCallback;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by divyanshunegi on 11/14/16.
 * Project : QuestionaireApp
 */
public interface API {

    @Headers({
            "Accept: application/json",
            "Content-Type: application/x-www-form-urlencoded"
    })
    @FormUrlEncoded
    @POST("/login/oauth/access_token")
    Call<GithubAccessTokenCallback> getGithubAccessToken(@Field("client_id") String client_id, @Field("client_secret") String client_secret, @Field("code") String code);

}
