package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определяется по полю приоритет.
     * Для вставки использовать add(int index, E value)
     * @param task - задача
     */
    public void put(Task task) {
        int index = 0;
        if (tasks.size() > 0) {
            for (Task el : tasks) {
                if (task.getPriority() >= el.getPriority()) {
                    index++;
                }
            }
        }
        this.tasks.add(index, task);
    }

    /**
     * Метод take возвращает первый элемент из списка
     * и удаляет его.
     */
    public Task take() {
        return tasks.poll();
    }
}
