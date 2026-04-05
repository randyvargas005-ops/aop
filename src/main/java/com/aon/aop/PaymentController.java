package com.aon.aop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/pay")
    public String pay(@RequestParam double amount) throws InterruptedException {
        paymentService.processPayment(amount);
        return "Payment done!";
    }

    @GetMapping("/discount")
    public String discount(@RequestParam int price, @RequestParam int percentage) {
        int discounted = paymentService.calculateDiscount(price, percentage);
        return "Discounted price: " + discounted;
    }
}
