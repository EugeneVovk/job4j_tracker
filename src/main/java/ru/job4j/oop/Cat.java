package ru.job4j.oop;

/**
 * Класс, описывающий кота, у нас один, но объектов мы создаем два.
 * Каждый объект резервирует свой кусочек памяти.
 * В этот кусок памяти мы записываем данные, которые принадлежат конкретному объекту.
 */
public class Cat {

    private String name;
    private String food;

    /**
     * Для того чтобы обратиться к полю объекта, нам нужно использовать ключевое слово this.
     * Это слово указывает, что нужно вывести содержимое поля.
     * this. - дальше указываем имя поля, которое нужно вывести.
     */
    public void show() {
        System.out.println(this.name + " ate the " + this.food);
    }

    public void giveNick(String nick) {
        this.name = nick;
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public static void main(String[] args) {
        System.out.println("There are gav's food");
        Cat gav = new Cat();
        gav.giveNick("Gav");
        gav.eat("kotleta");
        gav.show();
        System.out.println("There are black's food");
        Cat black = new Cat();
        black.giveNick("Black");
        black.eat("fish");
        black.show();
    }
}
