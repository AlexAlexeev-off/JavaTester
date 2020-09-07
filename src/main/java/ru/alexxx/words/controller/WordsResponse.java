package ru.alexxx.words.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class WordsResponse implements Serializable {

    private Long id;
    private Map<String, Long> mapCounts = new HashMap<>();

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Map<String, Long> getMapCounts() {
        return mapCounts;
    }
    public void setMapCounts(Map<String, Long> mapCounts) {
        this.mapCounts = mapCounts;
    }

    @Override
    public String toString() {
        return "WordsResponse{" +
                "id=" + id +
                ", mapCounts=" + mapCounts +
                '}';
    }
}
