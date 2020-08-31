package ru.alexxx.user.deserializers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.alexxx.user.model.UserColecion;

import java.io.IOException;

class JsonUserDeserializaerTest {

    @Test
    void deserializaer() throws IOException, ClassNotFoundException {

        JsonUserDeserializaer jsonUserDeserializaer = new JsonUserDeserializaer();
        UserColecion users = jsonUserDeserializaer.deserializaer("C:\\Users\\user\\IdeaProjects\\JavaTester\\user.json");

        Assertions.assertTrue(users.getUsers().size() == 10);
        Assertions.assertEquals("Alex", users.getUsers().iterator().next().getName());

    }
}