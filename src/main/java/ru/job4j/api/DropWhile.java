package ru.job4j.api;

import java.util.List;

/**
 * Stream.dropWhile - этот метод позволяет получать поток данных после того,
 * как условие стало ложным
 */
public class DropWhile {
    public static void main(String[] args) {
        List.of(1, 2, 3, 4).stream()
                .dropWhile(v -> v < 3)
                .map(v -> "Результат: " + v)
                .forEach(System.out::println);
    }
}
