package com.max.wavemobilechallenge.service.Retrofit;

import android.content.Context;

import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * RetrofitHelper is for initialize retrofit.
 * Project name: WaveMobileChallenge
 * Created by Max on 2018-02-23.
 */

public class RetrofitHelper {
    private static final String BASE_URL = "https://api.waveapps.com/";
    private static final String ACCESS_TOKEN = "Bearer 6W9hcvwRvyyZgPu9Odq7ko8DSY8Nfm";
    private Context mCntext;

    GsonConverterFactory factory = GsonConverterFactory.create(new GsonBuilder().create());
    private static RetrofitHelper instance = null;
    private Retrofit mRetrofit = null;

    public static RetrofitHelper getInstance(Context context){
        if (instance == null){
            instance = new RetrofitHelper(context);
        }
        return instance;
    }
    private RetrofitHelper(Context mContext){
        mCntext = mContext;
        initRetrofit();
    }

    private void initRetrofit() {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        //adding access token to header
        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder()
                        .addHeader("Authorization", ACCESS_TOKEN) // add token
                        .build();
                return chain.proceed(request);
            }
        }).addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)) //Print okhttp activity
                .build();


        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(builder.build())
                .addConverterFactory(factory)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public RetrofitService getServer(){
        return mRetrofit.create(RetrofitService.class);
    }
}
