package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("Clean Code", 123);
        books[1] = new Book("Bad Code", 321);
        books[2] = new Book("Old Code", 212);
        books[3] = new Book("Funny Code", 777);
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName());
        }
        System.out.println("Поменял книги c индексами 0 и 3 местами");
        Book temp = books[0];
        books[0] = books[books.length - 1];
        books[books.length - 1] = temp;
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName());
        }
        System.out.println("А тут вывел только книги с нужным именем");
        for (int i = 0; i < books.length; i++) {
            if (books[i].getName().equals("Clean Code")) {
                System.out.println(books[i].getName());
            }
        }
    }
}

