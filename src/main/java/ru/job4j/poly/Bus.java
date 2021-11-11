package ru.job4j.poly;

public class Bus implements Transport {
    private int fuel;

    @Override
    public void ride() {
        System.out.println("The bus ride");
    }

    @Override
    public void passengers(int number) {
        System.out.println("The number of passengers in the bus is " + number);
    }

    @Override
    public int refuel(int fuel) {
        this.fuel += fuel;
        fuel = 0;
        return 0;
    }
}
