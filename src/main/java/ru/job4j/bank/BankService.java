package ru.job4j;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Objects.isNull;

/**
 * Класс описывает работу банковского сервиса
 * В нём можно проводить создание,изменение, удаление пользователей
 * их аккаунтов
 */
public class BankService {
    /**
     * Хранение пользователей осуществляется в Map
     * он состоит из объекта User и списка Аккаунтов пользвателя.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавляет пользователя в коллекцию, если его еще там нет
     *
     * @param user объект пользователя
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Удаляет пользователя по заданному параметру passoprt
     *
     * @param passport значение паспорта
     * @return Объект пользователя, который был удалён
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    /**
     * Метод добавляет новый аккаунт для пользователя, находя его по паспорту
     *
     * @param passport значение паспорта
     * @param account  Объект Account
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accs = users.get(user);
            if (!accs.contains(account)) {
                accs.add(account);
            }
        }
    }

    /**
     * Метод осуществляет поиск пользователя по паспорту
     *
     * @param passport значение паспорта
     * @return вовзращает пользователя или null если не найден
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод осуществляет поиск Аккаунта по заданным реквизитам
     *
     * @param passport  значение паспорта
     * @param requisite значение реквизитов
     * @return возвращает аккаунт или null если он не найден
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (!isNull(user)) {
            return users.get(user)
                    .stream()
                    .filter(account -> account.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод переводит средства с одного баланса на другой
     *
     * @param srcPassport   значение паспорта пользователя, который совершает перевод
     * @param srcRequisite  значение реквизитов пользователя, который совершает перевод
     * @param destPassport  значение паспорта пользователя куда соврешается перевод
     * @param destRequisite значение ревизвитов пользователя куда совершается перевод
     * @param amount        сумма для перевода
     * @return возвращает true если перевод удалось совершить и false, если нет
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account acc = findByRequisite(srcPassport, srcRequisite);
        Account destAcc = findByRequisite(destPassport, destRequisite);
        if (acc == null || destAcc == null || acc.getBalance() < amount) {
            return false;
        }
        acc.setBalance(acc.getBalance() - amount);
        destAcc.setBalance(destAcc.getBalance() + amount);
        return true;
    }

    /**
     * Метод для поиска всех аккаунтов, заданного пользователя
     *
     * @param user пользователь, чьи аккаунты нужно найти
     * @return возраващет список аккаунтов пользователя
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
