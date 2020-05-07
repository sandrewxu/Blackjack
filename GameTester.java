import java.util.Scanner;

public class GameTester {
    public static void main(String[] args) {
        Deck regDeck = new Deck();

        Scanner name = new Scanner(System.in);
        System.out.print("What's your name? ");
        String p1Name = name.nextLine();

        Scanner startMoney = new Scanner(System.in);
        System.out.print("How much money are you playing with today? ");
        int money = startMoney.nextInt();

        Person p1 = new Person(p1Name, money, 0);
        Person Dealer = new Person("Dealer", 1, 0);

        Game Blackjack = new Game(p1, Dealer, regDeck);
        boolean play = true;
        while (play && p1.getMoney() > 0) {
            Blackjack.playGame();
            if (p1.getMoney() >= 3 * money) {
                Scanner playAgain = new Scanner(System.in);
                System.out.print("\nWould you like to play again? ");
                if (!playAgain.nextLine().equalsIgnoreCase("yes")) play = false;
            }
        }

        if (p1.getMoney()<=0) System.out.print("\nYou are out of money.");
        System.out.println("\nGAME OVER");

    }
}