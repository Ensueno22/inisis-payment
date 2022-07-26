package com.pref.core.parse;

import java.util.Map;

public interface Payment {

    // client로 요청 parameter
    boolean approveRequest(Map<String, String> request);

    void afterApproval(String response);

}
