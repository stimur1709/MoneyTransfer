import java.util.ArrayList;
import java.util.List;

public class Bank {

    private final List<Account> accounts;

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
        if(fromAccountNum == toAccountNum) {
            System.out.println("Перевод на свой счет невозможен");
        }
        if (accounts.get(fromAccountNum).getMoney() < transferAmount) {
            System.out.println("Недостаточно средств для перевода");
            System.out.println(accounts.get(fromAccountNum) + " --- " + transferAmount);
        }
        else {
            accounts.get(fromAccountNum).setMoney(-transferAmount);
            accounts.get(toAccountNum).setMoney(transferAmount);
            System.out.println("Перевод выполнен " + accounts.get(fromAccountNum) + " !! " +
                    accounts.get(toAccountNum) + " !! " + transferAmount);
        }
    }
}