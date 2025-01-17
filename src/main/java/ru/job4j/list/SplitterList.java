package ru.job4j.list;

import java.util.List;

/**
 * Метод принимает 3 списка элементов:
 * 1. Общий список элементов;
 * 2. Список важных элементов, но не обязательных;
 * 3. Список элементов, которые обязательно должны отсутствовать в результирующем списке.
 * Необходимо реализовать метод, который вернет список, основой которого будет первый,
 * присутствовать элементы из второго и точно отсутствовать элементы из третьего.
 * Используйте методы о которых говорилось выше.
 */
public class SplitterList {

    public static List<String> split(List<String> left, List<String> middle, List<String> right) {
        left.retainAll(middle);
        left.removeAll(right);
        return left;
    }
}
