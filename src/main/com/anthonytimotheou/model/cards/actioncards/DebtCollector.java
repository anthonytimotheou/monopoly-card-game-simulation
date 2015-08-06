package com.anthonytimotheou.model.cards.actioncards;

import com.anthonytimotheou.model.PropertyGroup;
import com.anthonytimotheou.model.cards.Card;
import com.anthonytimotheou.model.com.anthonytimotheou.environment.Match;
import com.anthonytimotheou.model.com.anthonytimotheou.environment.Player;

import java.util.List;

public class DebtCollector extends ActionCard {

  public DebtCollector() {
    mName = "DebtCollector";
  }

  @Override
  public int getMonetaryValue() {
    return 4;
  }

  @Override
  public boolean isPlayable(Match pMatch, Player lSourcePlayer, Player pTargetPlayer, PropertyGroup pTargetPropertyGroup, PropertyGroup pSourcePropertyGroup) {
    // If player has absolutely no way of paying then it should fail trying to play a money collector card
    if (pTargetPlayer.getPropertyArea().size() != 0 && pTargetPlayer.getBank().getCardList().size() == 0) {
      return false;
    } else {
      return true;
    }
  }

  @Override
  public boolean executeBehaviour(Match pMatch, Player lSourcePlayer, Player pTargetPlayer, PropertyGroup pPropertyGroup, PropertyGroup pSourcePropertyGroup) {
    // Ask for payment from the player that returns a list of cards which they chose how to pay with
    List<Card> lCardsToPayWith = pTargetPlayer.getPayment(5);
    lSourcePlayer.givePayment(lCardsToPayWith);
    return true;
  }
}
