package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Если нам нужно подсчитать сумму элементов при группировке,
 * то можем использовать коллектор Collectors.summingInt(),
 * этот коллектор суммирует в int.
 * Он принимает функцию в которой мы должны преобразовать наш объект к int.
 * <p>
 * Например, просуммируем четные и нечетные элементы.
 * В примере summingInt принимает n -> n, т.к. в списке уже хранятся числа
 * List.of(1, 2, 3, 4, 5, 6).stream()
 * .collect(Collectors.groupingBy(
 * n -> n % 2,
 * Collectors.summingInt(n -> n)
 * )).forEach((k, v) -> System.out.println(k + " " + v));
 * <p>
 * Вам дан список пользователей, у каждого пользователя есть счет.
 * Ваша задача найти сумму баланса для каждого пользователя.
 * Подсказка: нужно использовать вспомогательный класс для группировки Pair
 */
public class SummingMethod {

    public static Map<String, Integer> summing(List<User3> users) {
        return users.stream()
                .collect(Collectors.groupingBy(User3::getName,
                        Collectors.summingInt(s -> s.getBills()
                                .stream()
                                .mapToInt(Bill::getBalance)
                                .sum()
                        )));
    }
}
