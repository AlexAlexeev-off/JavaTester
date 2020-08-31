package ru.alexxx.user.deserializers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.alexxx.user.model.UserColecion;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class XmlUserDeserializaerTest {

    @Test
    void deserializaer() throws IOException, ClassNotFoundException {
        XmlUserDeserializaer xmlUserDeserializaer = new XmlUserDeserializaer();
        UserColecion users = xmlUserDeserializaer.deserializaer("C:\\Users\\user\\IdeaProjects\\JavaTester\\user.xml");

        Assertions.assertTrue(users.getUsers().size() == 10);
        Assertions.assertEquals("Alex", users.getUsers().iterator().next().getName());

    }
}