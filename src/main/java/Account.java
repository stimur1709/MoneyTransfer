import java.util.Random;

public class Account {

    private String id;
    private long money;

    public Account(){
        this.money = 10000;
        this.id = generatedId();
    }

    private String generatedId() {
        Random random = new Random();
        return random.ints(97, 123).limit(10)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public String getId() {
        return id;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }
}
