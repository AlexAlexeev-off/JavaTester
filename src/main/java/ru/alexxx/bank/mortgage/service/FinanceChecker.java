package ru.alexxx.bank.mortgage.service;

import ru.alexxx.bank.mortgage.IronBankApplication;
import ru.alexxx.bank.mortgage.model.MortgageApplication;
import org.springframework.stereotype.Service;

@Service
public class FinanceChecker implements Checker {

    @Override
    public ApplicationStatus check(MortgageApplication application){




        return ApplicationStatus.SUCCESS;
    }


}