package com.pref.controller;

import com.pref.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private final PaymentService service;

    @PostMapping("/inisis/appl")
    public void applInisisResponse(@RequestParam Map<String, String> response) {
        service.payInisisPayment(response, false);
    }

}
