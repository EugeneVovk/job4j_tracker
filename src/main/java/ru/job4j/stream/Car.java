package ru.job4j.stream;

public class Car {
    private String brand;
    private String model;
    private String color;
    private boolean electricCar;
    private int maximalSpeed;
    private int year;
    private int passengerCapacity;

    @Override
    public String toString() {
        return "Car{"
                + "brand='" + brand + '\''
                + ", model='" + model + '\''
                + ", color='" + color + '\''
                + ", electricCar='" + electricCar + '\''
                + ", maximalSpeed=" + maximalSpeed
                + ", year=" + year
                + ", passengerCapacity=" + passengerCapacity
                + '}';
    }

    static class Builder {
        private String brand;
        private String model;
        private String color;
        private boolean electricCar;
        private int maximalSpeed;
        private int year;
        private int passengerCapacity;

        Builder buildBrand(String brand) {
            this.brand = brand;
            return this;
        }

        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildColor(String color) {
            this.color = color;
            return this;
        }

        Builder buildElectricCar(boolean electricCar) {
            this.electricCar = electricCar;
            return this;
        }

        Builder buildMaximalSpeed(int maximalSpeed) {
            this.maximalSpeed = maximalSpeed;
            return this;
        }

        Builder buildYear(int year) {
            this.year = year;
            return this;
        }

        Builder buildPassengerCapacity(int passengerCapacity) {
            this.passengerCapacity = passengerCapacity;
            return this;
        }

        Car build() {
            Car car = new Car();
            car.brand = brand;
            car.model = model;
            car.color = color;
            car.electricCar = electricCar;
            car.maximalSpeed = maximalSpeed;
            car.year = year;
            car.passengerCapacity = passengerCapacity;
            return car;
        }
    }

    public static void main(String[] args) {
        Car car = new Builder()
                .buildBrand("Tesla")
                .buildModel("Roadster")
                .buildColor("White")
                .buildElectricCar(true)
                .buildMaximalSpeed(400)
                .buildYear(2021)
                .buildPassengerCapacity(2)
                .build();
        System.out.println(car);
    }
}
