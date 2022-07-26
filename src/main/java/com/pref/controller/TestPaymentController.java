package com.pref.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestPaymentController {

    @GetMapping
    public String testInisisPage() {
        return "inisis";
    }

    @GetMapping("/mobile")
    public String mobilePage() {
        return "mobile";
    }

}
