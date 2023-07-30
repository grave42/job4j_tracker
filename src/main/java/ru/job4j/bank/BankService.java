package ru.job4j;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.*;

import static java.util.Objects.isNull;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        if (!users.containsKey(user)) {
            users.put(user, new ArrayList<Account>());
        }
    }

    public boolean deleteUser(String passport) {
        Set<User> allUsers = users.keySet();
        for (User user : allUsers) {
            if (user.getPassport().equals(passport)) {
                users.remove(user);
                return true;
            }
        }
        return false;

    }

    public void addAccount(String passport, Account account) {
        Set<User> allUsers = users.keySet();
        for (User user : allUsers) {
            if (user.getPassport().equals(passport) && !users.get(user).contains(account)) {
                users.get(user).add(account);
            }
        }

    }

    public User findByPassport(String passport) {
        Set<User> allUsers = users.keySet();
        for (User user : allUsers) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (!isNull(user)) {
            List<Account> accs = users.get(user);
            for (Account acc : accs) {
                if (acc.getRequisite().equals(requisite)) {
                    return acc;
                }
            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account acc = findByRequisite(srcPassport, srcRequisite);
        Account destAcc = findByRequisite(destPassport, destRequisite);
        if (acc == null || destAcc == null) {
            return rsl;
        }
        double srcBalance = acc.getBalance();
        double destBalance = destAcc.getBalance();
        if (srcBalance < amount) {
            return rsl;
        }
        acc.setBalance(srcBalance - amount);
        destAcc.setBalance(destBalance + amount);
        rsl = true;
        return rsl;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
