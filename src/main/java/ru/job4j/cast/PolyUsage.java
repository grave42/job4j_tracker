package ru.job4j.cast;

public class PolyUsage {
    public static void main(String[] args) {
        Vehicle plane = new Airplane();
        Vehicle bus = new Bus();
        Vehicle train = new Train();
        Vehicle[] vehicles = new Vehicle[]{plane, bus, train};
        for (Vehicle a : vehicles) {
            a.move();
        }
    }
}
