package ru.job4j.stream;

import java.util.List;

/**
 * 4.3. Терминальные операции. Метод anyMatch()
 * Чтобы проверить, что хотя бы один элемент стрима удовлетворяет условию,
 * можно использовать метод anyMatch()
 * Например,
 * List.of(1, 2, 0, 3, 4).stream().anyMatch(n -> n % 2 == 0);
 * - проверяем, что есть хотя бы одно четное число
 * <p>
 * Ваша задача проверить, что хотя бы одна строка списка начинается с "job4j"
 */
public class AnyMatchMethod {
    public static boolean check(List<String> list) {
        return list.stream().anyMatch(n -> n.startsWith("job4j"));
    }
}
