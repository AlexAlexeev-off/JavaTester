package ru.alexxx.user.serializers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import ru.alexxx.user.model.UserColecion;

import java.io.File;
import java.io.IOException;

public class XmlUserSerializaer implements UserSerializaer{
    public void serialize(UserColecion userColecion, String fileName) {
        XmlMapper xmlMapper = new XmlMapper();
        File out = new File("user.xml");
        try {
            xmlMapper.writerFor(UserColecion.class).writeValue(out, userColecion);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
