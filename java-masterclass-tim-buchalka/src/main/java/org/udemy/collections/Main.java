package org.udemy.collections;

import java.util.Arrays;
import java.util.List;

public class Main {
    private final Main main;

    public Main(Main main) {
        this.main = main;
    }

    public static void main(String[] args) {
        List<Card> deck = Card.getStandardDeck();
        Card.printDeck(deck);

        Card[] cards = new Card[13];
        Card aceOfHearts = Card.getFaceCard(Suit.HEART, 'A');
        Arrays.fill(cards, aceOfHearts);
        Card.printDeck(Arrays.asList(cards), "Ace of Hearts", 1);
    }
}
