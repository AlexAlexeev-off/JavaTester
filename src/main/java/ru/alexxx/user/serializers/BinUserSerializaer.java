package ru.alexxx.user.serializers;

import ru.alexxx.user.model.UserColecion;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class BinUserSerializaer implements UserSerializaer {

    public void serialize(UserColecion userColecion, String fileName){
        FileOutputStream faos = null;
        ObjectOutputStream ous = null;


        try {
            faos = new FileOutputStream(fileName);
            try {
                ous = new ObjectOutputStream(faos);
                ous.writeObject(userColecion);
            } catch (IOException e) {
                e.printStackTrace();
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                ous.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                faos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


}
