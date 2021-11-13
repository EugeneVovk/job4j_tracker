package ru.job4j.oop;

/**
 * Up casting - приведение конкретного типа к более общему типу данных
 * Down casting - приведение от общего типа к более конкретному.
 */
public class College {
    public static void main(String[] args) {
        Freshman fresh = new Freshman();
        /* делаем приведение к типу родителя Student. */
        Student st = fresh;
        /* делаем приведение к типу родителя Object. */
        Object obj = fresh;
    }
}
