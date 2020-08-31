package ru.alexxx.user.serializers;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.alexxx.user.model.UserColecion;

import java.io.File;
import java.io.IOException;

public class JsonUserSerializaer implements UserSerializaer{
    public void serialize(UserColecion userColecion, String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        File out = new File("user.json");
        try {
            objectMapper.writerFor(UserColecion.class).writeValue(out, userColecion);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
