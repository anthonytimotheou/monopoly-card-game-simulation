package com.anthonytimotheou.model.cards.actioncards;

import com.anthonytimotheou.model.PropertyGroup;
import com.anthonytimotheou.model.cards.Card;
import com.anthonytimotheou.model.com.anthonytimotheou.environment.Match;
import com.anthonytimotheou.model.com.anthonytimotheou.environment.Player;

public class PassGo extends ActionCard {

  public PassGo() {
    mName = "PassGo";
  }

  @Override
  public int getMonetaryValue() {
    return 0;
  }

  @Override
  public boolean isPlayable(Match pMatch, Player lSourcePlayer, Player pTargetPlayer, PropertyGroup pTargetPropertyGroup, PropertyGroup pSourcePropertyGroup) {
    // TODO AT - Maybe check the deck here to make sure there are two cards in it, need a shielding function
    // for all getting of the card deck and that reshuffles form card pile if not full
    return true;
  }

  @Override
  public boolean executeBehaviour(Match pMatch, Player lSourcePlayer, Player pTargetPlayer, PropertyGroup pPropertyGroup, PropertyGroup pSourcePropertyGroup) {
    // Take two cards from card deck
    Card lCardOne = pMatch.getCardDeck().takeCard();
    Card lCardTwo = pMatch.getCardDeck().takeCard();
    // Give player two cards
    lSourcePlayer.receiveCard(lCardOne);
    lSourcePlayer.receiveCard(lCardTwo);
    return true;
  }
}
