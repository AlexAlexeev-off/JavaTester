package ru.alexxx.bank.mortgage.controller;

import ru.alexxx.bank.mortgage.service.ApplicationStatus;

import java.io.Serializable;

public class MortgageApplicationResponse implements Serializable {

    private String id;
    private ApplicationStatus status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MortgageApplicationResponse{" +
                "id='" + id + '\'' +
                ", status=" + status +
                '}';
    }
}