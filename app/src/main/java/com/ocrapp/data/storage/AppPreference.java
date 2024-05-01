package com.ocrapp.data.storage;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import com.securepreferences.SecurePreferences;
import com.ocrapp.ui.main.model.User;

import java.lang.reflect.Type;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class AppPreference {
    private static String APP_USER_DATA = "app_user_data";
    private static SecurePreferences mSecurePrefs = null;
    private static AppPreference appPreference = null;

    private AppPreference(Context context) {
        if (mSecurePrefs == null) {
            mSecurePrefs = new SecurePreferences(context, generateSecureKey(context), "naytiv_prefs.xml");
        }
    }

    public static AppPreference getInstance(Context context) {
        if (appPreference == null) {
            appPreference = new AppPreference(context);
        }
        return appPreference;
    }

    private static String generateSecureKey(Context context) {
        String key = "";
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(
                    context.getPackageName(),
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                key = Base64.encodeToString(md.digest(), Base64.DEFAULT);
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return key;
    }


    public void saveString(String key, String value){
        mSecurePrefs.edit().putString(key,value).apply();
    }

    public String getString(String key){
        return mSecurePrefs.getString(key,"");
    }

    public void saveBoolean(String key, boolean value){
        mSecurePrefs.edit().putBoolean(key,value).apply();
    }
    public boolean getBoolean(String key){
        return mSecurePrefs.getBoolean(key,false);
    }
    public void saveUser(User userData){
        mSecurePrefs.edit().putString(APP_USER_DATA, new Gson().toJson(userData)).apply();
    }
    public User getUser(){
       return  new Gson().fromJson(mSecurePrefs.getString(APP_USER_DATA, "{}"), User.class);
    }
    public void clearData(){

        mSecurePrefs.edit().clear().commit();
       // mSecurePrefs.edit().apply();
    }






    public static void setLabelValue(@NonNull Context context, String key, String value) {
       // Pref.openPref(context);
       // SharedPreferences.Editor prefsPrivateEditor = Pref.sharedPreferences.edit();
        //mSecurePrefs.putString(key, value).apply();
        mSecurePrefs.edit().putString(key,value).apply();
      /*  prefsPrivateEditor.commit();
        prefsPrivateEditor = null;
        Pref.sharedPreferences = null;*/
    }

    public static String getLabelValue(@NonNull Context context, String key, String defaultValue, String mapKey) {
        //Pref.openPref(context);
        String result = "0";
        Gson gson = new Gson();
        String hashMapString = /*Pref.sharedPreferences.getString(key, defaultValue);*/mSecurePrefs.getString(key,defaultValue);

        Type type = new TypeToken<HashMap<String, String>>() {
        }.getType();
        try {

            HashMap<String, String> hashMap = gson.fromJson(hashMapString, type);

            result = hashMap.get(mapKey);

            if (result == null) {
                result = defaultValue;
            }

            //Pref.sharedPreferences = null;

        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        return result;
    }




}
