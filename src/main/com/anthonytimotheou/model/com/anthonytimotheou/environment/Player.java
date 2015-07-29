package com.anthonytimotheou.model.com.anthonytimotheou.environment;


import com.anthonytimotheou.model.PropertyGroup;
import com.anthonytimotheou.model.cards.Card;
import com.anthonytimotheou.model.cards.PropertyCard;
import com.anthonytimotheou.model.cards.RentCard;

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
    // Shuffle cards in hand at the start just so 3 different ones are played every turn at the moment, randomly
    Collections.shuffle(mCardsInHand);

    System.out.println("Player is taking turn " + this.getName());

    // TODO AT - call AI to choose three cards and the information needed to play them.
    // Play three cards through match object
    for (int i = 0; i < 3; i++ ) {
      // TODO AT - at the moment just play the first three cards in the hand
      // TODO AT - depending on the type of card must choose
      // Target player if applicable? AI must chose this, start with no target player, just two players in the game

      // Get card to play
      Card lCardToPlay = mCardsInHand.get(0);
      // if no more cards to play just skip turn
      if (lCardToPlay == null) {
        continue;
      }

      // Find a player that's not this one
      Player lTargetPlayer = null;
      for (Player lPlayer : pMatch.getPlayers()) {
        // If the player is not himself
        if (lPlayer != this) {
          // mark this player as the target
          lTargetPlayer = lPlayer;
        }
      }

      // TODO AT - lTargetPropertyGroup,
      // Get target property based on first non null property the target player has
      PropertyGroup lTargetPropertyGroup = null;
      for (List<Card> lPropertyCards : lTargetPlayer.getPropertyArea().values() ) {
        for (Card lCard : lPropertyCards) {
          if (lCard instanceof PropertyCard) {
            lTargetPropertyGroup = ((PropertyCard) lCard).getPropertyGroupList().get(0);
          }
        }
      }

      // Choose source property group based on first non null in the players area
      // need to based this on the card too
      PropertyGroup lSourcePropertyGroup = null;
      for (List<Card> lPropertyCards : mPropertyArea.values()) {
        for (Card lCard : lPropertyCards) {
          if (lCard instanceof PropertyCard) {
            lSourcePropertyGroup = ((PropertyCard) lCard).getPropertyGroupList().get(0);
            System.out.println("The source property for this card's turn is " + lSourcePropertyGroup);
          }
        }
      }

      System.out.println("Playing cards in hand size " + mCardsInHand.size());
      System.out.println("Playing card " + lCardToPlay);

      boolean lPlayedCardSuccessfully = pMatch.playCard(lCardToPlay, this, lTargetPlayer, lSourcePropertyGroup, lTargetPropertyGroup);
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

    // If rent is still due which should always be the case
    if (pValue > 0) {
      // Just look sequentially for now and sell properties until rent is paid
      for (List<Card> lPropertyList : mPropertyArea.values()) {
        for (Card lCard : lPropertyList) {
          lPaymentCards.add(lCard);
          lPropertyList.remove(lCard);

          // Decrement rent required by how much the card was worth
          pValue =- lCard.getMonetaryValue();
          if (pValue < 0) {
            return lPaymentCards;
          }
        }
      }
    }

    // If you run past this loop, there is no more money to give so just return the cards sold for payment
    // and ignore the rest as the rules of the game state
    return lPaymentCards;
  }

  public void givePayment(List<Card> pCardList) {
    // File away cards where they go
    for (Card lCard : pCardList) {
      // property cards go into property area
      if (lCard instanceof PropertyCard) {
        PropertyCard lPropertyCard = (PropertyCard) lCard;
        // TODO AT - choose the place to put it better
        PropertyGroup lPropertyGroup = lPropertyCard.getPropertyGroupList().get(0);
        if (mPropertyArea.get(lPropertyGroup) == null) {
          mPropertyArea.put(lPropertyGroup, Arrays.asList(lCard));
        } else {
          mPropertyArea.get(lPropertyGroup).add(lPropertyCard);
        }
      } else { // Else it is a money or action card that goes into the bank
        mBankArea.addCard(lCard);
      }
    }
  }

}
