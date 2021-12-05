package ru.job4j.list;

import java.util.List;

/**
 * Метод принимает два параметра - список и элемент, который предполагается,
 * что содержится в этом списке. Необходимо реализовать метод,
 * чтобы он возвращал результаты следующим образом:
 * 1. Элемента нет в списке - возвращает пустой список.
 * 2. Элемент в списке встречается 1 раз - возвращает пустой список.
 * 3. Элемент встречается более одного - возвращается список,
 * начиная с первого вхождения элемента
 * и заканчивая предшествующим последнему вхождению элемента в исходной коллекции.
 */
public class SubList {

    public static List<String> getElementsBetweenIndexes(List<String> list, String str) {
        List<String> rsl = list.subList(0, 0);
        int first = list.indexOf(str);
        int last = list.lastIndexOf(str);
        if (first != last) {
            rsl = list.subList(first, last);
        }
        return rsl;
    }
}
