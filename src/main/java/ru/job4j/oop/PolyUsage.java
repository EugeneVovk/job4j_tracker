package ru.job4j.oop;

public class PolyUsage {
    public static void main(String[] args) {
        Animal cow = new Cow();
        Animal goose = new Goose();
        Animal dog = new Dog();
        Animal guineaPig = new GuineaPig();

        Animal[] animals = {cow, goose, dog, guineaPig};
        for (Animal animal : animals) {
            animal.sound();
        }
    }
}
