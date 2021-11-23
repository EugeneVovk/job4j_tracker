package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class OrderConvertTest {
    @Test
    public void whenSingleOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Dress"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.get("3sfe"), is(new Order("3sfe", "Dress")));
    }

    @Test
    public void whenSeveralOrders() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Shirt"));
        orders.add(new Order("5sfe", "Dress"));
        orders.add(new Order("13sfe", "Jacket"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.get("3sfe"), is(new Order("3sfe", "Shirt")));
    }

    @Test
    public void whenDuplicateOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Shirt"));
        orders.add(new Order("3sfe", "Dress"));
        orders.add(new Order("3sfe", "Jacket"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.get("3sfe"), is(new Order("3sfe", "Jacket")));
    }

    @Test
    public void whenDuplicateOrderThanSize1() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Shirt"));
        orders.add(new Order("3sfe", "Dress"));
        orders.add(new Order("3sfe", "Jacket"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.size(), is(1));
    }

    @Test
    public void whenSeveralDuplicateOrders() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Shirt"));
        orders.add(new Order("5sfe", "Shirt"));
        orders.add(new Order("13sfe", "Shirt"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.get("5sfe"), is(new Order("5sfe", "Shirt")));
    }
}