package ru.alexxx.bank.mortgage.controller;

import ru.alexxx.bank.mortgage.model.MortgageApplication;
import ru.alexxx.bank.mortgage.service.MortgageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MortgageController {

    private MortgageService mortgageService;

    public MortgageController(MortgageService mortgageService) {
        this.mortgageService = mortgageService;
    }

    @PostMapping("/mortgage")
    public MortgageApplicationResponse checkMortgage(MortgageApplication mortgageApplication){

        return mortgageService.check(mortgageApplication);


    }



}