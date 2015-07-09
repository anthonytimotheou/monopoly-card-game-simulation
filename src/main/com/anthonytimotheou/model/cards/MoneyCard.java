package com.anthonytimotheou.model.cards;

import com.anthonytimotheou.model.cards.Card;

public class MoneyCard extends Card {
  int mValueInMillions;

  public MoneyCard(int pValueInMillions) {
    mValueInMillions = pValueInMillions;
  }
}
