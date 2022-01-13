package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Класс Collectors содержит метод groupingBy(Function),
 * его можно использовать для группировки, по значению, которое возвращает Function.
 * Данный метод вернет мапу с типом, которая возвращает Function
 * и значением списка по элементам стрима.
 * <p>
 * Пример группировке строк по длинам:
 *       List<String> strings = List.of("a", "b", "aa", "bb", "ccc");
 *       Map<Integer, List<String>> collect = strings.stream()
 *              .collect(Collectors.groupingBy(String::length));
 *       collect.entrySet().forEach(System.out::println);
 * <p>
 * Ваша задача сгруппировать пользователей по возрасту
 */
public class GroupMethod {

    public static Map<Integer, List<User2>> groupBy(List<User2> users) {
        return users.stream()
                .collect(Collectors.groupingBy(User2::getAge));
    }
}
