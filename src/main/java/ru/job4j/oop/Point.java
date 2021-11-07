package ru.job4j.oop;

/**
 * Наша задача переписать этот код в ООП стиле.
 * Нам нужно уйти от прямой работы с примитивными типами и начать использовать объекты.
 * Объект позволяет забыть о деталях внутренней работы, позволяет абстрагироваться от реализации.
 * Нам это дает возможность работать с большими объемами кода.
 */
public class Point {
    /**
     * Это поле объекта. Оно доступно только конкретному объекту.
     */
    private int x;
    private int y;
    private int z;

    /**
     * Конструктор, который принимает начальное состояние объекта "точка"
     *
     * @param first  координата x
     * @param second координата y
     */
    public Point(int first, int second) {
        this.x = first;
        this.y = second;
    }

    public Point(int first, int second, int third) {
        this.x = first;
        this.y = second;
        this.z = third;
    }

    public double distance(Point that) {
        return Math.sqrt(Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2));
    }

    public double distance3d(Point that) {
        return Math.sqrt(Math.pow(this.x - that.x, 2)
                + Math.pow(this.y - that.y, 2)
                + Math.pow(this.z - that.z, 2));
    }
}
