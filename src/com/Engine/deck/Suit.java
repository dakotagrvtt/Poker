package com.Engine.deck;

public enum Suit {
    CLUBS(1),
    DIAMONDS(2),
    HEARTS(3),
    SPADES(4);

    private final int suitValue;
    
    Suit(final int suitValue) {
        this.suitValue = suitValue;
    }

    public int getSuitValue(){
        return this.suitValue;
    }
}