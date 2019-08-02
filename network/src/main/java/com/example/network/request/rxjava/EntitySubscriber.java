package com.example.network.request.rxjava;

import org.reactivestreams.Subscription;

import io.reactivex.FlowableSubscriber;

public abstract class EntitySubscriber<T> implements FlowableSubscriber<T> {
    public Subscription s;

    public void start() {
    }

    public void end() {
    }

    public abstract void success(T t) ;

    public void error(Throwable e){} ;
    @Override
    public void onSubscribe(Subscription s) {
        this.s = s;
        s.request(1);
        start();
    }

    public Subscription subscription() {
        return s;
    }

    @Override
    public void onNext(T t) {
        success(t);
    }

    @Override
    public void onError(Throwable t) {
        error(t);
        end();
    }

    @Override
    public void onComplete() {
        end();
    }
}
