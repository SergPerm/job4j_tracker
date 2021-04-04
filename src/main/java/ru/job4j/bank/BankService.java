package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
         users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
         User user = findByPassport(passport);
         List<Account> userAccounts = users.get(user);
         if (user != null && !userAccounts.contains(account)) {
             userAccounts.add(account);
         }

    }

    public User findByPassport(String passport) {
        User rsl = null;
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                rsl = user;
                break;
            }
        }
        return rsl;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        User user = findByPassport(passport);
        List<Account> account = users.get(user);
        if (account != null) {
            for (Account acc : account) {
                if (requisite.equals(acc.getRequisite())) {
                    rsl = acc;
                    break;
                }
            }
        }
        return rsl;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account accountSrc = findByRequisite(srcPassport, srcRequisite);
        Account accountDest = findByRequisite(destPassport, destRequisite);
        if (accountDest != null
            && accountSrc != null
            && accountSrc.getBalance() >= amount) {
        accountSrc.setBalance(accountSrc.getBalance() - amount);
        accountDest.setBalance(accountDest.getBalance() + amount);
        addAccount(srcPassport, accountSrc);
        addAccount(destPassport, accountDest);
        rsl = true;
        }
        return rsl;
    }
}