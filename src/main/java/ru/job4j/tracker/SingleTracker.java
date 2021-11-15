package ru.job4j.tracker;

import java.util.List;

/**
 * Реализовать шаблон singleton.
 * final, чтобы запретить наследование этого класса.
 */
public final class SingleTracker {

    private static SingleTracker instance = null;

    private Tracker tracker = new Tracker();

    /**
     * Модификатор private.
     * Таким образом, никто не сможет создать объект этого класса.
     */
    private SingleTracker() {
    }

    /**
     * Создаём геттер, чтобы иметь ссылку на объект
     */
    public static SingleTracker getInstance() {
        if (instance == null) {
            instance = new SingleTracker();
        }
        return instance;
    }

    /**
     * Чтобы избежать копирование кода используем подход делегирования
     */
    public Item add(Item item) {
        return tracker.add(item);
    }

    public List<Item> findAll() {
        return tracker.findAll();
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public boolean delete(int id) {
        return tracker.delete(id);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public List<Item> findByName(String key) {
        return tracker.findByName(key);
    }
}
