package ru.alexxx.user.deserializers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.alexxx.user.model.UserColecion;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class UserDeserializaerTest {

    @Test
    void deserializaer() throws IOException, ClassNotFoundException {
        UserDeserializaer userDeserializaer = new UserDeserializaer();
        UserColecion users = userDeserializaer.deserializaer("C:\\Users\\user\\IdeaProjects\\JavaTester\\user.txt");

        Assertions.assertTrue(users.getUsers().size() == 10);
        Assertions.assertEquals("Alex", users.getUsers().iterator().next().getName());



    }
}