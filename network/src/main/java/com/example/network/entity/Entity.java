package com.example.network.entity;

import com.example.network.utils.MGson;

public class Entity<T> {
    public int code;
    public String msg;
    public T data;

    @Override
    public String toString() {
        return MGson.toJson(this);
    }
}
