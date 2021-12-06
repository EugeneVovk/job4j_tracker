package ru.job4j.map;

import java.util.*;

/**
 * Метод принимает строку, при этом слова могут содержать как строчные символы,
 * так и прописные. При реализации необходимо игнорировать пробелы во входной строке.
 * Необходимо реализовать метод, который вернет отображение,
 * в котором ключом будет символ из строки, а значением - список индексов,
 * под которыми этот символ (если таких символов несколько) входит в исходную строку.
 * Важно: строчные и прописные символы считаются разными символами.
 */
public class Concordance {
    public static Map<Character, List<Integer>> collectCharacters(String str) {
        Map<Character, List<Integer>> map = new LinkedHashMap<>();
        str = str.replaceAll("\\s+", "");
        char[] array = str.toCharArray();
        for (int i = 0; i < array.length; i++) {
            map.putIfAbsent(array[i], new ArrayList<>());
            map.get(array[i]).add(i);
        }
        return map;
    }
}
