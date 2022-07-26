package com.pref.controller;

import com.pref.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/test")
public class PaymentTestController {

    private final PaymentService service;

    @PostMapping("/hello")
    public String test(@RequestParam Map<String, String> response) {
        service.payInisisPayment(response, false);
        return "redirect:http://naver.com";
    }
}
