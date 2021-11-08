package ru.job4j.inheritance;

public class Dentist extends Doctor {
    private int tooth;

    public Dentist(String name, String surname, String education,
                   int birthday, String diagnosis, int tooth) {
        super(name, surname, education, birthday, diagnosis);
        this.tooth = tooth;
    }

    public void fixTeeth(Doctor diagnosis, int tooth) {
        System.out.println("I can treat teeth " + tooth
                + " and can heal " + diagnosis);
    }

    public void fixTeeth() {
        System.out.println("I can treat teeth");
    }
}
