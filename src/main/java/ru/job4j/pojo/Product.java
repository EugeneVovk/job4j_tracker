package ru.job4j.pojo;

import java.util.Objects;

public class Product {
    private String name;
    private int count;

    public Product(String name, int count) {
        this.name = name;
        this.count = count;
    }

    /**
     * 1. Сначала мы сравниваем ссылки.
     * Если две переменные ссылаются на один блок памяти,
     * то объекты будут однозначно равны.
     * Это позволяет сэкономить время вычисления.
     * 2. Проверяем, что аргумент метода не равен null.
     * Если он равен, то объекты не равны. Это элемент валидации.
     * 3. Проверяем типы классов.
     * Объекты могут быть равны, только если классы моделей одинаковые.
     * Нельзя сравнивать Product и FreshProduct.
     * Даже если FreshProduct это наследник от Product, сравнение даст false.
     * 4. Сравниваем поля.
     * Если поля равны, то два объекта равны тоже.
     * Примитивный тип count сравнивается через ==.
     * Для ссылочного типа String используется метод equals.
     *
     * @param o - объект с которым сравниваем.
     * @return - в зависимости от результата возвращаем true или false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return count == product.count && name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, count);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

