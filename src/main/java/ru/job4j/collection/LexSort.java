package ru.job4j.collection;

import java.util.Comparator;

/**
 * Сортировка по номеру
 */
public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] arrayL = left.split("\\.");
        String[] arrayR = right.split("\\.");

        return Integer.compare(Integer.parseInt(arrayL[0]), Integer.parseInt(arrayR[0]));
    }
}