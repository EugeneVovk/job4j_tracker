package ru.job4j.strategy;

/**
 * Класс Paint - описывает основное поведение программы.
 * Он использует действия интерфейса Shape.
 */
public class Paint {

    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }

    public static void main(String[] args) {
        Paint context = new Paint();
        context.draw(new Triangle());
        context.draw(new Square());
    }
}
