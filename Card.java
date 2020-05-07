public class Card {
    private String suit; //Suit of Card
    private String name; // Name of Card
    private int value; // Number Value in BlackJack

    public Card(String s, String n, int v) {
        suit = s;
        name = n;
        value = v;
    }

    public String toString() {
        return name + suit;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public String getSuit() {
        return suit;
    }
}