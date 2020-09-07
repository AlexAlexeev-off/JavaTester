package ru.alexxx.words;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.util.FileUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.alexxx.words.controller.WordsRequest;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@AutoConfigureMockMvc
class WordsApplicationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void contextLoads() {
    }

    @Test
    void check() throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        WordsRequest wordsRequest = new WordsRequest(1L,"Grut! I am grut!");

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
        .post("/wordscounter")
        .content(objectMapper.writerFor(WordsRequest.class).writeValueAsString(wordsRequest))
        .contentType("application/json")
        );

        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
        //Assertions.assertThat(resultActions.andReturn().getResponse().getContentAsString()).isEqualTo();
        assertThat(resultActions.andReturn().getResponse().getContentAsString()).isEqualTo("{\"idRequest\":1, \"mapCounts\":{\"i\":1,\"grut\":2, \"am\":1}}");


        //String data = FileUtil.readAsString(new File(String.valueOf(this.getClass().getClassLoader().getResource("lords.txt"))));
        //wordsRequest = new WordsRequest(2L, data);
        //


    }

}