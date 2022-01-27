package ru.job4j.lambda;

import java.util.Optional;

/**
 * Для того чтобы проверить, что в Optional есть значение или нет,
 * можно использовать метод isPresent(), isEmpty().
 * <p>
 * Например,
 * Optional.of(1).isPresent();  даст true
 * Optional.empty().isEmpty();  даст true
 * <p>
 * Для получения значения, которое мы поместили с помощью метода of()
 * мы можем использовать метод get()
 * <p>
 * Например,
 * Optional.of(1).get()  Вернет 1
 * Optional.empty().get()  Вернет исключение!
 * <p>
 * Запомните, перед вызовом метода get() всегда нужно использовать isPresent().
 * В этом суть Optional, чтобы программист не забывал делать проверки.
 * <p>
 * Ваша задача:
 * 1. Написать метод indexOf(). Он ищет индекс по значению.
 * Если индекс не найден, должно вернуться Optional.empty().
 * Если найден, то Optional из этого индекса
 * <p>
 * 2. В методе get() нужно вызвать метод indexOf().
 * Если вернулся пустой Optional, то метод должен вернуть -1,
 * в противном случае сам индекс
 */
public class OptionalGetAndIsPresent {

    public static int get(int[] data, int el) {
        Optional<Integer> rsl = indexOf(data, el);
        if (rsl.isEmpty()) {
            rsl = Optional.of(-1);
        }
        return rsl.get();
    }

    public static Optional<Integer> indexOf(int[] data, int el) {
        Optional<Integer> optional = Optional.empty();
        for (int i = 0; i < data.length; i++) {
            if (data[i] == el) {
                optional = Optional.of(i);
            }
        }
        return optional;
    }
}
