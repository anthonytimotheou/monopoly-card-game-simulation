package com.anthonytimotheou.model.com.anthonytimotheou.environment;


import com.anthonytimotheou.model.cards.CardDeck;

public class Match {

  public static void main(String[] args) {
    CardDeck lCardDeck = new CardDeck();
    lCardDeck.createNewDeck();
    lCardDeck.shuffleDeck();
    lCardDeck.printDeckToStandardOut();
  }
}
