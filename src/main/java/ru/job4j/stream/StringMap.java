package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 5.2. Промежуточные операции. Метод map(). Map со строками
 * Дан список строк. Вам нужно к каждой строке прибавить ".java"
 * Например,
 * Из {"One"} нужно получить {"One.java"}
 */
public class StringMap {
    public static List<String> map(List<String> names) {
        return names.stream()
                .map(s -> s.concat(".java"))
                .collect(Collectors.toList());
    }
}
