package ru.job4j.stream;

import java.util.Arrays;

/**
 * 5.7. Промежуточные операции. Метод flatMapToInt(). Сумма чисел матрицы
 * Если нам нужно обходить структуры, которые имеют вложенные структуры
 * (типа список списков, матрицы и тд), мы используем вложенные циклы.
 * Для стримов мы можем использовать методы, которые начинаются с префикса flat,
 * например, flatMap(), flatMapToInt().
 * <p>
 * Изначально, когда мы получаем стрим, мы имеем стрим этих структур.
 * Например, если у нас есть List<List<Integer>>, используя метод stream(),
 * мы получим стрим из List<Integer>.
 * Для того чтобы обходить элементы вложенных структур,
 * нам нужно использовать метод flat*.
 * <p>
 * Методы flat* возвращают стрим из вложенных структур.
 * После вызова этих методов мы можем работать со стримом как с одним.
 * Метод flatMap() возвращает стрим объектов,
 * т.е. Stream, а другие методы служат для создания стрима из примитивов.
 * Например, flatMapToInt() служит для создания стрима IntStream.
 * <p>
 * Пример,
 * Arrays.stream(new int[][] {{1, 2, 3}, {4, 5}}) - имеем стрим массивов
 * .flatMapToInt(subArray -> Arrays.stream(subArray)) - теперь у нас один стрим из всех элементов
 * .forEach(el -> System.out.println(el))
 * В этом примере, мы получаем стрим из притивов внутренних массивов.
 * Это нам позволяет использовать терминальные методы стримов примитивов
 * <p>
 * Ваша задача получить сумму элементов матрицы
 */
public class FlatMapForPrimitive {
    public static int sum(int[][] matrix) {
        return Arrays.stream(matrix)
                .flatMapToInt(Arrays::stream)
                .sum();
    }
}