package com.anthonytimotheou.model.cards.actioncards;

import com.anthonytimotheou.model.Location;
import com.anthonytimotheou.model.cards.Card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by atimotheou on 08/07/2015.
 */
public abstract class ActionCard extends Card {

  @Override
  public List<Location> allowedLocations() {
    return new ArrayList<>(Arrays.asList(Location.CARD_PILE, Location.BANK));
  }
}
