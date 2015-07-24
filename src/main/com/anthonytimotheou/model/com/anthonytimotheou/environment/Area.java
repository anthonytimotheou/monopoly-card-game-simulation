package com.anthonytimotheou.model.com.anthonytimotheou.environment;

import com.anthonytimotheou.model.cards.Card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Hold the area of a player, will encapsulate the rules needed about what can be placed in the area
public class Area {
  List<Card> mAreaCardList;

  public List<Card> getCardList() {
    return mAreaCardList;
  }

  public void addCard(Card pCard) {
    mAreaCardList.add(pCard);
  }

}
