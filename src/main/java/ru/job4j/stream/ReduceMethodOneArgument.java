package ru.job4j.stream;

import java.util.List;

/**
 * В Stream есть метод reduce(BinaryOperator<T> operator).
 * Этот метод находит первый элемент стрима, он становится результатом,
 * а потом уже начинает применять оператор к последующим элементам.
 * <p>
 * Пример,
 * Integer sum = List.of(1, 2, 3).stream().reduce((n1, n2) -> n1 + n2).get();
 * // сумма 6
 * Integer sum = List.of(1).stream().reduce((n1, n2) -> n1 + n2).get(); /
 * / сумма 1, т.к. найдем только один элемент
 * <p>
 * Ваша задача найти произведение чисел, используя данный метод. Размер списка всегда больше 0
 */
public class ReduceMethodOneArgument {

    public static Integer reduce(List<Integer> list) {
        return list.stream().reduce((a, b) -> a * b).get();
    }
}
