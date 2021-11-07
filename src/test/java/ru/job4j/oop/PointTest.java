package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void when00And00Then0() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 0);
        double rsl = a.distance(b);
        double expected = 0;
        Assert.assertEquals(expected, rsl, 0.01);
    }

    @Test
    public void when00And02Then2() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        double rsl = a.distance(b);
        double expected = 2;
        Assert.assertEquals(expected, rsl, 0.01);
    }

    @Test
    public void when12And12Then0() {
        Point a = new Point(1, 2);
        Point b = new Point(1, 2);
        double rsl = a.distance(b);
        double expected = 0;
        Assert.assertEquals(expected, rsl, 0.01);
    }

    @Test
    public void when12And34Then2dot83() {
        Point a = new Point(1, 2);
        Point b = new Point(3, 4);
        double rsl = a.distance(b);
        double expected = 2.83;
        Assert.assertEquals(expected, rsl, 0.01);
    }

    @Test
    public void when12AndMinus3Minus4Then7dot21() {
        Point a = new Point(1, 2);
        Point b = new Point(-3, -4);
        double rsl = a.distance(b);
        double expected = 7.21;
        Assert.assertEquals(expected, rsl, 0.01);
    }

    @Test
    public void when125And342Then5dot74() {
        Point a = new Point(1, 2, 5);
        Point b = new Point(3, 4, 0);
        double rsl = a.distance3d(b);
        double expected = 5.74;
        Assert.assertEquals(expected, rsl, 0.01);
    }

    @Test
    public void when123AndMinus3Minus40Then7dot81() {
        Point a = new Point(1, 2, 3);
        Point b = new Point(-3, -4, 0);
        double rsl = a.distance3d(b);
        double expected = 7.81;
        Assert.assertEquals(expected, rsl, 0.01);
    }

    @Test
    public void whenAllValuesAreTheSameThen0() {
        Point a = new Point(-1, -1, -1);
        Point b = new Point(-1, -1, -1);
        double rsl = a.distance3d(b);
        double expected = 0;
        Assert.assertEquals(expected, rsl, 0.01);
    }
}