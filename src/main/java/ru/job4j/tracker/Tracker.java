package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * В классе Tracker должны быть методы:
 * * добавление заявок - public Item add(Item item);
 * * получение списка всех заявок - public Item[] findAll();
 * * получение списка по имени - public Item[] findByName(String key);
 * * получение заявки по id - public Item findById(int id);
 * Поле private Item[] items = new Item[100] содержит возможное количество заявлений.
 * Оно у нас ограничено сотней позиций.
 */
public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;

    /**
     * Метод public Item add(Item item) добавляет заявку,
     * переданную в аргументах в массив заявок items.
     * В методе add нужно проставить уникальный ключ в объект Item item.
     * Это нужно сделать через метод setId.
     * Поле ids используется для генерации нового ключа.
     * В нашем примере мы используем последовательность.
     * То есть каждый вызов метод add будет добавлять в поле ids единицу.
     * Так мы сможем обеспечить уникальность поле id в Item.
     * Аналогичный подход используется в базах данных.
     * @param item - уникальный ключ.
     * @return - добавил заявку
     */
    public Item add(Item item) {
        item.setId(ids++);
        items.set(size++, item);
        return item;
    }

    /**
     * Метод public Item findById(int id) проверяет в цикле все элементы массива items,
     * сравнивая id с аргументом int id
     * и возвращает найденный Item. Если Item не найден - возвращает null.
     * @param id - id
     * @return - возвращает найденный Item. Если Item не найден - возвращает null.
     */
    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    /**
     * Метод public Item[] findAll()
     * @return - возвращает копию массива items без null элементов (без пустых ячеек).
     */
    public List<Item> findAll() {
        return items;
    }

    /**
     * Метод public Item[] findByName(String key)
     * проверяет в цикле все элементы массива items,
     * сравнивая name (используя метод getName класса Item) с аргументом метода String key.
     * Элементы, у которых совпадает name, копирует в результирующий массив и возвращает его.
     * Алгоритм этого метода аналогичен методу findAll.
     * @param key - аргументом метода String key
     * @return - возвращает массив
     */
    public List<Item> findByName(String key) {
        List<Item> copy = List.of(new Item[size]);
        int len = 0;
        for (int i = 0; i < size; i++) {
            if (items.get(i).getName().equals(key)) {
                copy.set(len++, items.get(i));
            }
        }
        return copy;
    }

    /**
     * Метод, который возвращает index по id.
     * @param id - id
     * @return - индекс
     */
    private int indexOf(int id) {
        int rsl = -1;
        for (int i = 0; i < size; i++) {
            if (items.get(i).getId() == id) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }

    /**
     * Метод удаляет заявку, которая уже есть в системе и добавляет новую в эту ячейку
     * @param id   - индекс ячейки, где надо произвести замену
     * @param item - заявка, на которую меняем
     * @return - true, если замена произведена или false, если index по id не найден
     */
    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean isId = index != -1;
        if (isId) {
            item.setId(id);
            items.set(index, item);
        }
        return isId;
    }

    /**
     * Метод удаления заявки
     * @param id - id заявки
     * @return - возвращает true, если заявление удалено или false, если index не найдет по id.
     */
    public boolean delete(int id) {
        int index = indexOf(id);
        boolean isId = index != -1;
        if (isId) {
            items.remove(index);
        }
        return isId;
    }
}