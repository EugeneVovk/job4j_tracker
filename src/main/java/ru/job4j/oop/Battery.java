package ru.job4j.oop;

public class Battery {
    private int load;

    public Battery(int load) {
        this.load = load;
    }

    public void exchange(Battery another) {
        another.load += this.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery battery1 = new Battery(9);
        Battery battery2 = new Battery(100);
        System.out.println("battery1: " + battery1.load
                + " - battery2: " + battery2.load);
        battery1.exchange(battery2);
        System.out.println("battery1: " + battery1.load
                + " - battery2: " + battery2.load);
    }
}
