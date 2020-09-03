package ru.alexxx.user.serializers;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import ru.alexxx.user.model.UserColecion;

import java.io.File;
import java.io.IOException;

public class CsvUserSerializaer implements UserSerializaer{
    public void serialize(UserColecion userColecion, String fileName) {
        CsvMapper csvMapper = new CsvMapper();
        File out = new File("user.csv");
        try {
            csvMapper.writerFor(UserColecion.class).writeValue(out, userColecion);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
