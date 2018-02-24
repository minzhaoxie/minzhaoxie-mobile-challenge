package com.max.wavemobilechallenge.service.Retrofit;


import com.max.wavemobilechallenge.service.model.Product;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Project name: WaveMobileChallenge
 * Created by Max on 2018-02-23.
 */

public interface RetrofitService {

    @GET("businesses/{business_id}/products/")
    Observable<Product[]> getProducts(@Path("business_id") String business_id);

}
