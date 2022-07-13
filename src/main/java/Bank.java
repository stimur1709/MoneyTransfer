import java.util.ArrayList;
import java.util.List;

public class Bank {

    private List<Account> accounts;

    public Bank(List<Account> accounts) {
        this.accounts = new ArrayList<>();
        this.accounts.addAll(accounts);
    }

    public long getAllMoney() {
        return accounts.stream().mapToLong(Account::getMoney).sum();
    }
}
