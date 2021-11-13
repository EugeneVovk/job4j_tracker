package ru.job4j.strategy;

/**
 * Класс Triangle - реализует конкретное действие системы.
 * Этот класс реализует интерфейс Shape.
 */
public class Triangle implements Shape {
    @Override
    public String draw() {
        String ln = System.lineSeparator();
        return "   ^    " + ln
                + " /   \\ " + ln
                + "/_____\\" + ln;
    }
}
