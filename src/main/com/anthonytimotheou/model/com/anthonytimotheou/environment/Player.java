package com.anthonytimotheou.model.com.anthonytimotheou.environment;


import com.anthonytimotheou.model.PropertyGroup;
import com.anthonytimotheou.model.cards.Card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {
  private final String mName;
  private final Map<PropertyGroup, List<Card>> mPropertyArea = new HashMap<>();
  private final Area mBankArea = new Area();
  private final List<Card> mCardsInHand = new ArrayList<>();

  public Player(String pName) {
    mName = pName;
  }

  public String getName() {
    return mName;
  }

  public Area getBank() {
    return mBankArea;
  }

  public List<Card> getCardsInHand() {
    return mCardsInHand;
  }

  public void receiveCard(Card pCard) {
    mCardsInHand.add(pCard);
  }

  public void printCardsInHand() {
    System.out.println("---------------");
    System.out.println("Player: " + mName);
    for (Card lCard : mCardsInHand) {
      System.out.println(lCard);
    }
    System.out.println("---------------");
  }

  public Map<PropertyGroup, List<Card>> getPropertyArea() {
    return mPropertyArea;
  }

  public void takeTurn(Match pMatch) {
    // TODO AT - call AI to choose three cards
    // play three cards through match object
    for (int i = 0; i < 3; i++ ) {
      // TODO AT - at the moment just play the first three cards in the hand
      // Target player if applicable? AI must chose this, start with no target player, just two players in the game
      boolean lPlayedCardSuccessfully = pMatch.playCard(mCardsInHand.get(0));
      // TODO AT - what to do here? how to pick another card / what if that fails? overall for loop
      mCardsInHand.remove(0);
    }
  }

  public List<Card> getPayment(int pValue) {
    List<Card> lBankCardList = mBankArea.getCardList();

    // Order cards by high to low
    Collections.sort(lBankCardList, Collections.reverseOrder());

    // Quick search for exact value and then return that
    for (Card lCard : lBankCardList) {
      if (lCard.getMonetaryValue() == pValue) {
        lBankCardList.remove(lCard);
        return Arrays.asList(lCard);
      }
    }

    // TODO AT - if we have 10 million here and asking for 5, the 10 will be used when there could be a 5 underneath it this needs to be more intelligent
    // Otherwise return high to low in that order
    List<Card> lPaymentCards = new ArrayList<>();
    for (Card lCard : lBankCardList) {
      lPaymentCards.add(lCard);
      lBankCardList.remove(lCard);

      // Decrement rent required by how much the card was worth
      pValue =- lCard.getMonetaryValue();
      if (pValue < 0) {
        return lPaymentCards;
      }
    }

    // TODO AT - if it is run past the loop there is still rent left to pay so start selling properties

    // TODO AT - if no properties just return what's there
    return Collections.EMPTY_LIST;
  }

  public void givePayment(List<Card> pCardList) {
    // Logic to decide what to do with payment
    // All bank cards file away in to bank
    // All property cards file away into properties
  }

}
