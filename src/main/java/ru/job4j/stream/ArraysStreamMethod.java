package ru.job4j.stream;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Массивы это часто используемая конструкция,
 * поэтому важно знать как создать стрим из массива.
 * Для создания стрима служит метод Arrays.stream()
 * <p>
 * Например,
 * Integer[] data = {1, 2, 3};
 * Stream<Integer> stream = Arrays.stream(data);
 * <p>
 * Ниже приведен код, вам нужно создать стрим из переданного массива
 */
public class ArraysStreamMethod {

    public static Stream<Integer> createStream(Integer[] data) {
        return Arrays.stream(data);
    }
}
