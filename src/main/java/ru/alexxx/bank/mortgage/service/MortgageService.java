package ru.alexxx.bank.mortgage.service;

import ru.alexxx.bank.mortgage.controller.MortgageApplicationResponse;
import ru.alexxx.bank.mortgage.model.MortgageApplication;
import org.omg.PortableInterceptor.SUCCESSFUL;
import org.springframework.stereotype.Service;

@Service
public class MortgageService {

    private ComplianceChecker complianceChecker;
    private Checker financeChecker;
    private DebtHistoryChecker debtHistoryChecker;


    public MortgageService(ComplianceChecker complianceChecker, Checker financeChecker, DebtHistoryChecker debtHistoryChecker) {
        this.complianceChecker = complianceChecker;
        this.financeChecker = financeChecker;
        this.debtHistoryChecker = debtHistoryChecker;
    }

    public MortgageApplicationResponse check(MortgageApplication mortgageApplication) {

        MortgageApplicationResponse mortgageApplicationResponse = new MortgageApplicationResponse();
        mortgageApplicationResponse.setStatus(ApplicationStatus.SUCCESS);
        return mortgageApplicationResponse;
    }
}