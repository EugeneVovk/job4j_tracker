package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemDescByNameTest {

    @Test
    public void compare() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Anton"));
        items.add(new Item("Andrey"));
        items.add(new Item("Ivan"));
        items.add(new Item("Evgeniy"));
        items.add(new Item("Timofey"));
        items.add(new Item("Petr"));
        items.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(
                        new Item("Timofey"),
                        new Item("Petr"),
                        new Item("Ivan"),
                        new Item("Evgeniy"),
                        new Item("Anton"),
                        new Item("Andrey")
                );
        Assert.assertEquals(items, expected);
    }
}