package ru.job4j.list;

import java.util.List;

/**
 * Метод принимает в качестве параметров список и индекс элемента который необходимо заменить.
 * Необходимо дописать метод так, чтобы сначала удалялся последний элемент в списке,
 * а потом этим элементом заменить элемент по индексу, который пришел в параметрах метода.
 * Необходимо учесть, что извне могут передать индекс, который превышает значение размера списка.
 * Чтобы этого избежать - необходимо добавить проверку валидности входных параметров.
 */
public class RepositionElement {

    public static List<String> changePosition(List<String> list, int index) {
        String str = list.remove(list.size() - 1);
        if (index < list.size()) {
            list.set(index, str);
        }
        return list;
    }
}
