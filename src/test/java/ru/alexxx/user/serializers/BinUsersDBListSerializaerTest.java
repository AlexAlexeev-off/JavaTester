package ru.alexxx.user.serializers;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.alexxx.user.model.User;
import ru.alexxx.user.model.UserColecion;

import java.io.File;
import java.util.ArrayList;

class BinUsersDBListSerializaerTest {

    @Test
    void serialize() {
        UserColecion userColecion = prepareTestData();
        BinUserSerializaer binUserSerializaer = new BinUserSerializaer();
        binUserSerializaer.serialize(userColecion, "user.txt");
        Assertions.assertTrue(new File("user.txt").exists());
    }
    @Test
    void jsonSerializeTest() {
        UserColecion userColecion = prepareTestData();
        JsonUserSerializaer jsonUserSerializaer = new JsonUserSerializaer();
        jsonUserSerializaer.serialize(userColecion, "user.json");
        Assertions.assertTrue(new File("user.json").exists());
    }
    @Test
    void xmlSerializeTest() {
        UserColecion userColecion = prepareTestData();
        XmlUserSerializaer xmlUserSerializaer = new XmlUserSerializaer();
        xmlUserSerializaer.serialize(userColecion, "user.xml");
        Assertions.assertTrue(new File("user.xml").exists());
    }
    @Test
    void csvSerializeTest() {
        UserColecion userColecion = prepareTestData();
        CsvUserSerializaer csvUserSerializaer = new CsvUserSerializaer();
        csvUserSerializaer.serialize(userColecion, "user.csv");
        Assertions.assertTrue(new File("user.csv").exists());
    }

    private UserColecion prepareTestData() {
        User Alex = new User();
        Alex.setId(1);
        Alex.setName("Alex");
        Alex.setEmail("alex@mail.ru");

        User Ivan = new User();
        Ivan.setId(2);
        Ivan.setName("Ivan");
        Ivan.setEmail("ivan@mail.ru");

        User Sasha = new User();
        Sasha.setId(3);
        Sasha.setName("Sasha");
        Sasha.setEmail("sasha@mail.ru");

        User Andry = new User();
        Andry.setId(4);
        Andry.setName("Andry");
        Andry.setEmail("andry@mail.ru");

        User Vova = new User();
        Vova.setId(5);
        Vova.setName("Vova");
        Vova.setEmail("vova@mail.ru");

        User Olga = new User();
        Olga.setId(6);
        Olga.setName("Olga");
        Olga.setEmail("olga@mail.ru");

        User Elena = new User();
        Elena.setId(7);
        Elena.setName("Elena");
        Elena.setEmail("elena@mail.ru");

        User Yura = new User();
        Yura.setId(8);
        Yura.setName("Yura");
        Yura.setEmail("yura@mail.ru");

        User Varya = new User();
        Varya.setId(9);
        Varya.setName("Varya");
        Varya.setEmail("varya@mail.ru");

        User Dima = new User();
        Dima.setId(10);
        Dima.setName("Dima");
        Dima.setEmail("dima@mail.ru");

        UserColecion userColecion = new UserColecion();
        userColecion.setUsers(new ArrayList<User>());
        userColecion.getUsers().add(Alex);
        userColecion.getUsers().add(Ivan);
        userColecion.getUsers().add(Sasha);
        userColecion.getUsers().add(Andry);
        userColecion.getUsers().add(Vova);
        userColecion.getUsers().add(Olga);
        userColecion.getUsers().add(Elena);
        userColecion.getUsers().add(Yura);
        userColecion.getUsers().add(Varya);
        userColecion.getUsers().add(Dima);
        return userColecion;
    }
}