package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;

/**
 * HashSet отлично подходит для проверки, что коллекция содержит только уникальные элементы.
 * <p>
 * Давайте рассмотрим ситуацию с генерацией текста.
 * Представим, что мы пишем поисковой движок уникальных статей.
 * Писать уникальные тексты дорого, поэтому
 * часть недобросовестных владельцев сайтов генерируют тексты.
 * В примитивном случае, статья генерируется на основании другой статьи простой перестановкой слов.
 * Нам нужно написать метод, который будет сравнивать два текста.
 * Если они состоят из один и тех же слов, то мы считаем, что текст не уникальный.
 * Например. Одинаковые тексты.
 * "Мы делаем дома и коттеджи" и "Мы делаем коттеджи и дома".
 * Оба текста состоят из одинаковых слов.
 */
public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        /* Преобразовать строку в массив слов.
        Для этого используется метод String.split(" ").*/
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>(
                Arrays.asList(origin));
        HashSet<String> inspecting = new HashSet<>(
                Arrays.asList(text));
        for (String el : inspecting) {
            rsl = check.contains(el);
        }
        return rsl;
    }
}
