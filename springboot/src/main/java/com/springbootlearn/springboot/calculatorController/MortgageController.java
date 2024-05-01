package com.springbootlearn.springboot.calculatorController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MortgageController {
    @RequestMapping("/mortgage")
    public String showForm() {
        return "mortgageForm";
    }
    @PostMapping("/calculate-mortgage")
    @ResponseBody
    public String calculateMortgage(
            @RequestParam("principal") double principal,
            @RequestParam("interestRate") double interestRate,
            @RequestParam("years") int years) {
        // Calculate monthly mortgage payment
        double monthlyRate = interestRate / 100 / 12;
        int months = years * 12;
        double monthlyPayment = principal * monthlyRate / (1 - Math.pow(1 + monthlyRate, -months));
        return String.format("Monthly Mortgage Payment: %.2f", monthlyPayment);
    }
}
