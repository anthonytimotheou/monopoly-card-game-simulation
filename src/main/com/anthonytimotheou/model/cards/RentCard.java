package com.anthonytimotheou.model.cards;


import com.anthonytimotheou.model.PropertyGroup;
import com.anthonytimotheou.model.cards.Card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RentCard extends Card {
  List<PropertyGroup> lPropertyGroupList = new ArrayList<>();

  public RentCard(PropertyGroup ... pPropertyGroups) {
    lPropertyGroupList = Arrays.asList(pPropertyGroups);
  }
}
