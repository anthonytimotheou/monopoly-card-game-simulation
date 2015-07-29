package com.anthonytimotheou.model.cards;

import com.anthonytimotheou.model.Location;
import com.anthonytimotheou.model.PropertyGroup;
import com.anthonytimotheou.model.com.anthonytimotheou.environment.Match;
import com.anthonytimotheou.model.com.anthonytimotheou.environment.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PropertyCard extends Card {
  List<PropertyGroup> mPropertyGroupList = new ArrayList<>();
  int mValue;

  public PropertyCard(int pValue, PropertyGroup ... pPropertyGroups) {
    mPropertyGroupList = Arrays.asList(pPropertyGroups);
    mValue = pValue;
  }

  public List<PropertyGroup> getPropertyGroupList() {
    return mPropertyGroupList;
  }

  @Override
  public int getMonetaryValue() {
    return mValue;
  }

  @Override
  public List<Location> allowedLocations() {
    return Arrays.asList(Location.PROPERTY);
  }

  @Override
  public boolean isPlayable(Match pMatch, Player lSourcePlayer, Player pTargetPlayer, PropertyGroup pTargetPropertyGroup, PropertyGroup pSourcePropertyGroup) {
    return true;
  }

  @Override
  public boolean executeBehaviour(Match pMatch, Player pSourcePlayer, Player pTargetPlayer, PropertyGroup pPropertyGroup, PropertyGroup pSourcePropertyGroup) {
    // If more than one look at property group specified in source
    PropertyGroup lChosenPropertyGroup = null;

    // TODO AT - simply hack in or statement for now so that if no chosen property group is selected, it places the card in the first property group
    if (mPropertyGroupList.size() == 1 || pSourcePropertyGroup == null) {
      lChosenPropertyGroup = mPropertyGroupList.get(0);
    } else { // If more than 1 group then use choice of player
      lChosenPropertyGroup = pSourcePropertyGroup;
    }

    if (pSourcePlayer.getPropertyArea().get(lChosenPropertyGroup) == null) {
      List<Card> lNewCardList = new ArrayList<>();
      lNewCardList.add(this);
      pSourcePlayer.getPropertyArea().put(lChosenPropertyGroup, lNewCardList);
    } else {
      pSourcePlayer.getPropertyArea().get(lChosenPropertyGroup).add(this);
    }

    return true;
  }
}
