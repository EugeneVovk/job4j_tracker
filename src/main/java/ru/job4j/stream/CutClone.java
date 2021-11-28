package ru.job4j.stream;


import java.util.ArrayList;
import java.util.List;

/**
 * В Stream API есть интересный метод distinct(). Он позволяет убрать дублирующие элементы.
 */
public class CutClone {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Ivan");
        names.add("Stepan");
        names.add("Petrucho");
        names.add("Ivan");
        names.stream()
                .distinct()
                .forEach(System.out::println);
    }
}
