package com.anthonytimotheou.model.com.anthonytimotheou.environment;


import com.anthonytimotheou.model.PropertyGroup;
import com.anthonytimotheou.model.cards.Card;
import com.anthonytimotheou.model.cards.CardDeck;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Enforces 3 turns per player?
public class Match {
  private List<Player> mPlayers = new ArrayList<>();
  private CardDeck mCardDeck = new CardDeck();
  private List<Card> mPlayedCardPile = new ArrayList<>();

  public List<Player> getPlayers() {
    return mPlayers;
  }

  public CardDeck getCardDeck() {
    return mCardDeck;
  }

  public void playMatch() {
    // Create new Card Deck
    mCardDeck.createNewDeck();
    mCardDeck.shuffleDeck();
    mCardDeck.printDeckToStandardOut();

    // Add players
    mPlayers.add(new Player("Zoe"));
    mPlayers.add(new Player("Anthony"));
    //mPlayers.add(new Player("Max"));

    // Deal 5 cards to each player by one card at a time to each player
    for (int i = 0; i < 5; i ++) {
      // Deal a card to each player
      for (Player lPlayer : mPlayers) {
        // want to do this
        lPlayer.receiveCard(mCardDeck.takeCard());
      }
    }

    for (Player lPlayer : mPlayers) {
      lPlayer.printCardsInHand();
    }

    boolean lWonGame = false;

    // TODO AT - Need to add time constraint too so the game doesn't go on forever
    while (!lWonGame) {
      // how are rules of match encoded? Single place outside or within each players logic?
      // Are they allowed to try and make a bad move or are they forced into the rules?

      // TODO AT - add in age of player and logic to chose and enforce player go
      for (Player lPlayer : mPlayers) {
        System.out.println("Starting player's " + lPlayer.getName() + " turn");
        // TODO AT - Check the deck here, if it is full then take all cards from used pile shuffle and place back in deck

        // If card deck has less than 5 cards then add more
        if (mCardDeck.getCardDeck().size() < 5) {
          System.out.println("Deck being replenished from playing card pile.");
          mCardDeck.getCardDeck().addAll(mPlayedCardPile);
          mPlayedCardPile.removeAll(mPlayedCardPile);
          mCardDeck.shuffleDeck();
        }

        // Check if player has no cards in hand, if no cards then deal 5, otherwise deal 2
        if (lPlayer.getCardsInHand().size() == 0) {
          System.out.println("Player " + lPlayer.getName() + " is being dealt 5 cards due to an empty hand.");
          // Deal an extra three cards, so it totals five
          lPlayer.receiveCard(mCardDeck.takeCard());
          lPlayer.receiveCard(mCardDeck.takeCard());
          lPlayer.receiveCard(mCardDeck.takeCard());
        }

        // Deal two cards to play taking turn
        lPlayer.receiveCard(mCardDeck.takeCard());
        lPlayer.receiveCard(mCardDeck.takeCard());

        // Construct other players (all players but this one and pass that to them along
        // with the card pile (so can see last card played)
        // tell player to take move, must give them information to take move with
        lPlayer.takeTurn(this);

        // check whether the player has won ( check for three sets in there property area )
        int lNumberOfFullSets = 0;
        for (Map.Entry<PropertyGroup, List<Card>> lPropertyEntry : lPlayer.getPropertyArea().entrySet()) {
          PropertyGroup lPropertyGroup = lPropertyEntry.getKey();
          List<Card> lCardsInGroup = lPropertyEntry.getValue();
          if (lCardsInGroup != null) {
            if (lCardsInGroup.size() == lPropertyGroup.getCompletedSetNumber() || lCardsInGroup.size() > lPropertyGroup.getCompletedSetNumber()) {
              lNumberOfFullSets++;
            }
          }
        }

        if (lNumberOfFullSets == 3) {
          // Exit the game has been won
          System.out.print("The winner with three sets is " + lPlayer.getName());
          return;
        }
      }
    }
  }

  public boolean playCard(Card pCard, Player pSourcePlayer, Player pTargetPlayer, PropertyGroup lSourcePropertyGroup, PropertyGroup lTargetPropertyGroup) {
    // Put the card into the played cards pile, it will already of been removed from the hand
    mPlayedCardPile.add(pCard);

    if (pCard.isPlayable(this, pSourcePlayer, pTargetPlayer, lTargetPropertyGroup, lSourcePropertyGroup)) {
      pCard.executeBehaviour(this, pSourcePlayer, pTargetPlayer, lTargetPropertyGroup, lSourcePropertyGroup);
      return true;
    } else {
      System.out.println("Failed to play card: " + pCard.getName());
      return false;
    }
    // Logic for playing a card?
    // Uses behaviour of card and additional information passed through to perform action
    // apply behaviour to match by calling execute behaviour on card?
  }

  public static void main(String[] args) {
    Match lMatch = new Match();
    lMatch.playMatch();
  }
}
