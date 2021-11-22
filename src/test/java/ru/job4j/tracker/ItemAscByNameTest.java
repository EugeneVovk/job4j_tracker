package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemAscByNameTest {

    @Test
    public void whenAscendingSorting() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Anton"));
        items.add(new Item("Andrey"));
        items.add(new Item("Ivan"));
        items.add(new Item("Evgeniy"));
        items.add(new Item("Timofey"));
        items.add(new Item("Petr"));
        items.sort(new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item("Andrey"),
                new Item("Anton"),
                new Item("Evgeniy"),
                new Item("Ivan"),
                new Item("Petr"),
                new Item("Timofey")
        );
        Assert.assertEquals(items, expected);
    }
}