import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MoneyTransfer {
    public static void main(String[] args) {
        Logger log = Logger.getLogger(MoneyTransfer.class);
        Bank bank = new Bank(Arrays.asList(
                new Account(), new Account(), new Account(), new Account(), new Account(), new Account()
        ));
        int maxNumberThreads = 4;

        log.info(String.format("Количество денег в банке до переводов %d рублей", bank.getAllMoney()));

        ArrayList<Thread> threads =
                IntStream.range(0, maxNumberThreads)
                        .mapToObj(i -> new Thread(new Client(bank))).collect(Collectors.toCollection(ArrayList::new));

        threads.forEach(Thread::start);

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        log.info(String.format("Количество денег в банке после переводов %d рублей", bank.getAllMoney()));
    }
}
