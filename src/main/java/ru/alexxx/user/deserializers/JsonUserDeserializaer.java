package ru.alexxx.user.deserializers;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.alexxx.user.model.UserColecion;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class JsonUserDeserializaer {

    public UserColecion deserializaer(String filename) throws IOException, ClassNotFoundException {

        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(filename);

        Object o = objectMapper.readerFor(UserColecion.class)
                .readValue(file);
        UserColecion userColecion = (UserColecion) o;
        System.out.println(userColecion);
        return userColecion;
    }
}
