package ru.job4j.oop;

/**
 * Up casting - приведение конкретного типа к более общему типу данных
 * Down casting - приведение от общего типа к более конкретному.
 */
public class College {
    public static void main(String[] args) {
        Object freshman = new Freshman();
        Freshman freshman2 = (Freshman) new Student();

    }
}
