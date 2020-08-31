package ru.alexxx.user.deserializers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import ru.alexxx.user.model.UserColecion;

import java.io.File;
import java.io.IOException;

public class XmlUserDeserializaer {
    public UserColecion deserializaer(String filename) throws IOException, ClassNotFoundException {

        XmlMapper xmlMapper = new XmlMapper();
        File file = new File(filename);

        Object o = xmlMapper.readerFor(UserColecion.class)
                .readValue(file);
        UserColecion userColecion = (UserColecion) o;
        System.out.println(userColecion);
        return userColecion;
    }
}
