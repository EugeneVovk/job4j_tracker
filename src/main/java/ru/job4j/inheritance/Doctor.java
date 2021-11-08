package ru.job4j.inheritance;

public class Doctor extends Profession {
    private String diagnosis;

    public Doctor(String name, String surname, String education, int birthday, String diagnosis) {
        super(name, surname, education, birthday);
        this.diagnosis = diagnosis;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void canDiagnose(String diagnosis) {
        System.out.println("Your diagnosis is " + diagnosis);
    }

    public void canDiagnose() {
        System.out.println("I can diagnose");
    }
}
