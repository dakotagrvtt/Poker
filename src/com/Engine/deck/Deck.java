package com.Engine.deck;


import java.util.Collections;
import java.util.Random;
import java.util.Stack;

public class Deck {
    private final Stack<Cards> deckOfCards;

    public Deck(){
        this.deckOfCards = initDeck();
    }

    private Stack<Cards> initDeck() {
        final Stack<Cards> deckOfCards = new Stack<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()){
                deckOfCards.push(Cards.getCard(rank, suit));
            }
        }
        // Shuffle deck random (5-15) times
        Random random = new Random();
        int shuffles = random.nextInt((15 - 5) + 1) + 5;
        System.out.println("Shuffled " + shuffles + " times.");
        for (int i = 0; i < shuffles; i++){
            Collections.shuffle(deckOfCards);
        }
        return deckOfCards;
    }

    // Deck size
    public int size() {
        return this.deckOfCards.size();
    }

/* 
*   PUBLIC METHODS
*/
    // Deals out card
    // Checks for nulls and warns user if there is no card in stack
    public Cards dealCard() {
        if (deckOfCards != null){
            return this.deckOfCards.pop();
        } throw new NullPointerException("NO CARD AVAILABLE!");
    }
}
