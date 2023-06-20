package ru.job4j.ooa;

import java.util.Objects;

public final class Airbus extends Aircraft {
    private static final int COUNT_ENGINE = 2;
    private static final int COUNT_ENGINE_A380 = 4;
    private String name;

    public Airbus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void printModel() {
        System.out.println("Модель самолета: " + name);
    }

    public void printCountEngine(String name) {
        int result = Objects.equals(name, "A380") ? COUNT_ENGINE_A380 : COUNT_ENGINE;
        System.out.println("Количество двигателей равно: " + result);
    }

    @Override
    public String toString() {
        return "Airbus{"
                + "name='" + name + '\''
                + '}';
    }
}
