package ru.alexxx.bank.mortgage.service;

import ru.alexxx.bank.mortgage.controller.MortgageApplicationResponse;
import ru.alexxx.bank.mortgage.model.MortgageApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringMortgageServiceTest {

    @Autowired
    MortgageService mortgageService;


    @Test
    void check() {
        MortgageApplicationResponse check = mortgageService.check(new MortgageApplication());

        Assertions.assertEquals(ApplicationStatus.SUCCESS, check.getStatus());
    }
}