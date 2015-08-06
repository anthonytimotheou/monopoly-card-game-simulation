package com.anthonytimotheou.model.cards.actioncards;

import com.anthonytimotheou.model.PropertyGroup;
import com.anthonytimotheou.model.cards.Card;
import com.anthonytimotheou.model.com.anthonytimotheou.environment.Match;
import com.anthonytimotheou.model.com.anthonytimotheou.environment.Player;

import java.util.List;

public class Hotel extends ActionCard {

  public Hotel() {
    mName = "Hotel";
  }

  @Override
  public int getMonetaryValue() {
    return 4;
  }

  @Override
  public boolean isPlayable(Match pMatch, Player lSourcePlayer, Player pTargetPlayer, PropertyGroup pTargetPropertyGroup, PropertyGroup pSourcePropertyGroup) {
    List<Card> lCardsInGroup = lSourcePlayer.getPropertyArea().get(pTargetPropertyGroup);
    // null check
    if (lCardsInGroup == null) {
      return false; // Cannot add to an empty set
    }
    // full set check and a house check by adding one to the completed set number
    if (lCardsInGroup.size() != pTargetPropertyGroup.getCompletedSetNumber() + 1) {
      return false;
    }
    return true;
  }

  @Override
  public boolean executeBehaviour(Match pMatch, Player lSourcePlayer, Player pTargetPlayer, PropertyGroup pTargetPropertyGroup, PropertyGroup pSourcePropertyGroup) {
    List<Card> lCardsInGroup = lSourcePlayer.getPropertyArea().get(pTargetPropertyGroup);
    // Add this card to the list which is still located in the propertyArea by reference.
    lCardsInGroup.add(this);
    return true;
  }
}
