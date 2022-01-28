package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 9.5. Optional и Stream. Метод stream()
 * В классе Optional есть методы, которые помогают работать со стримами.
 * Например, метод stream(), если значение существует,
 * то этот метод создает стрим из этого значения,
 * если нет, то возвращает пустой стрим.
 * <p>
 * Например, напишем метод, который преобразует к верхнему регистру
 * первую строку, которая начинается с 1.
 * Если в стриме ничего не будет нам вернется пустая строка,
 * как видим это довольно удобно,
 * т.к. позволяет продолжать работать со стримами, не делая проверок через if.
 */
public class OptionalStream {
    public static void main(String[] args) {
        List<String> strings = List.of(
                "1. Task",
                "2. Task",
                "3. Task"
        );
        System.out.println(
                toUpperFirstSting(strings));
    }

    public static String toUpperFirstSting(List<String> strings) {
        return strings.stream()
                .filter(s -> s.startsWith("1"))
                .findFirst().stream()
                .flatMapToInt(String::chars)
                .mapToObj(c -> String.valueOf(Character.toUpperCase((char) c)))
                .collect(Collectors.joining());
    }
}
