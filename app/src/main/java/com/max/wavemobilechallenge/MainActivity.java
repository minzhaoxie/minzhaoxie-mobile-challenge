package com.max.wavemobilechallenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.max.wavemobilechallenge.service.http.HttpMethods;
import com.max.wavemobilechallenge.service.model.Product;
import com.max.wavemobilechallenge.service.subscribers.ProgressSubscriber;
import com.max.wavemobilechallenge.service.subscribers.SubscriberOnNextListener;
import com.max.wavemobilechallenge.ui.adapter.ProductAdapter;

/**
 * Project name: WaveMobileChallenge
 * Created by Max on 2018-02-23.
 */
public class MainActivity extends AppCompatActivity {

    private ProductAdapter mAdapter;
    private SubscriberOnNextListener mSubscriberOnNext;
    private static final String BUSINESS_ID = "89746d57-c25f-4cec-9c63-34d7780b044b";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(initView());

        setResponse();
        sendRequest(BUSINESS_ID);
    }

    private View initView(){
        ListView listView = new ListView(this);
        mAdapter = new ProductAdapter(this);
        listView.setAdapter(mAdapter);
        listView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        return listView;
    }


    private void setResponse() {
        mSubscriberOnNext = new SubscriberOnNextListener<Product[]>() {
            @Override
            public void onNext(Product[] products) {
                if(products != null)
                mAdapter.setData(products);
            }
        };
    }

    private void sendRequest(String business_id) {
        HttpMethods.getInstance(this).getProducts(new ProgressSubscriber(mSubscriberOnNext, this), business_id);
    }

}
