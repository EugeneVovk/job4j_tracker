package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Необходимо реализовать метод, который добавляет элемент в список
 * и сообщает нам удалось это или нет, т.е. метод должен вернуть булево значение.
 * Не используйте в методе то, что метод возвращает true или false.
 * Для этого на входе в метод мы копируем список в новый список,
 * добавляем в тот список, который пришел в методе и в конце сравниваем их размеры -
 * если изменился, значит элемент добавился.
 */
public class AddElement {

    public static boolean addNewElement(List<String> list, String str) {
        List<String> check = new ArrayList<>(list);
        int size1 = check.size();
        check.add(str);
        int size2 = check.size();
        return size2 > size1;
    }
}
