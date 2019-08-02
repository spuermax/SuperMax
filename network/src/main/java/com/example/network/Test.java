package com.example.network;

import com.example.network.manager.NetManager;
import com.example.network.manager.NetRequest;
import com.example.network.request.rxjava.EntitySubscriber;

import org.reactivestreams.Subscription;

import java.util.HashMap;

public class Test {
    public static void main(String[] args){
        String serverBaseAddress = "http://www.baidu.com";
        NetManager.init(new NetManager.Builder(serverBaseAddress));
        EntitySubscriber<String> s = new EntitySubscriber<String>() {
            @Override
            public void start() {
                super.start();
            }

            @Override
            public void end() {
                super.end();
            }

            @Override
            public void success(String s) {
                System.out.println(s);
            }

            @Override
            public void error(Throwable e) {
                System.err.println(e.toString());
            }
        };
        Subscription subscription = s.subscription();

        NetRequest.retrofitRequest().get(String.class)
                .subscribe(s);
    }
}
