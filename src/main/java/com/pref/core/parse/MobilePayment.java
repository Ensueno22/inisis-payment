package com.pref.core.parse;

import org.springframework.stereotype.Component;

import java.util.Map;


@Component
public class MobilePayment implements Payment {

    @Override
    public boolean approveRequest(Map<String, String> request) {
        return false;
    }

    @Override
    public void afterApproval(String response) {

    }
}
