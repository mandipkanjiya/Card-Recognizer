package com.ocrapp;

import android.app.Application;

import com.ocrapp.data.api.Retrofit2Client;


public class OCRApp extends Application {
   // public static FirebaseAnalytics mFirebaseAnalytics;
    public static Retrofit2Client instance = null;
    public static OCRApp app = null;

    private String key="";
    @Override
    public void onCreate() {
        super.onCreate();
        //mFirebaseAnalytics = Firebaseana.getInstance(this);
         app=this;

    }

    public static OCRApp getApp() {
        return app;
    }

    public static Retrofit2Client getRetrofit(){
        if(instance == null){
            instance = new Retrofit2Client();
            return instance ;
        }else {
            return instance;
        }
    }


}
