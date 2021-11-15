package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;

public class ConvertList {

    /**
     * Конвертация листа массивов в один лист
     */
    public static List<Integer> convert(List<int[]> list) {
        List<Integer> rsl = new ArrayList<>();
        for (int[] elements : list) {
            for (int el : elements) {
                rsl.add(el);
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        List<String[]> names = new ArrayList<>();
        names.add(new String[] {"Petr", "Arsentev"});
        for (String[] row : names) {
            for (String cell : row) {
                System.out.println(cell);
            }
        }
    }
}
