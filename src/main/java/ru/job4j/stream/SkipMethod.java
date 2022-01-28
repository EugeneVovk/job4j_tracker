package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 7.2. Промежуточные операции. Метод skip()
 * Чтобы опустить какое-то число элементов стрима, можно использовать метод skip()
 * Например,
 * List.of(1, 2, 3, 4, 5).stream().skip(2)
 * - будет стрим из элементов 3, 4, 5
 * Ваша задача взять и получить элементы списка, за исключением первых двух
 */
public class SkipMethod {
    public static List<String> lastThree(List<String> strings) {
        return strings.stream()
                .skip(2)
                .collect(Collectors.toList());
    }
}
