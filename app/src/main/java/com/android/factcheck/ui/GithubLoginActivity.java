package com.android.factcheck.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.android.factcheck.R;
import com.android.factcheck.server.FactCheckServerClient;
import com.android.factcheck.server.callback.GithubAccessTokenCallback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by divyanshunegi on 26/11/16.
 * Project : FactCheck
 */

public class GithubLoginActivity extends AppCompatActivity {

    private WebView githubWebView;
    private String loadUrlVal = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.github_login_activity);

        String githubId = getResources().getString(R.string.github_id);
        Log.e("TEST","GITHUB ID"+githubId);
        loadUrlVal = "https://github.com/login/oauth/authorize?scope=user:email&client_id="+githubId;

        Log.e("TEST","LOAD URL "+loadUrlVal);

        githubWebView = (WebView) findViewById(R.id.webView);
        githubWebView.getSettings().setJavaScriptEnabled(true);
        githubWebView.loadUrl(loadUrlVal);

        githubWebView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url){
                setupReturnsOnRedirect(view,url);
                return false;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }
        });
    }

    private void setupReturnsOnRedirect(WebView view ,String url) {

        if(url.contains("github")){

                view.loadUrl(url);

            }else{
                Uri uri = Uri.parse(url);
                String code = uri.getQueryParameter("code");
                getTheAccessToken(code);
            }

    }

    private void getTheAccessToken(String code) {

        final Intent returnIntent = new Intent();

        String githubId = getResources().getString(R.string.github_id);
        String githubSecret = getResources().getString(R.string.github_secret);

        Log.e("TEST","CODE : "+code);


        new FactCheckServerClient("https://github.com").getApi().getGithubAccessToken(githubId,githubSecret,code).enqueue(new Callback<GithubAccessTokenCallback>() {
            @Override
            public void onResponse(Call<GithubAccessTokenCallback> call, Response<GithubAccessTokenCallback> response) {
                returnIntent.putExtra("github_code",response.body().access_token);
                setResult(Activity.RESULT_OK,returnIntent);
                finish();
            }

            @Override
            public void onFailure(Call<GithubAccessTokenCallback> call, Throwable t) {
                returnIntent.putExtra("github_error_code",500);
                returnIntent.putExtra("github_error",t.getMessage());
                setResult(Activity.RESULT_OK,returnIntent);
                finish();
            }

        });
    }


}
