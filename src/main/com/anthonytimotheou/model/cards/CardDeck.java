package com.anthonytimotheou.model.cards;

import com.anthonytimotheou.model.PropertyGroup;
import com.anthonytimotheou.model.cards.actioncards.DealBreaker;
import com.anthonytimotheou.model.cards.actioncards.DebtCollector;
import com.anthonytimotheou.model.cards.actioncards.DoubleTheRent;
import com.anthonytimotheou.model.cards.actioncards.ForcedDeal;
import com.anthonytimotheou.model.cards.actioncards.Hotel;
import com.anthonytimotheou.model.cards.actioncards.House;
import com.anthonytimotheou.model.cards.actioncards.ItsMyBirthday;
import com.anthonytimotheou.model.cards.actioncards.JustSayNo;
import com.anthonytimotheou.model.cards.actioncards.PassGo;
import com.anthonytimotheou.model.cards.actioncards.SlyDeal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeck {
  List<Card> mCardDeck = new ArrayList<>();

  public List<Card> getCardDeck() {
    return mCardDeck;
  }

  /**
   * Creates a DECK of cards based on monopoly card game rules.
   */
  public void createNewDeck() {
    List<Card> lCardDeck = new ArrayList<>();

    // Insert money cards
    for (int i = 0; i < 6; i++) {
      lCardDeck.add(new MoneyCard(1));
    }

    for (int i = 0; i < 5; i++) {
      lCardDeck.add(new MoneyCard(2));
    }

    lCardDeck.add(new MoneyCard(3));
    lCardDeck.add(new MoneyCard(3));
    lCardDeck.add(new MoneyCard(3));

    lCardDeck.add(new MoneyCard(4));
    lCardDeck.add(new MoneyCard(4));
    lCardDeck.add(new MoneyCard(4));

    lCardDeck.add(new MoneyCard(5));
    lCardDeck.add(new MoneyCard(5));

    lCardDeck.add(new MoneyCard(10));

    // ACTION Cards
    // Insert rent cards
    lCardDeck.add(new RentCard(PropertyGroup.LIGHT_BLUE, PropertyGroup.BROWN));
    lCardDeck.add(new RentCard(PropertyGroup.LIGHT_BLUE, PropertyGroup.BROWN));

    lCardDeck.add(new RentCard(PropertyGroup.PINK, PropertyGroup.ORANGE));
    lCardDeck.add(new RentCard(PropertyGroup.PINK, PropertyGroup.ORANGE));

    lCardDeck.add(new RentCard(PropertyGroup.RED, PropertyGroup.YELLOW));
    lCardDeck.add(new RentCard(PropertyGroup.RED, PropertyGroup.YELLOW));

    lCardDeck.add(new RentCard(PropertyGroup.DARK_BLUE, PropertyGroup.GREEN));
    lCardDeck.add(new RentCard(PropertyGroup.DARK_BLUE, PropertyGroup.GREEN));

    lCardDeck.add(new RentCard(PropertyGroup.RAILROAD, PropertyGroup.UTILITY));
    lCardDeck.add(new RentCard(PropertyGroup.RAILROAD, PropertyGroup.UTILITY));

    // Insert two rent wildcards
    for (int i = 0; i < 2; i++) {
      lCardDeck.add(new RentCard(
          PropertyGroup.BROWN
          , PropertyGroup.LIGHT_BLUE
          , PropertyGroup.PINK
          , PropertyGroup.ORANGE
          , PropertyGroup.RED
          , PropertyGroup.YELLOW
          , PropertyGroup.GREEN
          , PropertyGroup.DARK_BLUE
          , PropertyGroup.RAILROAD
          , PropertyGroup.UTILITY)
      );
    }

    lCardDeck.add(new DealBreaker());
    lCardDeck.add(new DealBreaker());

    lCardDeck.add(new ForcedDeal());
    lCardDeck.add(new ForcedDeal());
    lCardDeck.add(new ForcedDeal());

    lCardDeck.add(new SlyDeal());
    lCardDeck.add(new SlyDeal());
    lCardDeck.add(new SlyDeal());

    lCardDeck.add(new JustSayNo());
    lCardDeck.add(new JustSayNo());
    lCardDeck.add(new JustSayNo());

    lCardDeck.add(new DebtCollector());
    lCardDeck.add(new DebtCollector());
    lCardDeck.add(new DebtCollector());

    lCardDeck.add(new ItsMyBirthday());
    lCardDeck.add(new ItsMyBirthday());
    lCardDeck.add(new ItsMyBirthday());

    lCardDeck.add(new DoubleTheRent());
    lCardDeck.add(new DoubleTheRent());

    lCardDeck.add(new House());
    lCardDeck.add(new House());

    lCardDeck.add(new Hotel());
    lCardDeck.add(new Hotel());

    for (int i = 0; i < 10; i++) {
      lCardDeck.add(new PassGo());
    }

    // PROPERTY Cards
    // Base properties
    // TODO AT - need to cross reference these values against instruction manual onliine
    // TODO AT - These values may be incorporated into the property gorups maybe?
    lCardDeck.add(new PropertyCard(1, PropertyGroup.BROWN));
    lCardDeck.add(new PropertyCard(1, PropertyGroup.BROWN));

    lCardDeck.add(new PropertyCard(1, PropertyGroup.LIGHT_BLUE));
    lCardDeck.add(new PropertyCard(1, PropertyGroup.LIGHT_BLUE));
    lCardDeck.add(new PropertyCard(1, PropertyGroup.LIGHT_BLUE));

    lCardDeck.add(new PropertyCard(2, PropertyGroup.PINK));
    lCardDeck.add(new PropertyCard(2, PropertyGroup.PINK));
    lCardDeck.add(new PropertyCard(2, PropertyGroup.PINK));

    lCardDeck.add(new PropertyCard(3, PropertyGroup.ORANGE));
    lCardDeck.add(new PropertyCard(3, PropertyGroup.ORANGE));
    lCardDeck.add(new PropertyCard(3, PropertyGroup.ORANGE));

    lCardDeck.add(new PropertyCard(3, PropertyGroup.YELLOW));
    lCardDeck.add(new PropertyCard(3, PropertyGroup.YELLOW));
    lCardDeck.add(new PropertyCard(3, PropertyGroup.YELLOW));

    lCardDeck.add(new PropertyCard(4, PropertyGroup.RED));
    lCardDeck.add(new PropertyCard(4, PropertyGroup.RED));
    lCardDeck.add(new PropertyCard(4, PropertyGroup.RED));

    lCardDeck.add(new PropertyCard(4, PropertyGroup.GREEN));
    lCardDeck.add(new PropertyCard(4, PropertyGroup.GREEN));
    lCardDeck.add(new PropertyCard(4, PropertyGroup.GREEN));

    lCardDeck.add(new PropertyCard(5, PropertyGroup.DARK_BLUE));
    lCardDeck.add(new PropertyCard(5, PropertyGroup.DARK_BLUE));

    lCardDeck.add(new PropertyCard(1, PropertyGroup.RAILROAD));
    lCardDeck.add(new PropertyCard(1, PropertyGroup.RAILROAD));
    lCardDeck.add(new PropertyCard(1, PropertyGroup.RAILROAD));
    lCardDeck.add(new PropertyCard(1, PropertyGroup.RAILROAD));

    lCardDeck.add(new PropertyCard(1, PropertyGroup.UTILITY));
    lCardDeck.add(new PropertyCard(1, PropertyGroup.UTILITY));

    // wildcard properties
    lCardDeck.add(new PropertyCard(3, PropertyGroup.LIGHT_BLUE, PropertyGroup.BROWN));
    lCardDeck.add(new PropertyCard(3, PropertyGroup.LIGHT_BLUE, PropertyGroup.RAILROAD));

    lCardDeck.add(new PropertyCard(3, PropertyGroup.PINK, PropertyGroup.ORANGE));
    lCardDeck.add(new PropertyCard(3, PropertyGroup.PINK, PropertyGroup.ORANGE));

    lCardDeck.add(new PropertyCard(4, PropertyGroup.RED, PropertyGroup.YELLOW));
    lCardDeck.add(new PropertyCard(4, PropertyGroup.RED, PropertyGroup.YELLOW));

    lCardDeck.add(new PropertyCard(5, PropertyGroup.DARK_BLUE, PropertyGroup.GREEN));

    lCardDeck.add(new PropertyCard(4, PropertyGroup.GREEN, PropertyGroup.RAILROAD));

    lCardDeck.add(new PropertyCard(2, PropertyGroup.RAILROAD, PropertyGroup.UTILITY));

    // Two wild card properties
    for (int i = 0; i < 2; i++) {
      lCardDeck.add(new PropertyCard(
            5
          , PropertyGroup.BROWN
          , PropertyGroup.LIGHT_BLUE
          , PropertyGroup.PINK
          , PropertyGroup.ORANGE
          , PropertyGroup.RED
          , PropertyGroup.YELLOW
          , PropertyGroup.GREEN
          , PropertyGroup.DARK_BLUE
          , PropertyGroup.RAILROAD
          , PropertyGroup.UTILITY
        )
      );
    }

    mCardDeck = lCardDeck;
  }

  public void shuffleDeck() {
    Collections.shuffle(mCardDeck);
  }

  public void printDeckToStandardOut() {
    System.out.println("The size: " + mCardDeck.size());
    mCardDeck.forEach(System.out::println);
  }

  public Card takeCard() {
    if (!(mCardDeck.size() > 0)) {
      throw new RuntimeException("There are no cards to take");
    }
    Card lCard = mCardDeck.get(0); // always get the latest card
    if (lCard == null) {
      throw new RuntimeException("The card returned was null");
    }
    mCardDeck.remove(0);
    return lCard;
  }

}
