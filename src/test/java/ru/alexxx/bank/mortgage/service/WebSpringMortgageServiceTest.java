package ru.alexxx.bank.mortgage.service;

import ru.alexxx.bank.mortgage.controller.MortgageApplicationResponse;
import ru.alexxx.bank.mortgage.model.MortgageApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class WebSpringMortgageServiceTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void check() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/mortgage")
                .content("{ \"name\":\"Yuri\" }")
                .contentType("application/json")
        ).andExpect(MockMvcResultMatchers.status().isOk());

        String contentAsString = mockMvc.perform(MockMvcRequestBuilders.get("/mortgages"))
                .andReturn()
                .getResponse()
                .getContentAsString();


     /*   MortgageList response = objectMapper.readValue(contentAsString, MortgageList.class);
        Assertions.assertEquals(ApplicationStatus.SUCCESS, check.getStatus());*/

    }
}