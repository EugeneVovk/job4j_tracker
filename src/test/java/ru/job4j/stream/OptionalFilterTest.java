package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class OptionalFilterTest {

    @Test
    public void notExistAndNeedChild() {
        Child c1 = new Child("c1", 15);
        Child c2 = new Child("c2", 18);
        Child c3 = new Child("c1", 11);
        Child c4 = new Child("c2", 15);
        Worker2 worker1 = new Worker2("123", List.of(c1, c2));
        Worker2 worker2 = new Worker2("456", List.of(c3, c4));
        assertEquals(List.of(), OptionalFilter.defineChildren(List.of(worker1, worker2), "123"));
    }

    @Test
    public void notExistAndChildrenOld() {
        Child c1 = new Child("c1", 15);
        Child c2 = new Child("c2", 18);
        Child c3 = new Child("c1", 20);
        Child c4 = new Child("c2", 15);
        Worker2 worker1 = new Worker2("123", List.of(c1, c2, c3));
        Worker2 worker2 = new Worker2("456", List.of(c4));
        assertEquals(List.of(), OptionalFilter.defineChildren(List.of(worker1, worker2), "123"));
    }

    @Test
    public void whenExists() {
        Child c1 = new Child("c1", 15);
        Child c2 = new Child("c2", 13);
        Child c3 = new Child("c1", 10);
        Child c4 = new Child("c2", 15);
        Worker2 worker1 = new Worker2("123", List.of(c1, c2, c3));
        Worker2 worker2 = new Worker2("456", List.of(c4));
        assertEquals(2, OptionalFilter.defineChildren(List.of(worker1, worker2), "123").size());
    }
}
