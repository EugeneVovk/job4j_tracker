package ru.job4j.io;

import java.util.Scanner;

/**
 * У объекта Scanner есть метод nextLine(),
 * который считывает все символы строки после нажатия на клавишу Enter.
 */
public class Greeting {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Добро пожаловать. Как Вас зовут?");
        String name = input.nextLine();
        System.out.println(name + ", рад Вас видеть!");
    }
}
