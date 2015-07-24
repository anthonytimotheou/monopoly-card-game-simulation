package com.anthonytimotheou.model.cards.actioncards;

import com.anthonytimotheou.model.PropertyGroup;
import com.anthonytimotheou.model.com.anthonytimotheou.environment.Match;
import com.anthonytimotheou.model.com.anthonytimotheou.environment.Player;

public class DoubleTheRent extends ActionCard {
  @Override
  public int getMonetaryValue() {
    return 3;
  }

  @Override
  public boolean isPlayable(Match pMatch, Player lSourcePlayer, Player pTargetPlayer, PropertyGroup pTargetPropertyGroup, PropertyGroup pSourcePropertyGroup) {
    return false;
  }

  @Override
  public boolean executeBehaviour(Match pMatch, Player lSourcePlayer, Player pTargetPlayer, PropertyGroup pTargetPropertyGroup, PropertyGroup pSourcePropertyGroup) {
    return false;
  }
}
