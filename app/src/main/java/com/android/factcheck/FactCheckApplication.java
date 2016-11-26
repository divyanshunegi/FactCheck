package com.android.factcheck;

import android.app.Application;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import io.fabric.sdk.android.Fabric;

/**
 * Created by divyanshunegi on 11/22/16.
 * Project : FactCheck
 */
public class FactCheckApplication extends Application {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "pPV6ZrKPzCR3XQTYMB8gKUDaG";
    private static final String TWITTER_SECRET = "PVnYdKrpGCr9uVwtzXZyBYQ5viLZfY6g4bvd47StCuCw7ky5yF";


    @Override
    public void onCreate() {
        super.onCreate();
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));
    }
}
