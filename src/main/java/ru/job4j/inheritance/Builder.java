package ru.job4j.inheritance;

public class Builder extends Engineer {
    private String typeHouse;

    public Builder(String name, String surname, String education,
                   int birthday, String task, String typeHouse) {
        super(name, surname, education, birthday, task);
        this.typeHouse = typeHouse;
    }

    public void buildHouse(String typeHouse) {
        System.out.println("I can build " + typeHouse
                + " and I can do " + getTask());
    }

    public void buildHouse() {
        System.out.println("I can build a house");
    }
}
