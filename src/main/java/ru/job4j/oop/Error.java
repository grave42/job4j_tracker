package ru.job4j.oop;

public class Error {

    private int number;
    private String name;
    private String message;

    public Error(int number, String name, String message) {
        this.number = number;
        this.name = name;
        this.message = message;
    }

    public Error() {
    }

    public void printInfo() {
        System.out.println("Номер ошибки: " + number);
        System.out.println("Название: " + name);
        System.out.println("Сообщение: " + message);
    }

    public static void main(String[] args) {
        Error error = new Error();
        error.printInfo();
        Error error400 = new Error(400, "bad request", "Некорректный запрос к серверу");
        error400.printInfo();
    }
}
