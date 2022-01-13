package ru.job4j.stream;

import java.util.stream.Stream;

/**
 * Иногда нужно создать стрим выборочно из нескольких элементов.
 * Для этого бывает полезно использовать метод Stream.builder(),
 * он нам возвращает объект для построения стрима.
 * У этого объекта мы можем вызвать метод add() для добавления элемента в стрим
 * и build() для окончательного построения стрима.
 * <p>
 * Пример,
 * Stream<Object> stream = Stream.builder().add(1).add(2).build()
 * <p>
 * Ваша задача создать стрим из первого и последнего элементов массива
 */
public class StreamBuilder {

    public static Stream<Object> createStream(Integer[] data) {
        return Stream.builder()
                .add(data[0])
                .add(data[data.length - 1])
                .build();
    }
}
