package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setLastName("Diaz");
        student.setFirstName("Carlos");
        student.setPatronymic("Maria");
        student.setGroup(20);
        student.setAdmission(2020);

        System.out.println("College student: " + student.getFirstName()
                + " " + student.getPatronymic()
                + " " + student.getLastName()
                + ", group number: " + student.getGroup()
                + ", had admission: " + student.getAdmission());
    }
}
