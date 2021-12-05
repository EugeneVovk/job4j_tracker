package ru.job4j.list;

import java.util.List;

/**
 * Необходимо реализовать метод, который вернет список строк,
 * которые состоят из 5 и более символов.
 */
public class RemoveIf {
    public static List<String> sortList(List<String> list) {
        list.removeIf(s -> s.length() < 5);
        return list;
    }
}
