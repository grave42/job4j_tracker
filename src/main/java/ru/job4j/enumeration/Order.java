package ru.job4j.enumeration;

public class Order {
    private int number;
    private String car;
    private Status status;

    public Order(int number, String car, Status status) {
        this.number = number;
        this.car = car;
        this.status = status;
    }

    ...геттеры/сеттеры и т.д...

}
