package ru.job4j.ex;

/**
 * Диагностика NPE исключения проста.
 * В коде нужно проверить, что элемент не равен null.
 */
public class NPEx {
    public static void main(String[] args) {
        String[] shops = new String[5];
        shops[0] = "Petr Arsentev";
        for (int i = 0; i < shops.length; i++) {
            String el = shops[i];
            if (el != null) {
                System.out.println(el + " has a size : " + el.length());
            }
        }
    }
}
