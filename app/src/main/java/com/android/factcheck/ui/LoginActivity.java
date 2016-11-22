package com.android.factcheck.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.android.factcheck.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void loginWithTwitter(View view) {
    }

    public void loginWithFacebook(View view) {
        startActivity(new Intent(LoginActivity.this,DashboardActivity.class));
        finish();
    }

    public void loginWithGithub(View view) {
    }

    public void loginWithGoogle(View view) {
    }
}
