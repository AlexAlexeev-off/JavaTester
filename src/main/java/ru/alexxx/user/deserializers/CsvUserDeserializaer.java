package ru.alexxx.user.deserializers;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import ru.alexxx.user.model.UserColecion;

import java.io.File;
import java.io.IOException;

public class CsvUserDeserializaer {
    public UserColecion deserializaer(String filename) throws IOException {

        CsvMapper csvMapper = new CsvMapper();
        File file = new File(filename);
        Object o = csvMapper.readerFor(UserColecion.class)
                .readValue(file);
        UserColecion userColecion = (UserColecion) o;
        System.out.println(userColecion);
        return userColecion;
    }
}
