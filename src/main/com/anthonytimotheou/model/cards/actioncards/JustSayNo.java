package com.anthonytimotheou.model.cards.actioncards;

import com.anthonytimotheou.model.PropertyGroup;
import com.anthonytimotheou.model.com.anthonytimotheou.environment.Match;
import com.anthonytimotheou.model.com.anthonytimotheou.environment.Player;

/**
 * Created by atimotheou on 08/07/2015.
 */
public class JustSayNo extends ActionCard {

  public JustSayNo() {
    mName = "JustSayNo";
  }

  @Override
  public int getMonetaryValue() {
    return 4;
  }

  @Override
  public boolean isPlayable(Match pMatch, Player lSourcePlayer, Player pTargetPlayer, PropertyGroup pTargetPropertyGroup, PropertyGroup pSourcePropertyGroup) {
    return true;
  }

  @Override
  public boolean executeBehaviour(Match pMatch, Player lSourcePlayer, Player pTargetPlayer, PropertyGroup pPropertyGroup, PropertyGroup pSourcePropertyGroup) {
    // not sure these methods apply to this card
    return false;
  }
}
