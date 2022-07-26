package com.pref.core.parse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentProvider {

    private OnlinePayment onlinePayment;

    private MobilePayment mobilePayment;

    @Autowired
    public PaymentProvider(OnlinePayment onlinePayment, MobilePayment mobilePayment) {
        this.onlinePayment = onlinePayment;
        this.mobilePayment = mobilePayment;
    }

    public Payment getPaymentParser(boolean isMobile) {
        return isMobile ? mobilePayment : onlinePayment;
    }
}
