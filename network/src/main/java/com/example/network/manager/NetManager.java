package com.example.network.manager;

public class NetManager {
    private static long connectTimeout,readTimeout,writeTimeout;
    private static String baseUrl;
    static Builder builde ;
    public static void init(Builder builder){
        connectTimeout = builder.connectTimeout;
        readTimeout = builder.readTimeout;
        writeTimeout = builder.writeTimeout;
        baseUrl = builder.baseUrl;
        builde =  builder;
    }

    public static class Builder{
        public long connectTimeout = 10 * 1000,readTimeout = 10 * 1000,writeTimeout = 10 * 1000;
        public String baseUrl;
        public Builder(String baseUrl){
            this.baseUrl = baseUrl.endsWith("/") ? baseUrl : baseUrl.concat("/");
        }

        public void connectTimeout(long connectTimeout) {
            this.connectTimeout = connectTimeout;
        }

        public void readTimeout(long readTimeout) {
            this.readTimeout = readTimeout;
        }

        public void writeTimeout(long writeTimeout) {
            this.writeTimeout = writeTimeout;
        }

        public void baseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
        }
    }
}
