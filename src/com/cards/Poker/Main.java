package com.cards.Poker;

import com.Engine.deck.Deck;

public class Main {
    public static void main(String[] args) throws Exception {
        //Player players.numOfPlayers(3);
        double money = 1000.00;

        // Game Loop
        while (money > 0) {
            // If start game...
            // Choose number of players (2-6)

            // Random player deals out cards first
            Deck deck = new Deck();

            int deckSize = 5;
            for (int i = 0; i < deckSize; i++) {
                System.out.println(deck.dealCard());
            }
        }
    }
}
