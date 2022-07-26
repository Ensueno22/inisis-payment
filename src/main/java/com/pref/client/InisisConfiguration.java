package com.pref.client;

import feign.RequestInterceptor;

public class InisisConfiguration {

    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> requestTemplate.header("Content-Type", "application/x-www-form-urlencoded");
    }

}
