package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Метод Collectors.groupingBy() всегда первым параметром принимает функцию,
 * по которой будет строиться ключ. Вторым параметром может принимать Collector.
 * Большинство методов Collectors возвращают Collector.
 * <p>
 * Рассмотрим метод Collectors.counting(), этот метод ничего не принимает,
 * а просто подсчитывает количество элементов определенной группы
 * <p>
 * Например, напишем код, который будет возвращать Map<String, Long>
 * ключ это строка, значение это число ее вхождений в список:
 *      List<String> strings = List.of("a", "b", "c", "d", "c", "c");
 *      strings.stream()
 *          .collect(Collectors.groupingBy(
 *              Function.identity(),
 *              Collectors.counting()
 *      )).forEach((k, v) -> System.out.println(k + " " + v));
 * <p>
 * Ваша задача подсчитать количество работников для каждой компании
 */
public class CountingMethod {

    public static Map<String, Long> groupAndCount(List<Worker> workers) {
        return workers.stream().collect(Collectors.groupingBy(
                        s -> s.getCompany().getName(), Collectors.counting()));
    }
}
