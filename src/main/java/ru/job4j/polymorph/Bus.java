package ru.job4j.polymorph;

public class Bus implements Transport {

    @Override
    public void toGo() {
        System.out.println("Выезжаем");
    }

    @Override
    public void numbOfPassngers(int passangers) {
        int maxSeats = passangers;
    }

    @Override
    public int makeFuelPrice(int fuel) {
        int price = fuel * 25;
        return price;
    }
}
