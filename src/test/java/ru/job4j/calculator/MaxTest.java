package ru.job4j.calculator;

import org.junit.Assert;
import org.junit.Test;

public class MaxTest {

    @Test
    public void whenSecondOfTwo() {
        int first = 2;
        int second = 25;
        int rsl = Max.max(first, second);
        int expected = 25;
        Assert.assertEquals(expected, rsl);
    }

    @Test
    public void whenFirstEqualSecond() {
        int first = 2;
        int second = 2;
        int rsl = Max.max(first, second);
        int expected = 2;
        Assert.assertEquals(expected, rsl);
    }

    @Test
    public void whenFirstOfTwo() {
        int first = 2;
        int second = 0;
        int rsl = Max.max(first, second);
        int expected = 2;
        Assert.assertEquals(expected, rsl);
    }

    @Test
    public void whenFirstOfThreeMax() {
        int first = 52;
        int second = 25;
        int third = 3;
        int rsl = Max.max(first, second, third);
        int expected = 52;
        Assert.assertEquals(expected, rsl);
    }

    @Test
    public void whenSecondOfThreeMax() {
        int first = 52;
        int second = 125;
        int third = 3;
        int rsl = Max.max(first, second, third);
        int expected = 125;
        Assert.assertEquals(expected, rsl);
    }

    @Test
    public void whenThirdOfThreeMax() {
        int first = 52;
        int second = 25;
        int third = 300;
        int rsl = Max.max(first, second, third);
        int expected = 300;
        Assert.assertEquals(expected, rsl);
    }

    @Test
    public void whenFirstOfFourMax() {
        int first = 52;
        int second = 25;
        int third = 3;
        int fourth = 13;
        int rsl = Max.max(first, second, third, fourth);
        int expected = 52;
        Assert.assertEquals(expected, rsl);
    }

    @Test
    public void whenFourthOfFourMax() {
        int first = 52;
        int second = 25;
        int third = 3;
        int fourth = 130;
        int rsl = Max.max(first, second, third, fourth);
        int expected = 130;
        Assert.assertEquals(expected, rsl);
    }

    @Test
    public void whenSecondOfFourMax() {
        int first = 52;
        int second = 250;
        int third = 3;
        int fourth = 13;
        int rsl = Max.max(first, second, third, fourth);
        int expected = 250;
        Assert.assertEquals(expected, rsl);
    }

    @Test
    public void whenThirdOfFourMax() {
        int first = 52;
        int second = 52;
        int third = 53;
        int fourth = 13;
        int rsl = Max.max(first, second, third, fourth);
        int expected = 53;
        Assert.assertEquals(expected, rsl);
    }

    @Test
    public void whenAllNumsEqualMax() {
        int first = 0;
        int second = 0;
        int third = 0;
        int fourth = 0;
        int rsl = Max.max(first, second, third, fourth);
        int expected = 0;
        Assert.assertEquals(expected, rsl);
    }
}