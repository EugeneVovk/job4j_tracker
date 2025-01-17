package ru.job4j.strategy;

/**
 * Класс Square - реализует конкретное действие системы.
 * Этот класс реализует интерфейс Shape.
 */
public class Square implements Shape {
    @Override
    public String draw() {
        String ln = System.lineSeparator();
        return    " _______ "  + ln
                + "|       |" + ln
                + "|       |" + ln
                + "|_______|" + ln;
    }
}
