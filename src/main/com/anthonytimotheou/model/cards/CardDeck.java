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
    lCardDeck.add(new PropertyCard(PropertyGroup.BROWN));
    lCardDeck.add(new PropertyCard(PropertyGroup.BROWN));

    lCardDeck.add(new PropertyCard(PropertyGroup.LIGHT_BLUE));
    lCardDeck.add(new PropertyCard(PropertyGroup.LIGHT_BLUE));
    lCardDeck.add(new PropertyCard(PropertyGroup.LIGHT_BLUE));

    lCardDeck.add(new PropertyCard(PropertyGroup.PINK));
    lCardDeck.add(new PropertyCard(PropertyGroup.PINK));
    lCardDeck.add(new PropertyCard(PropertyGroup.PINK));

    lCardDeck.add(new PropertyCard(PropertyGroup.ORANGE));
    lCardDeck.add(new PropertyCard(PropertyGroup.ORANGE));
    lCardDeck.add(new PropertyCard(PropertyGroup.ORANGE));

    lCardDeck.add(new PropertyCard(PropertyGroup.RED));
    lCardDeck.add(new PropertyCard(PropertyGroup.RED));
    lCardDeck.add(new PropertyCard(PropertyGroup.RED));

    lCardDeck.add(new PropertyCard(PropertyGroup.YELLOW));
    lCardDeck.add(new PropertyCard(PropertyGroup.YELLOW));
    lCardDeck.add(new PropertyCard(PropertyGroup.YELLOW));

    lCardDeck.add(new PropertyCard(PropertyGroup.GREEN));
    lCardDeck.add(new PropertyCard(PropertyGroup.GREEN));
    lCardDeck.add(new PropertyCard(PropertyGroup.GREEN));

    lCardDeck.add(new PropertyCard(PropertyGroup.DARK_BLUE));
    lCardDeck.add(new PropertyCard(PropertyGroup.DARK_BLUE));

    lCardDeck.add(new PropertyCard(PropertyGroup.RAILROAD));
    lCardDeck.add(new PropertyCard(PropertyGroup.RAILROAD));
    lCardDeck.add(new PropertyCard(PropertyGroup.RAILROAD));
    lCardDeck.add(new PropertyCard(PropertyGroup.RAILROAD));

    lCardDeck.add(new PropertyCard(PropertyGroup.UTILITY));
    lCardDeck.add(new PropertyCard(PropertyGroup.UTILITY));

    // wildcard properties
    lCardDeck.add(new PropertyCard(PropertyGroup.LIGHT_BLUE, PropertyGroup.BROWN));
    lCardDeck.add(new PropertyCard(PropertyGroup.LIGHT_BLUE, PropertyGroup.RAILROAD));

    lCardDeck.add(new PropertyCard(PropertyGroup.PINK, PropertyGroup.ORANGE));
    lCardDeck.add(new PropertyCard(PropertyGroup.PINK, PropertyGroup.ORANGE));

    lCardDeck.add(new PropertyCard(PropertyGroup.RED, PropertyGroup.YELLOW));
    lCardDeck.add(new PropertyCard(PropertyGroup.RED, PropertyGroup.YELLOW));

    lCardDeck.add(new PropertyCard(PropertyGroup.DARK_BLUE, PropertyGroup.GREEN));

    lCardDeck.add(new PropertyCard(PropertyGroup.GREEN, PropertyGroup.RAILROAD));

    lCardDeck.add(new PropertyCard(PropertyGroup.RAILROAD, PropertyGroup.UTILITY));

    // Two wild card properties
    for (int i = 0; i < 2; i++) {
      lCardDeck.add(new PropertyCard(
            PropertyGroup.BROWN
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
    mCardDeck.forEach(System.out::println);
  }

}
