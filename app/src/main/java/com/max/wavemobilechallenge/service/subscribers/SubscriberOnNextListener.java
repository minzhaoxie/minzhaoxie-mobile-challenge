package com.max.wavemobilechallenge.service.subscribers;

/**
 * Project name: WaveMobileChallenge
 * Created by Max on 2018-02-23.
 */
public interface SubscriberOnNextListener<T> {
    void onNext(T t);
}
