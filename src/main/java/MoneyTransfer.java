import java.util.Arrays;

public class MoneyTransfer {
    public static void main(String[] args) {
        Bank bank = new Bank(
                Arrays.asList(new Account(), new Account(), new Account(), new Account(), new Account(), new Account())
        );

    }
}
