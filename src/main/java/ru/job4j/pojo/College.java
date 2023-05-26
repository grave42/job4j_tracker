package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Вася Додиков");
        student.setGroup("УАА-0223");
        student.setCreated(new Date());
        System.out.println("ФИО: " + student.getName() + ", учится в группе: " + student.getGroup() + " с " + student.getCreated());
    }
}
