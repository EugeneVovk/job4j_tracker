package ru.job4j.stream;

import java.util.List;

/**
 * Иногда нам может понадобиться произвести редукцию с начальным значением.
 * Для этого есть перегруженный метод reduce().
 * Первый аргумент начальное значение, второй оператор.
 * В отличие от первого метода, который принимает один аргумент,
 * этот метод возвращает начальное значение для пустого списка, а не Optional.
 * <p>
 * Например, прибавим числа списка к 10
 * Integer sum = List.of(1, 2, 3).stream().reduce(10, (n1, n2) -> n1 + n2); - 16
 * Integer sum = List.of().stream().reduce(10, (n1, n2) -> n1 + n2); - 10, т.к. список пуст
 * <p>
 * Ваша задача умножить 5 на элементы списка
 */
public class ReductionWithTwoArguments {

    public static Integer collect(List<Integer> list) {
        return list.stream().reduce(5, (a, b) -> a * b);
    }
}
