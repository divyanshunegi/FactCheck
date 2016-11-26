package com.android.factcheck.server.callback;

import com.google.gson.annotations.SerializedName;

/**
 * Created by divyanshunegi on 11/26/16.
 * Project : FactCheck
 */
public class GithubAccessTokenCallback {

    @SerializedName("access_token")
    public String access_token;
    @SerializedName("scope")
    public String scope;
    @SerializedName("token_type")
    public String token_type;
    @SerializedName("error")
    public String error;
    @SerializedName("error_description")
    public String error_description;
    @SerializedName("error_uri")
    public String error_uri;
}
