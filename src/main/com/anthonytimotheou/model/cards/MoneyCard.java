package com.anthonytimotheou.model.cards;

import com.anthonytimotheou.model.Location;
import com.anthonytimotheou.model.PropertyGroup;
import com.anthonytimotheou.model.com.anthonytimotheou.environment.Match;
import com.anthonytimotheou.model.com.anthonytimotheou.environment.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoneyCard extends Card {
  int mValueInMillions;

  public MoneyCard(int pValueInMillions) {
    mValueInMillions = pValueInMillions;
    mName = pValueInMillions + " Money Card";
  }

  @Override
  public int getMonetaryValue() {
    return mValueInMillions;
  }

  @Override
  public List<Location> allowedLocations() {
    return new ArrayList<>(Arrays.asList(Location.BANK));
  }

  @Override
  public boolean isPlayable(Match pMatch, Player lSourcePlayer, Player pTargetPlayer, PropertyGroup pTargetPropertyGroup, PropertyGroup pSourcePropertyGroup) {
    return true;
  }

  @Override
  public boolean executeBehaviour(Match pMatch, Player pSourcePlayer, Player pTargetPlayer, PropertyGroup pPropertyGroup, PropertyGroup pSourcePropertyGroup) {
    pSourcePlayer.getBank().addCard(this);
    return true;
  }
}
