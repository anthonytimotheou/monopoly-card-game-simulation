package com.anthonytimotheou.model.com.anthonytimotheou.environment;


import com.anthonytimotheou.model.cards.Card;

import java.util.ArrayList;
import java.util.List;

public class Player {
  private final String mName;
  private final Area mPropertyArea = new Area();
  private final Area mBankArea = new Area();
  private final List<Card> mCardsInHand = new ArrayList<>();

  public Player(String pName) {
    mName = pName;
  }
}
