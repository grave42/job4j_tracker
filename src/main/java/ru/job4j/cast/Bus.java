package ru.job4j.cast;

public class Bus implements Vehicle {

    @Override
    public void move() {
        System.out.println("Aвтобус двигается по скоростным трассам");
    }
}