package ru.job4j.stream;

import java.util.List;

/**
 * 4.2. Терминальные операции. Метод allMatch()
 * Чтобы проверить, что элементы стрима удовлетворяют определенному условию,
 * мы можем использовать метод allMatch().
 * Например:
 * List.of(1, 2, 3).allMatch(n -> n > 0); - проверяем, что все числа положительные
 * <p>
 * Ваша задача проверить, что переданный список содержит строки, длина которых больше 3.
 */
public class AllMatchMethod {
    public static boolean check(List<String> list) {
        return list.stream().allMatch(n -> n.length() > 3);
    }
}
