package ru.job4j.collection;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Создание справочника подразделений
 * Этот класс будет добавлять пропущенные подразделения,
 * а также проводить их сортировку
 */
public class Departments {

    /**
     * Чтобы реализовать метод fillGaps, нужно определить, какие элементы отсутствуют в системе.
     * Для этого каждую входящую строку нужно разбить на одиночные элементы.
     * Для этого можно использовать метод String.split("/").
     * Этот метод вернет массив одиночных элементов.
     * Далее нужно через цикл последовательно складывать элементы и добавлять их в множество.
     * Используйте в качестве промежуточного хранения LinkedHashSet.
     *
     * @param deps
     * @return
     */
    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                tmp.add(start + "/" + el);
            }
        }
        return new ArrayList<>(tmp);
    }

    public static void sortAsc(List<String> orgs) {

    }

    public static void sortDesc(List<String> orgs) {

    }
}
