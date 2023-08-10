package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает, что хранит в себе User
 * и позволяет задать эти параметры
 */
public class User {
    /**
     * Поле хранит значение паспорта
     */
    private String passport;
    /**
     * Поле хранит юзернейм в системе
     */
    private String username;

    /**
     * Конструктор для создания объекта User
     * @param passport значение паспорта
     * @param username значение юзернейма
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод для получения значения паспорта пользователя
     * @return возвращает значение паспорта
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Мето для записи значения в поле passport
     * @param passport значение паспорта
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод для получения юзернейма
     * @return возвращает юзернейм
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод для задания значения поля username
     * @param username юзернейм пользователя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
