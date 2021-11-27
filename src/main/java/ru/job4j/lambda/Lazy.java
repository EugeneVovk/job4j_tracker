package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Ленивая загрузка.
 * Лямбда вызывается, когда в массиве есть более одного значения,
 * чтобы было то, что нужно сортировать.
 * Лямбда вычисляется, когда вызывается метод у функционального интерфейса,
 * например метод compare().
 * Это свойство увеличивает скорость программы.
 */
public class Lazy {
    public static void main(String[] args) {
        String[] names = {
                "Ivan",
                "Petr"
        };
        Comparator<String> lengthCmp = (left, right) -> {
            System.out.println("execute comparator");
            return Integer.compare(left.length(), right.length());
        };
        Arrays.sort(names, lengthCmp);
    }
}
