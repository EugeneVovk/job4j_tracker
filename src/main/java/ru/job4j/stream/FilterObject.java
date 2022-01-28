package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 6.3. Промежуточные операции. Метод filter(). Фильтрация объектов
 * Дан список пользователей. Вам нужно оставить только пользователей,
 * у которых имя начинается с буквы "B", а возраст > 18.
 */
public class FilterObject {
    public static List<User> filter(List<User> users) {
        return users.stream()
                .filter(user -> user.getName().startsWith("B"))
                .filter(user -> user.getAge() > 18)
                .collect(Collectors.toList());
    }
}
