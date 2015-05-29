package info.jayharris.cardgames;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jayharris on 5/28/15.
 */
public class Deck extends LinkedList<Card> {

    public Deck(List<Card> cards) {
        super(cards);
    }

    /**
     * Deal the top card in the deck, removing it from the deck.
     *
     * @return the top card in the deck, or {@code null} if the deck is empty
     */
    public Card deal() {
        return pollFirst();
    }

    /**
     * Deal the top card in the deck face-down.
     *
     * @return the top card in the deck, or {@code null} if the deck is empty
     */
    public Card dealFaceDown() {
        Card card;
        if ((card = deal()) != null && !card.isFacedown()) {
            card.flip();
        }
        return card;
    }

    /**
     * Deal the top card in the deck face-up.
     *
     * @return the top card in the deck, or {@code null} if the deck is empty
     */
    public Card dealFaceUp() {
        Card card;
        if ((card = deal()) != null && card.isFacedown()) {
            card.flip();
        }
        return card;
    }

    /**
     * Shuffle the deck.
     */
    public void shuffle() {
        Collections.shuffle(this);
    }

    protected void print() {
        StringBuilder sb = new StringBuilder();
        for (Card card : this) {
            sb.append(card).append("\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        Deck deck = DeckUtils.createStandardDeck();
        deck.shuffle();
        deck.print();
    }
}
