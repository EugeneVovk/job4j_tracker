package ru.job4j.lambda;

import java.util.List;
import java.util.Optional;

/**
 * Стоит обратить внимание, что метод of() не принимает null элементы.
 * Чтобы создать Optional в случае если есть null элементы
 * можно использовать метод Optional.ofNullable().
 * Этот метод возвращает пустой Optional если передано null значение
 * и Optional из переданного значения, если оно не null.
 * <p>
 * Например,
 * Optional.ofNullable(1).ifPresent(System.out::println);  выведет 1
 * Optional.ofNullable(null).ifPresent(System.out::println);
 *  ничего выведется, потому что мы получили пустой Optional
 * <p>
 * Ваша задача, написать метод поиск строки среди списка.
 * В списке могут быть null элементы.
 * Чтобы обернуть найденное значение, нужно использовать Optional.ofNullable().
 * Для безопасной проверки можно использовать Objects.equals().
 * Если что-то найдено, нужно вернуть Optional из этого значения, в противном случае пустой Optional
 */
public class OptionalOfNullable {

    public static Optional<String> findValue(List<String> strings, String value) {
        Optional<String> optional = Optional.empty();
        if (strings.contains(value)) {
            optional = Optional.ofNullable(value);
        }
        return optional;
    }
}
