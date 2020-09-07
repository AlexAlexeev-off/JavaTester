package ru.alexxx.bank.mortgage.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.alexxx.bank.mortgage.controller.MortgageApplicationResponse;
import ru.alexxx.bank.mortgage.model.MortgageApplication;

import static org.junit.jupiter.api.Assertions.*;

class MortgageServiceTest {

    @Test
    void check() {
        MortgageService mortgageService = new MortgageService(null, null, null);

        MortgageApplicationResponse check = mortgageService.check(new MortgageApplication());

        Assertions.assertEquals(ApplicationStatus.SUCCESS, check.getStatus());
    }
}