package ru.job4j.tracker;

import java.util.Arrays;

/**
 * Чтобы получить новый массив, нужно использовать метод Arrays.copyOf.
 * Этот метод принимает два параметра: массив элементов и новый размер.
 * Вначале мы создаем два массива.
 * Один заполнен строками и нулями.
 * Второй массив создаем пустой по размеру первого. В него мы будем копировать ненулевые элементы.
 * Далее мы создаем цикл и перебираем все элементы.
 * Если элемент не равен null, то мы его записываем в пустой массив.
 * Перед циклом мы объявили счетчик size.
 * Он одновременно является текущим индексом для массива namesWithoutNull,
 * также мы будем обрезать этот массив по этому размеру.
 * На последнем этапе мы обрезаем новый массив по полученному размеру.
 */
public class DropArray {
    public static void main(String[] args) {
        String[] names = {"Pert", null, "Ivan", "Stepan", null};
        String[] namesWithoutNull = new String[names.length];
        int size = 0;
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            if (name != null) {
                namesWithoutNull[size] = name;
                size++;
            }
        }
        namesWithoutNull = Arrays.copyOf(namesWithoutNull, size);
        for (int i = 0; i < namesWithoutNull.length; i++) {
            System.out.println(namesWithoutNull[i]);
        }
    }
}
