package com.ocrapp.ui.main.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.ocrapp.R;
import com.ocrapp.data.ViewVatorConstants;
import com.ocrapp.data.storage.AppPreference;
import com.ocrapp.data.storage.AppPreferenceKey;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        FirebaseApp.initializeApp(SplashActivity.this);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                if(AppPreference.getInstance(getApplication()).getBoolean(AppPreferenceKey.IS_FIRST_TIME))
                {
                    startActivity(new Intent(SplashActivity.this, SelectOptionActivity.class));
                    /*if(AppPreference.getInstance(getApplication()).getBoolean("isLogin")){
                        startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    }else{
                        startActivity(new Intent(SplashActivity.this, SignInActivity.class));
                    }*/
                }else {
                    startActivity(new Intent(SplashActivity.this, SelectOptionActivity.class));
                   // startActivity(new Intent(SplashActivity.this, IntroStepActivity.class));
                }

                finish();
            }
        }, 1500);
    }
}