package ru.alexxx.bank.mortgage.service;

import ru.alexxx.bank.mortgage.model.MortgageApplication;

public interface Checker {
    ApplicationStatus check(MortgageApplication application);
}