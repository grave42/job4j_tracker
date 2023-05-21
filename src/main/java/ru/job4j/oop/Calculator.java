package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int a) {
        return x - a;
    }

    public int divide(int a) {
        return a / x;
    }

    public int sumAllOperation(int a) {
        int rsl = sum(a) + minus(a) + multiply(a) + divide(a);
        return rsl;
    }

    public static void main(String[] args) {
        int result = sum(10);
        System.out.println(result);
        Calculator calculator = new Calculator();
        int rsl = calculator.multiply(5);
        System.out.println(rsl);
        int rslMinus = minus(10);
        System.out.println(rslMinus);
        int rslDivide = calculator.divide(15);
        System.out.println(rslDivide);
        int rslAll = calculator.sumAllOperation(20);
        System.out.println(rslAll);

    }
}