package ru.job4j.ex;

/**
 * Здесь используется блок if-else-throw.
 * Давайте разберем его на части. Здесь производится проверка данных.
 * Если данные введены верно, то выполнить действие, если нет, то кинуть исключение.
 * По сути оператор if-else связывает исключение и полезный код.
 * Такую конструкцию всегда стоит разбивать на две части:
 * - на блок if-throw
 * - и полезную часть.
 */
public class Config {
    /**
     * Первостепенно мы отделили валидацию от полезного кода.
     * Во вторых код стал меньше и понятнее.
     */
    public static void load(String path) {

        if (path == null) {
            throw new IllegalArgumentException("Path could not by null.");
        }
        System.out.println("load config by " + path);
    }

    public static void main(String[] args) {
        load("jdbc://localhost:8080");
    }
}
