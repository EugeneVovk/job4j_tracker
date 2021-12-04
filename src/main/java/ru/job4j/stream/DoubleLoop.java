package ru.job4j.stream;

import java.util.stream.Stream;

public class DoubleLoop {
    public static void main(String[] args) {
        String[] levels = {"level 1", "level 2", "level 3"};
        String[] tasks = {"task 1", "task 2", "task 3", "task 4"};
        /* Дано: два массива. Нужно вывести все элементы каждый с каждым.*/
        for (String level : levels) {
            for (String task : tasks) {
                System.out.println(level + " " + task);
            }
        }
        /*Это же решение можно переписать в виде потока.*/
        Stream.of(levels)
                .flatMap(level -> Stream.of(tasks)
                .map(task -> level + " " + task))
                .forEach(System.out::println);
    }
}
