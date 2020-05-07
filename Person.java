public class Person {
    private String name;
    private int money;
    private int gamesWon;

    public Person(String n, int startMoney, int wins) {
        name = n;
        money = startMoney;
        gamesWon = wins;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public void wonGame() {
        gamesWon++;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public void changeMoney(int change) {
        money += change; // Changes amount of money left
    }
}
