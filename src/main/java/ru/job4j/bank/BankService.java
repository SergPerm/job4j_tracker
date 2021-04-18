package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу сервиса по учету клиентов и их счетов, их поиску,
 * и учет переводов между счетами.
 * @author Serg Mokhin
 * @version 1.0
 */
public class BankService {
    /**
     * хранение всех пользователей и их счетов осуществляется в коллекции типа HashMap
     * с ключом по типу User и коллекцией типа ArrayList в качестве значения.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * метод добавляющий пользователя в коллекцию, но только если его ещё там нет,
     * и инициализирует ему новый список счетов.
     * @param user новый пользователь
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * метод осуществляющий добавление нового счета пользователю, но только если его ещё нет
     * используя {@link  BankService#findByPassport(String passport)}  c параметром passport.
     * если такого пользователя нет, или такой счёт уже существует, то метод ничего не делает
     * @param passport параметр для поиска нужного пользователя.
     * @param account добавляемый аккаунт
     */
    public void addAccount(String passport, Account account) {
         User user = findByPassport(passport);
         List<Account> userAccounts = users.get(user);
         if (user != null && !userAccounts.contains(account)) {
             userAccounts.add(account);
         }

    }

    /**
     * метод осуществляет поиск пользователя по паспорту
     * @param passport поле пользователя позволяющее однозначно его идентифицировать.
     * @return возвращает найденного пользователя или null если такого нет.
     */
    public User findByPassport(String passport) {
        return users.keySet().stream()
                .filter(user -> passport.equals(user.getPassport()))
                .findFirst()
                .orElse(null);
    }

    /**
     * метод осуществляет поиск счетов пользователя по его паспорту и реквизитам счёта,
     * используя {@link  BankService#findByPassport(String passport)}  c параметром passport.
     * если такой существует, то в списке его счётов ищется счёт по реквизитам requisite и
     * возвращается найденный счет, если что-либо отсутствует, то возвращается null
     * @param passport строка паспорт для поиска пользователя,
     * @param requisite строка реквизит для поиска счёта пользователя,
     * @return  возвращает счёт или null
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        return user != null ? users.get(user).stream()
                    .filter(account1 -> requisite.equals(account1.getRequisite()))
                    .findFirst()
                    .orElse(null)
                    : null;
    }

    /**
     * метод осуществляет перевод средств между счетами пользователей. поиск счетов пользователей
     * с помощью {@link  BankService#findByRequisite(String passport, String requisite)}
     * по полученным параметрами passport и реквизиты счёта requisite, если такие нашлись, то
     * проверяется наличие достаточного количества средств у отправителя,должно быть больше или
     * равно переводимой сумме
     * @param srcPassport паспорт отправителя
     * @param srcRequisite реквизиты счёта отправителя
     * @param destPassport паспорт получателя
     * @param destRequisite реквизиты счёта получателя
     * @param amount переводимая сумма
     * @return true если есть такие счета и у отправителя достаточно средств на счёте иначе false
     */
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