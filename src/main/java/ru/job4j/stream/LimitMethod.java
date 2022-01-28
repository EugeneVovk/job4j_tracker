package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 7.1. Промежуточные операции. Метод limit()
 * Чтобы взять какое-то число первых элементов стрима, можно использовать метод limit()
 * Например,
 * List.of(1, 2, 3, 4, 5).stream().limit(2)
 * - будет стрим из элементов 1, 2
 * Ваша задача взять первые 3 элемента из списка
 */
public class LimitMethod {
    public static List<String> firstThree(List<String> strings) {
        return strings.stream()
                .limit(3)
                .collect(Collectors.toList());
    }
}
