package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

/**
 * В этом задании нужно реализовать предсказателя.
 * Пользователь вводит вопрос, программа генерирует случайное число
 * и выводит ответ на вопрос пользователя: да, нет, может быть.
 */
public class MagicBall {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        String ask = input.nextLine();
        int answer = new Random().nextInt(3);
        switch (answer) {
            case 0 -> System.out.println("Да");
            case 1 -> System.out.println("Нет");
            default -> System.out.println("Может быть");
        }
    }
}
