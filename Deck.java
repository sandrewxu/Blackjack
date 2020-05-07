import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> deck;

    public Deck() {
        deck = new ArrayList<Card>();

        String[] names = new String[52]; //declares names
        String[] suits = new String[52]; // declares suits
        int[] values = new int[52]; // declares values

        for (int i = 0; i < 52; i++) {
            //Setting Values
            int val = i % 13;
            if (val == 0) values[i] = 11; //IF ACE
            else if (val > 8) values[i] = 10; // IF FACE CARD
            else values[i] = val + 1; // ALL ELSE

            //Setting Suit
            int suit = i / 13;
            if (suit == 0) suits[i] = "S"; // Spades
            else if (suit == 1) suits[i] = "C"; // Clubs
            else if (suit == 2) suits[i] = "H"; //Hearts
            else suits[i] = "D"; //Diamonds

            //Setting Name
            if (values[i] == 11) names[i] = "A";
            else if (val == 10) names[i] = "J";
            else if (val == 11) names[i] = "Q";
            else if (val == 12) names[i] = "K";
            else names[i] = Integer.toString(values[i]);

            deck.add(new Card(suits[i], names[i], values[i]));
        }
    }

    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    public void add(Card c) {
        deck.add(c);
    }

    public void remove(int n) {
        deck.remove(n);
    }

    public int getValue(int n) {
        return deck.get(n).getValue();
    }

    public String getName(int n) {
        return deck.get(n).getName();
    }

    public String getSuit(int n) {
        return deck.get(n).getSuit();
    }
}
