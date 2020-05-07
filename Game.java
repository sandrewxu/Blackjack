import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private Person p1;
    private Person Dealer;
    private Deck fullDeck;
    private Deck newDeck;

    public Game(Person a, Person b, Deck deck) {
        p1 = a;
        Dealer = b;
        fullDeck = deck;
        newDeck = fullDeck;
    }

    public void playGame() {
        fullDeck = newDeck;
        fullDeck.shuffleDeck();
        newDeck = fullDeck;

        Scanner bet = new Scanner(System.in);
        System.out.print("\nPlace your bet: ");
        int amount = bet.nextInt();
        if (amount > p1.getMoney()) {
            System.out.println("Sorry, You Don't Have Enough Money");
            return;
        }

        int pTotal = 0, dTotal = 0;
        ArrayList<Card> pDeck = new ArrayList<Card>(), dDeck = new ArrayList<Card>();

        for (int i = 0; i < 2; i++) {
            pDeck.add(new Card(fullDeck.getSuit(0), fullDeck.getName(0), fullDeck.getValue(0)));
            fullDeck.remove(0);
            dDeck.add(new Card(fullDeck.getSuit(0), fullDeck.getName(0), fullDeck.getValue(0)));
            fullDeck.remove(0);
        }

        pTotal = deckSum(pDeck);
        dTotal = deckSum(dDeck);

        while (pTotal <= 21) {
            System.out.print("\nYour hand: " + pDeck.toString());
            System.out.print("\nDealer Card Showing: " + dDeck.get(0));

            Scanner hit = new Scanner(System.in);
            System.out.print("\nDo you want to hit? ");
            if ("yes".equalsIgnoreCase(hit.nextLine())) {
                pDeck.add(new Card(fullDeck.getSuit(0), fullDeck.getName(0), fullDeck.getValue(0)));
                fullDeck.remove(0);
                pTotal = deckSum(pDeck);
            } else break;
        }
        while (dTotal < 17) {
            dDeck.add(new Card(fullDeck.getSuit(0), fullDeck.getName(0), fullDeck.getValue(0)));
            fullDeck.remove(0);
            dTotal = deckSum(dDeck);
        }

        System.out.print("\nYour hand: " + pDeck.toString());
        System.out.print("\nDealer's hand: " + dDeck.toString());

        if (pTotal > 21 || (dTotal < 22 && dTotal > pTotal)) {
            System.out.println("\n" + Dealer.getName() + " wins!");
            p1.changeMoney(-amount);
            Dealer.wonGame();
            System.out.println("You now have $" + p1.getMoney());
        } else if (dTotal <= 21 && dTotal == pTotal) {
            System.out.println("\nIt's a tie!");
            System.out.println("You now have $" + p1.getMoney());
        } else {
            System.out.println("\n" + p1.getName() + " Wins!");
            p1.changeMoney(amount);
            p1.wonGame();
            System.out.println("\nYou now have $" + p1.getMoney());
        }

        System.out.println("\nYou have won " + p1.getGamesWon() + " games.");
        System.out.println("Dealer has won " + Dealer.getGamesWon() + " games.");
    }

    public static int deckSum(ArrayList<Card> cards) {
        int total = 0;
        for (Card c : cards) {
            total += c.getValue();
        }
        return total;
    }
}