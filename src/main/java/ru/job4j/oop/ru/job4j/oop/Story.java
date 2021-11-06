package ru.job4j.oop.ru.job4j.oop;

import ru.job4j.oop.Girl;
import ru.job4j.oop.Pioneer;
import ru.job4j.oop.Wolf;

public class Story {
    public static void main(String[] args) {
        Pioneer petya = new Pioneer();
        Girl girl = new Girl();
        Wolf wolf = new Wolf();
        girl.help(petya);
        wolf.eat(girl);
        petya.kill(wolf);
    }
}
