package ru.job4j.stream;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Класс Stream работает с объектами.
 * Для представления стрима примитивов в Java есть свои классы:
 * IntStream, LongStream, DoubleStream.
 *
 * Их можно создавать как мы создавали раньше.
 * Чаще всего приходиться создавать стрим из массива примитивов.
 * Для этого лучше всего подходит метод Arrays.stream(). Например:
 * int[] data = {1, 2, 3};
 *
 * IntStream stream = Arrays.stream(data);
 *
 * Ваша задача создать стрим из переданного массива
 */
public class ArraysStreamForPrimitive {

    public static IntStream createStream(int[] data) {
        return Arrays.stream(data);
    }
}
