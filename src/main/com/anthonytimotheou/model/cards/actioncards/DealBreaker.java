package com.anthonytimotheou.model.cards.actioncards;

import com.anthonytimotheou.model.PropertyGroup;
import com.anthonytimotheou.model.cards.Card;
import com.anthonytimotheou.model.com.anthonytimotheou.environment.Match;
import com.anthonytimotheou.model.com.anthonytimotheou.environment.Player;

import java.util.List;

public class DealBreaker extends ActionCard {

  public DealBreaker() {
    mName = "DealBreaker";
  }

  @Override
  public int getMonetaryValue() {
    return 5;
  }

  @Override
  public boolean isPlayable(Match pMatch, Player lSourcePlayer, Player pTargetPlayer, PropertyGroup pTargetPropertyGroup, PropertyGroup pSourcePropertyGroup) {
    // null check
    if (lSourcePlayer.getPropertyArea().get(pTargetPropertyGroup) == null) {
      return false;
    }
    // Check target property group is a full set
    if (lSourcePlayer.getPropertyArea().get(pTargetPropertyGroup).size() == pTargetPropertyGroup.getCompletedSetNumber() || lSourcePlayer.getPropertyArea().get(pTargetPropertyGroup).size() > pTargetPropertyGroup.getCompletedSetNumber()) {
     return true;
    }
    return false;
  }

  @Override
  public boolean executeBehaviour(Match pMatch, Player pSourcePlayer, Player pTargetPlayer, PropertyGroup pPropertyGroup, PropertyGroup pSourcePropertyGroup) {
    // Logic of choosing the property group to steal is handled by the player
    // Grab property to steal
    List<Card> lFullSetOfCards = pTargetPlayer.getPropertyArea().get(pPropertyGroup);
    // Remove property set from source player
    pTargetPlayer.getPropertyArea().remove(pPropertyGroup);
    // Give property Set
    pSourcePlayer.getPropertyArea().put(pPropertyGroup, lFullSetOfCards);
    // TODO AT - Give the player a chance to use their just say no
    return true;
  }
}
