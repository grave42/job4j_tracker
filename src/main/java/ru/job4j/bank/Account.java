package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает создание банковского аккаунта
 */
public class Account {
    /**
     * Поле отвечает за реквизиты
     */
    private String requisite;
    /**
     * Поле отвечает за сумму на балансе
     */
    private double balance;

    /**
     * Конструктор для аккаунта
     * @param requisite - задаются реквизиты аккаунта
     * @param balance - указывается баланс
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     *
     * @return получение реквизитов
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Запись ревизитов
     * @param requisite ревизиты, которые нужно запсать
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Мето для получения баланса
     * @return возвращает сумму на балансе
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Задать баланс
     * @param balance сумма, которую нужно добавить на баланс
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}