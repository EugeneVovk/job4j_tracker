package ru.job4j.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Класс Analyze получает статистику по аттестатам.
 */
public class Analyze {

    /**
     * Метод averageScore вычисляет общий средний балл.
     */
    public static double averageScore(Stream<Pupil> stream) {
        /*
        1. Метод averageScore - с этим методом все достаточно просто,
        для реализации понадобятся методы:
            - flatMap() для преобразования в поток объектов Subject;
            - mapToInt() для последующего преобразования в потом оценок по каждому предмету;
            - average() для расчета среднего бала по предмету;
            - orElse() для того чтобы вернуть значение по умолчанию. */
        return stream.flatMap(s -> s.getSubjects().stream())
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0D);
    }

    /**
     * Метод averageScoreBySubject вычисляет средний балл ученика по его предметам.
     *
     * @return список из объекта Tuple (имя ученика и средний балл).
     */
    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        /*
        2. Метод averageScoreBySubject - поскольку нам надо выполнить преобразование
        в поток объектов класса Tuple, последовательность будет следующей:
        - метод map() для преобразования в поток объектов класса Tuple,
        внутри метода мы будем создавать эти объекты - там будет фигурировать строка new Tuple();
        - при этом в конструктор первым параметром будет передаваться имя текущего объекта Pupil -
        используем соответствующий геттер;
        - вторым параметром рассчитанный средний балл -
        расчет можно произвести по той же последовательности, что описана для метода averageScore;
        - последним методом будет collect(), с помощью которого мы все соберем в коллекцию List.
         */
        return stream
                .map(s -> new Tuple(s.getName(), s.getSubjects()
                        .stream()
                        .mapToInt(Subject::getScore)
                        .average()
                        .orElse(0D)))
                .collect(Collectors.toList());
    }

    /**
     * Метод averageScoreByPupil вычисляет средний балл по всем предметам для каждого ученика.
     *
     * @return список из объекта Tuple (название предмета и средний балл).
     */
    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        /*
        3. Метод averageScoreByPupil - реализация этого метода несколько сложна,
        поскольку в данном случае требуется выполнить промежуточный сбор данных в Map().
        Опишем вкратце алгоритм:
        - flatMap() для преобразования в поток объектов Subject;
        - метод collect() в который мы передаем метод groupingBy() (минимум с двумя параметрами)
        класса Collectors.
        При этом карта собирается следующим образом: ключ - это имя предмета,
        значение - средний балл по этому предмету для каждого ученика.
        Для расчета среднего балла используйте метод averagingDouble() класса Collectors;
        - после этого собранную карту мы разбираем с помощью entrySet()
        и открываем поток с помощью stream();
        - полученный поток с помощью map() преобразуем в поток объектов класса Tuple,
        внутри метода мы будем создавать эти объекты - там будет фигурировать строка new Tuple();
        - в конструктор мы будем передавать параметры с помощью методов getKey()
        и getValue() интерфейса Entry;
        - последним методом будет collect(), с помощью которого мы все соберем в коллекцию List.
         */
        return stream
                .flatMap(s -> s.getSubjects().stream())
                .collect(Collectors.groupingBy(
                        Subject::getName, LinkedHashMap::new,
                        Collectors.averagingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(s -> new Tuple(s.getKey(), s.getValue()))
                .collect(Collectors.toList());
    }

    /**
     * Метод bestStudent - лучшим считается ученик с наибольшим баллом по всем предметам.
     *
     * @return возвращает лучшего ученика.
     */
    public static Tuple bestStudent(Stream<Pupil> stream) {
        /*
        4. Метод bestStudent - для реализации данного метода
        можно использовать метод averageScoreBySubject за исключением следующих особенностей:
        - в данном методе мы рассчитываем суммарный балл, а не средний -
        поэтому вместо average() нужно использовать метод sum();
        - терминальной операцией будет не метод collect(), а использование метода max(),
        в который будем передавать компаратор. При этом компаратор определит объект Tuple,
        у которого значение Score будет максимальным;
        - orElse() для того чтобы вернуть значение по умолчанию.
         */
        return stream
                .map(s -> new Tuple(s.getName(), s.getSubjects()
                        .stream()
                        .mapToInt(Subject::getScore)
                        .sum()))
                .max(Comparator.comparingDouble(Tuple::getScore))
                .orElse(null);
    }

    /**
     * Метод bestSubject - возвращает предмет с наибольшим баллом для всех студентов.
     *
     * @return объект Tuple (имя предмета, сумма баллов каждого ученика по этому предмету)
     */
    public static Tuple bestSubject(Stream<Pupil> stream) {
        /*
        5. Метод bestSubject - для реализации данного метода можно использовать
        метод averageScoreByPupil за исключением следующих особенностей:
        - в данном методе мы рассчитываем суммарный балл, а не средний -
        поэтому вместо averagingDouble() нужно использовать метод summingDouble();
        - терминальной операцией будет не метод collect(),
        а использование метода max(), в который будем передавать компаратор.
        При этом компаратор определит объект Tuple, у которого значение Score будет максимальным;
        - orElse() для того чтобы вернуть значение по умолчанию.
         */

        return stream
                .flatMap(s -> s.getSubjects().stream())
                .collect(Collectors.groupingBy(
                        Subject::getName,
                        Collectors.summingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(s -> new Tuple(s.getKey(), s.getValue()))
                .max(Comparator.comparingDouble(Tuple::getScore))
                .orElse(null);
    }
}
