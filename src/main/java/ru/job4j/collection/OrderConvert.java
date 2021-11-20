package ru.job4j.collection;

import java.util.HashMap;
import java.util.List;

/**
 * Систему поступает список заказов.
 * Нам было бы удобно работать с ним по номеру.
 * Для этого нужно преобразовать список заявок в карту.
 */
public class OrderConvert {

    public static HashMap<String, Order> process(List<Order> orders) {
        HashMap<String, Order> map = new HashMap<>();
        for (Order order : orders) {
            map.put(order.getNumber(), order);
        }
        return map;
    }
}
