package ru.job4j.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MostUsedWord {

    public static String getMaxCount(String str) {
        Map<String, Integer> map = new TreeMap<>();
        str = str.toLowerCase();
        List<String> strings = new ArrayList<>(List.of(str.split(" ")));
        for (String word : strings) {
            map.computeIfPresent(word, (k, v) -> v + 1);
            map.putIfAbsent(word, 1);
        }
        String rsl = "";
        int maxCount = 0;
        for (String word : map.keySet()) {
            if (map.get(word) > maxCount && word.length() > 2) {
                rsl = word;
                maxCount = map.get(word);
            }
        }
        System.out.println("This word is repeated " + maxCount + " times:");
        return rsl;
    }

    public static void main(String[] args) {
        String str = "Мой дядя самых честных правил "
                + "Когда не в шутку занемог "
                + "Он уважать себя заставил "
                + "И лучше выдумать не мог "
                + "Его пример другим наука "
                + "Но боже мой какая скука "
                + "С больным сидеть и день и ночь "
                + "Не отходя ни шагу прочь "
                + "Какое низкое коварство "
                + "Полуживого забавлять "
                + "Ему подушки поправлять "
                + "Печально подносить лекарство "
                + "Вздыхать и думать про себя "
                + "Когда же черт возьмет тебя";
        String rsl = MostUsedWord.getMaxCount(str);
        System.out.println(rsl);
    }
}
