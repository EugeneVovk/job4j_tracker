package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 8.2. Промежуточные операции. Метод distinct(). Уникальные объекты
 * Если мы используем метод distinct() для объектов, то нужно понимать,
 * что этот метод использует метод equals для проверки равенства объектов.
 * Поэтому если вы хотите исключить дубликаты-объекты, нужно,
 * чтобы в классе был переопределен метод equals
 * <p>
 * Например для класса String метод equals переопределен, поэтому мы можем сделать так
 * List.of("a", "b", "c", "a", "b").stream().distinct()
 * - получим стрим из "a", "b", "c"
 * <p>
 * Ваша задача получить список уникальных пользователей.
 * На то, что переопределен методы hashcode не стоит обращать внимание,
 * он переопределен, т.к. это нужно делать при переопределении equals.
 */
public class DistinctForObject {
    public static List<User> distinct(List<User> users) {
        return users.stream()
                .distinct()
                .collect(Collectors.toList());
    }
}
