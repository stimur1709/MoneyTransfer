import java.util.Random;

public class Client extends Thread {

    private final Bank bank;
    private final Random random = new Random();

    public Client(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            try {
                Thread.sleep(1000 + random.nextInt(2000 - 1000 + 1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            bank.transferringMoneyBetweenAccounts(
                    random.nextInt(bank.getAccounts().size()),
                    random.nextInt(bank.getAccounts().size()),
                    random.nextInt(5000)
            );
        }
    }
}
