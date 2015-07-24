package com.anthonytimotheou.model.cards;

import com.anthonytimotheou.model.Location;
import com.anthonytimotheou.model.PropertyGroup;
import com.anthonytimotheou.model.cards.Card;
import com.anthonytimotheou.model.com.anthonytimotheou.environment.Match;
import com.anthonytimotheou.model.com.anthonytimotheou.environment.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PropertyCard extends Card {
  List<PropertyGroup> lPropertyGroupList = new ArrayList<>();

  public PropertyCard(PropertyGroup ... pPropertyGroups) {
    lPropertyGroupList = Arrays.asList(pPropertyGroups);
  }

  @Override
  public List<Location> allowedLocations() {
    return Arrays.asList(Location.PROPERTY);
  }

  @Override
  public boolean isPlayable(Match pMatch, Player lSourcePlayer, Player pTargetPlayer, PropertyGroup pTargetPropertyGroup, PropertyGroup pSourcePropertyGroup) {
    return false;
  }

  @Override
  public boolean executeBehaviour(Match pMatch, Player pSourcePlayer, Player pTargetPlayer, PropertyGroup pPropertyGroup, PropertyGroup pSourcePropertyGroup) {
    // If more than one look at property group specified in source
    PropertyGroup lChosenPropertyGroup = null;

    if (lPropertyGroupList.size() == 1) {
      lChosenPropertyGroup = lPropertyGroupList.get(0);
    } else { // if more than 1 group then use choice of player
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
