package ru.alexxx.words.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.alexxx.words.service.WordsService;

import java.util.Map;

@RestController
public class WordsController {

    private final WordsService wordsService;

    public WordsController(WordsService wordsService) {
        this.wordsService = wordsService;
    }

    @PostMapping("/wordscounter")
    public WordsResponse wordsCounter(@RequestBody WordsRequest wordsRequest){
        Map<String, Long> stringLongMap = wordsService.countWords(wordsRequest.getText());
        WordsResponse wordsResponse = new WordsResponse();
        wordsResponse.setId(wordsRequest.getIdRequest());
        wordsResponse.setMapCounts(stringLongMap);
        return wordsResponse;
    }

}
