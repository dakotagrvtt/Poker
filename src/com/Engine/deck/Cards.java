package com.Engine.deck;

import java.util.HashMap;
import java.util.Map;

public class Cards implements Comparable<Cards> {

    private final Rank rank;
    private final Suit suit;

    public Cards(final Rank rank, final Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    private final static Map<String, Cards> CARDS = createCard();

    // populates a hashmap with all possible combinations of cards
    private static Map<String, Cards> createCard() {
        final Map<String, Cards> card = new HashMap<>();
        for (final Rank rank : Rank.values()) {
            for (final Suit suit : Suit.values()) {
                card.put(cardKey(rank, suit), new Cards(rank, suit));
            }
        }
        return card;
    }

    // generate card string for keying in card hashmap
    // (ie. ACE of SPADES, TWO of CLUBS, etc.)
    private static String cardKey(Rank rank, Suit suit) {
        return rank + " of " + suit;
    }

/*
*   PUBLIC METHODS
*/
    static Cards getCard(final Rank rank, final Suit suit) {
        final Cards card = CARDS.get(cardKey(rank, suit));

        if (card != null) {
            return card;
        }
        throw new RuntimeException("Invalid card!: " + rank + " " + suit);
    }

    public Rank getValue() {
        return this.rank;
    }
    
    public Suit getSuit() {
        return this.suit;
    }

    /*
    *   OVERRIDES
    */
    @Override
    public String toString() {
        return String.format(this.rank + " of " + this.suit);
    }

    @Override
    public int compareTo(final Cards o) {
        final int rankComparison = Integer.compare(this.rank.getRankValue(), o.rank.getRankValue());

        if (rankComparison != 0) {
            return rankComparison;
        }

        return Integer.compare(this.suit.getSuitValue(), o.suit.getSuitValue());
    }
}
