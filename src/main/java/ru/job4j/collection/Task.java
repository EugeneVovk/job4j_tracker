package ru.job4j.collection;

/**
 * В этом задании вам нужно оставить уникальные номера задач.
 * Представьте, что у нас есть система поиска задач по тексту.
 * Система возвращает нам список задач.
 * Некоторые задачи могут повторяться несколько раз.
 * Система не проверяет, что такая задача уже есть в выборке.
 * Вам нужно убрать дубликаты из списка.
 */
public class Task {
    private String number;
    private String description;

    public Task(String number, String description) {
        this.number = number;
        this.description = description;
    }

    public String getNumber() {
        return number;
    }
}
