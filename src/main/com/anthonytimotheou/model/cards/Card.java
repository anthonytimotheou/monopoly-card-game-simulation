package com.anthonytimotheou.model.cards;

import com.anthonytimotheou.model.Location;
import com.anthonytimotheou.model.PropertyGroup;
import com.anthonytimotheou.model.com.anthonytimotheou.environment.Match;
import com.anthonytimotheou.model.com.anthonytimotheou.environment.Player;

import java.util.Comparator;
import java.util.List;

public abstract class Card implements Comparable<Card>{

  public abstract int getMonetaryValue();

  public abstract List<Location> allowedLocations();

  public abstract boolean isPlayable(Match pMatch, Player lSourcePlayer, Player pTargetPlayer, PropertyGroup pTargetPropertyGroup, PropertyGroup pSourcePropertyGroup);

  // TODO AT - Should not rely on boolean, should throw error if there is a problem
  public abstract boolean executeBehaviour(Match pMatch, Player lSourcePlayer, Player pTargetPlayer, PropertyGroup pPropertyGroup, PropertyGroup pSourcePropertyGroup);

  public int compareTo(Card pCard) {
    if (pCard.getMonetaryValue() == this.getMonetaryValue()) {
        return 0;
    } else if (this.getMonetaryValue() > pCard.getMonetaryValue()) {
      return 1;
    } else {
      return 0;
    }
  }
}
