package ru.job4j.tracker;

/**
 * Протоколирование действий системы.
 * <p>
 * Шаблон singleton
 * Нужно запретить наследование этого класса.
 * Для этого используем ключевое слово final.
 */
public final class Log4File {

    private static Log4File instance = null;

    private String[] messages = new String[1000];
    private int index = 0;

    /**
     * Модификатор private.
     * Таким образом, никто не сможет создать объект этого класса.
     */
    private Log4File() {
    }

    /**
     * Добавим public static метод,
     * чтобы другие классы могли получить ссылку на объект Log4File
     */
    public static Log4File getInstance() {
        if (instance == null) {
            instance = new Log4File();
        }
        return instance;
    }

    public void add(String message) {
        messages[index++] = message;
    }

    public void save() {
        /* TODO Сохраняем записи из массива messages в файл. */
    }
}
