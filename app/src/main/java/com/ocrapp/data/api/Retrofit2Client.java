package com.ocrapp.data.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.ocrapp.data.ViewVatorConstants;

import java.util.concurrent.TimeUnit;

public class Retrofit2Client {
    private static Retrofit2Client instance = null;
    private Retrofit retrofit;
    private OkHttpClient client;

    private ApiService apiService;

    public Retrofit2Client() {

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();
       // okHttpBuilder.addInterceptor(new TokenInterceptor());

        okHttpBuilder.connectTimeout(60, TimeUnit.SECONDS);
        okHttpBuilder.readTimeout(60, TimeUnit.SECONDS);
        okHttpBuilder.writeTimeout(60, TimeUnit.SECONDS);
        okHttpBuilder.addInterceptor(loggingInterceptor);
        /*if (BuildConfig.DEBUG) {

        }*/

        client = okHttpBuilder.build();

        retrofit = new Retrofit.Builder().baseUrl(ViewVatorConstants.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        apiService = retrofit.create(ApiService.class);
    }

    public static Retrofit2Client getInstance() {
        if (instance == null) {
            instance = new Retrofit2Client();
        }

        return instance;
    }

    public ApiService getApiService() {
        return apiService;
    }
}
