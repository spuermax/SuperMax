package com.example.network.request.rxjava;

public class NetException extends Exception {
    public int code;
    public String msg;
    public NetException(){}
    public NetException(int code,String msg){
        this.code = code;
        this.msg = msg;
    }
}
