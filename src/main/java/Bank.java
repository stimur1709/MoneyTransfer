import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private final List<Account> accounts;
    private static final Logger log = Logger.getLogger(Bank.class);

    public Bank(List<Account> accounts) {
        this.accounts = new ArrayList<>();
        this.accounts.addAll(accounts);
    }

    public long getAllMoney() {
        return accounts.stream().mapToLong(Account::getMoney).sum();
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void transferringMoneyBetweenAccounts(int fromAccountNum, int toAccountNum, long transferAmount) {
        if (fromAccountNum != toAccountNum && accounts.get(fromAccountNum).getMoney() > transferAmount) {
            accounts.get(fromAccountNum).setMoney(-transferAmount);
            accounts.get(toAccountNum).setMoney(transferAmount);
            log.info(String.format("Перевод выполнен. Сумма операции %d. Баланс счета отправителя №%s - %d рублей." +
                            " Баланс счета получателя №%s - %d рублей.",
                    transferAmount, accounts.get(fromAccountNum).getId(), accounts.get(fromAccountNum).getMoney(),
                    accounts.get(toAccountNum).getId(), accounts.get(toAccountNum).getMoney()));
        }
        if (fromAccountNum == toAccountNum) {
            log.error(String.format("Перевод со своего счета на свой счет невозможен. Счет №%s.",
                    accounts.get(fromAccountNum).getId()));
        }
        if (accounts.get(fromAccountNum).getMoney() < transferAmount){
            log.error(String.format("Недостаточно средств для перевода %d рублей на счет №%s. Баланс счета отправителя: %d",
                    transferAmount, accounts.get(toAccountNum).getId(), accounts.get(fromAccountNum).getMoney()));
        }
    }
}