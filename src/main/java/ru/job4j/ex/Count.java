package ru.job4j.ex;

/**
 * A program for counting numbers from 'start' to 'finish'
 * <p>
 * Нужно добавить проверку входных параметров
 * и прервать выполнение программы, если данные введены неверно.
 * Чтобы прервать выполнение программы,
 * нужно использовать оператор throw с передачей этому оператору
 * объекта типа java.util.Exception.
 */
public class Count {

    public static int add(int start, int finish) {
        if (start > finish) {
            throw new IllegalArgumentException("Start should be less than finish.");
        }
        int rsl = 0;
        for (int i = start; i != finish; i++) {
            rsl += i;
        }
        return rsl;
    }

    public static void main(String[] args) {
        System.out.println("Sum of 2 to 10 is : " + add(2, 10));
    }
}
