import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MoneyTransfer {
    public static void main(String[] args) {
        Bank bank = new Bank(Arrays.asList(
                new Account(), new Account(), new Account(), new Account(), new Account(), new Account()
        ));
        System.out.println(bank.getAllMoney());

        ArrayList<Thread> threads =
                IntStream.range(0, 10)
                        .mapToObj(i -> new Thread(new Client(bank))).collect(Collectors.toCollection(ArrayList::new));

        threads.forEach(Thread::start);

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        System.out.println(bank.getAllMoney());
    }
}
