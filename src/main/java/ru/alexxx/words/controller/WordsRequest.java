package ru.alexxx.words.controller;

import java.io.Serializable;

public class WordsRequest implements Serializable {

    private Long idRequest;
    private String text;

    public WordsRequest(Long idRequest, String text) {
        this.idRequest = idRequest;
        this.text = text;
    }

    public Long getIdRequest() {
        return idRequest;
    }
    public void setIdRequest(Long idRequest) {
        this.idRequest = idRequest;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
}
