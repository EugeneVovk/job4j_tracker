package ru.job4j.stream;

import java.util.LinkedList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * Редукция может быть использована не только для сведения в коллекцию,
 * но и для сведения например, к числу, строке и тд.
 * Например, нам нужен коллектор, который поделит 100 на все числа в стриме.
 * Например, для 4, и 5, (100 / 4) / 5 = 5.
 * <p>
 * Давайте напишем такой коллектор
 * <p>
 * // сюда сложим элементы
 * Supplier<List<Integer>> supplier = LinkedList::new;
 * // говорим, как добавлять элементы
 * BiConsumer<List<Integer>, Integer> consumer = List::add;
 * // не вдаемся в подробности. Просто нужно
 * BinaryOperator<List<Integer>> merger = (xs, ys) -> {
 * xs.addAll(ys);
 * return xs;
 * };
 * // это функция, которая обработает наш список после сборки
 * // здесь вся логика
 * Function<List<Integer>, Integer> function = (ns) -> {
 * int number = 100;
 * for (Integer n : ns) {
 * number /= n;
 * }
 * return number;
 * };
 * <p>
 * Integer result = List.of(4, 5).stream()
 * .collect(Collector.of(supplier, consumer, merger, function));
 * <p>
 * System.out.println(result);
 * Как видно, по коду, вся логика сидит в function.
 * <p>
 * Ваша задача дописать метод, чтобы он умножал элементы списка
 */
public class CollectorArithmetic {

    public static Integer collect(List<Integer> list) {
        Supplier<List<Integer>> supplier = LinkedList::new;
        BiConsumer<List<Integer>, Integer> consumer = List::add;
        BinaryOperator<List<Integer>> merger = (xs, yx) -> {
            xs.addAll(yx);
            return xs;
        };
        Function<List<Integer>, Integer> function = ns -> {
            int number = 1;
            for (Integer i : ns) {
                number *= i;
            }
            return number;
        };
        return list.stream().collect(Collector.of(supplier, consumer, merger, function));
    }
}
