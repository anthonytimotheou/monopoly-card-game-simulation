package com.anthonytimotheou.model.com.anthonytimotheou.environment;


import com.anthonytimotheou.model.cards.Card;
import com.anthonytimotheou.model.cards.CardDeck;

import java.util.ArrayList;
import java.util.List;

public class Match {
  // For now this represents the board as the player has the board as part of their areas.
  List<Card> lCardDeck = new ArrayList<>();
  List<Card> lCardPile = new ArrayList<>();

  private static List<Player> mPlayers = new ArrayList<>();
  private static CardDeck mCardDeck = new CardDeck();

  public static void main(String[] args) {
    // Create new Card Deck
    mCardDeck.createNewDeck();
    mCardDeck.shuffleDeck();
    mCardDeck.printDeckToStandardOut();

    // Add players
    mPlayers.add(new Player("Zoe"));
    mPlayers.add(new Player("Anthony"));
    mPlayers.add(new Player("Max"));

    // Deal 5 cards to each player by one card at a time to each player
    for (int i = 0; i < 5; i ++) {
      // Deal a card to each player
      for (Player lPlayer : mPlayers) {
        // want to do this
        //lPlayer.receiveCard();
      }
    }

    // Place cards on deck

    // Signify to the first player he can match his move

    // Calculate some shizzle

    // Next place in a loop? Until the game has ended? What happens if it doesn't end? A time limit?
  }
}
