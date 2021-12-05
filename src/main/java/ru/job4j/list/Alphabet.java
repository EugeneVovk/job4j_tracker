package ru.job4j.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Необходимо реализовать метод, который принимает строку,
 * которая является одним словом, без знаков препинания цифр и пробелов.
 * Метод должен вернуть новую строку, в которой все символы исходной строки
 * будут расставлены в алфавитном порядке.
 * Для разделения строки на подстроки используйте метод split(),
 * добавьте все элементы в коллекцию List<String>, отсортируйте в порядке возрастания -
 * используйте метод sort, в который передадите компаратор.
 * Новую строку сформируйте с помощью StringBuilder.
 */
public class Alphabet {

    public static String reformat(String str) {
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>(List.of(str.split("")));
        Collections.sort(list);
        for (String s : list) {
            sb.append(s);
        }
        return sb.toString();
    }
}
