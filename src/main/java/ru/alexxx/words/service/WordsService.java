package ru.alexxx.words.service;

import org.springframework.stereotype.Service;
import ru.alexxx.words.controller.WordsRequest;
import ru.alexxx.words.controller.WordsResponse;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WordsService {

    public Map<String, Long> countWords(String input){

        List<String> listString = Arrays.asList(input.toLowerCase().split("//W+"));
        Map<String, Long> result = new HashMap<>();
        for (String el : listString){
            if (result.containsKey(el)) {
                Long currentCount = result.get(el);
                result.put(el, currentCount +1);
            } else {
                result.put(el, 1L);
            }

        }

        return result;
    }

}
