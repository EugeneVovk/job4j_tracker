package ru.job4j.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Метод принимает строку, которая может содержать несколько пробелов,
 * однако в ней отсутствуют знаки препинания.
 * Необходимо реализовать метод, который вернет символ в строке,
 * который употребляется наибольшее количество раз.
 * Если окажется что таких символов несколько - необходимо вернуть первый из символов.
 * Чтобы обеспечить сортировку символов - собирайте исходную строку в TreeMap(),
 * в которой ключ - это символ, значение - количество.
 * Перед тем как собирать строку ее нужно привести к нижнему регистру, удалить пробелы.
 * Для того чтобы собрать строку в отображение используйте методы computeIfPresent() и putIfAbsent()
 * - первый обновит значение частотности употребления символа,
 * второй - вставит пару ключ(символ) значение(1) - если такого символа в отображении еще нет.
 */
public class MostUsedCharacter {
    public static char getMaxCount(String str) {
        Map<Character, Integer> map = new TreeMap<>();
        char[] chars = str
                .replaceAll("\\s+", "")
                .toLowerCase()
                .toCharArray();
        for (Character ch : chars) {
            map.computeIfPresent(ch, (k, v) -> v + 1);
            map.putIfAbsent(ch, 1);
        }
        char rsl = ' ';
        int maxCounter = 0;
        for (Character ch : map.keySet()) {
            if (map.get(ch) > maxCounter) {
                rsl = ch;
                maxCounter = map.get(ch);
            }
        }
        return rsl;
    }
}
