package ru.alexxx.lesson2;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //извиняюсь за такое большое кол-во кода при тестинге. Возможно стоило написать
        //метод для теста. Немного не успел
//        Box<Orange> or1 = new Box<>(new Orange(),new Orange(),new Orange(),new Orange());
//        Box<Orange> or2 = new Box<>(new Orange(),new Orange());
//        Box<Apple> ap1 = new Box<>(new Apple(),new Apple(),new Apple(),new Apple());
//        Box<Apple> ap2 = new Box<>(new Apple(),new Apple(),new Apple());
        Box<Orange> or1 = new Box<>();
        Box<Orange> or2 = new Box<>();
        Box<Apple> ap1 = new Box<>();
        Box<Apple> ap2 = new Box<>();
        System.out.println("Lesson2");
        System.out.println("'g' - addFruit: ");
        or1.addFruit(new Orange(),6);
        or2.addFruit(new Orange(),12);
        ap1.addFruit(new Apple(),9);
        ap2.addFruit(new Apple(),4);
        System.out.println("Box 1: "+or1.getWeight());
        System.out.println("Box 2: "+or2.getWeight());
        System.out.println("Box 3: "+ap1.getWeight());
        System.out.println("Box 4: "+ap2.getWeight());
        System.out.println("'e' - compare(): ");
        System.out.println("Box 1 equals box 3: "+or1.compare(ap1));
        System.out.println("Box 2 equals box 4: "+or2.compare(ap2));
        System.out.println("'f' - pourTo(): ");
        or1.pourTo(or2);
        ap1.pourTo(ap2);
        System.out.println("'d' - getWeight(): ");
        System.out.println("Box 1: "+or1.getWeight());
        System.out.println("Box 2: "+or2.getWeight());
        System.out.println("Box 3: "+ap1.getWeight());
        System.out.println("Box 4: "+ap2.getWeight());


    }
}