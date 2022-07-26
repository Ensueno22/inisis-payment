package com.pref.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URI;
import java.util.Map;

@FeignClient(value = "inisis-client", url = "http://inicis.com", configuration = InisisConfiguration.class)
public interface InisisClient {

    @PostMapping
    String approvalPayment(URI authUri, @RequestParam Map<String, String> request);

    @PostMapping
    String cancelPayment(URI cancelUri, @RequestParam Map<String, String> request);

}
