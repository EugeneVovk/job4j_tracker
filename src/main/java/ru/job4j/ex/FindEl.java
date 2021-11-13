package ru.job4j.ex;

import java.util.Objects;

public class FindEl {

    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (Objects.equals(value[i], key)) {
                rsl = i;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Element not found in array");
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] shops = {"Ebay", "Amazon", "Ozon"};
        try {
            System.out.println(FindEl.indexOf(shops, "Amazon"));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
