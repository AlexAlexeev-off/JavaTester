package ru.alexxx.user.deserializers;

import ru.alexxx.user.model.UserColecion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class UserDeserializaer {

    public UserColecion deserializaer(String filename) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(filename);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object object = ois.readObject();
        UserColecion userColecion = (UserColecion) object;
        System.out.println(userColecion);

        ois.close();
        fis.close();
        return userColecion;
    }
}
