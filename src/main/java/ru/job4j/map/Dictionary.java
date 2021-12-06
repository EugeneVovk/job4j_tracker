package ru.job4j.map;

import java.util.*;

/**
 * В данном задании необходимо реализовать словарь.
 * Метод принимает массив строк.
 * Необходимо перебрать массив и добавить строки в карту таким образом,
 * чтобы ключом был первый символ строки, а значением - список строк,
 * которые начинаются на первый символ строки.
 */
public class Dictionary {

    public static Map<String, List<String>> collectData(String[] strings) {
        Map<String, List<String>> rsl = new HashMap<>();
        for (String str : strings) {
            String firstChar = String.valueOf(str.charAt(0));
            rsl.putIfAbsent(firstChar, new ArrayList<>());
            rsl.get(firstChar).add(str);
        }
        return rsl;
    }
}
