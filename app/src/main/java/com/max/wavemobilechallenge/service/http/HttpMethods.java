package com.max.wavemobilechallenge.service.http;

import android.content.Context;
import com.max.wavemobilechallenge.service.Retrofit.RetrofitHelper;
import com.max.wavemobilechallenge.service.Retrofit.RetrofitService;
import com.max.wavemobilechallenge.service.model.Product;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Project name: WaveMobileChallenge
 * Created by Max on 2018-02-23.
 */

public class HttpMethods {
    private RetrofitService mRetrofitService;
    private static HttpMethods instance = null;

    public HttpMethods(Context context){
        this.mRetrofitService = RetrofitHelper.getInstance(context).getServer();
    }

    public static HttpMethods getInstance(Context context) {
        if (instance == null){
            instance = new HttpMethods(context);
        }
        return instance;
    }

    private <T> void toSubscribe(Observable<T> o, Subscriber<T> s) {
        o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);
    }

    public void getProducts(Subscriber<Product[]> subscriber, String id) {
        Observable observable = mRetrofitService.getProducts(id);
        toSubscribe(observable, subscriber);
    }
}
