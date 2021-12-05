package ru.job4j.list;

import java.util.List;

/**
 * Необходимо реализовать метод, который будет возвращать первую строку из коллекции строк,
 * но прежде чем получить результат - необходимо проверить содержаться ли элементы в списке.
 * Если их нет - возвращаем пустую строку, иначе - первый элемент в коллекции.
 */
public class CheckerAhdGetter {

    public static String getElement(List<String> list) {
        String str = "";
        if (!list.isEmpty()) {
            str = list.get(0);
        }
        return str;
    }
}
