package com.anthonytimotheou.model.cards.actioncards;

import com.anthonytimotheou.model.PropertyGroup;
import com.anthonytimotheou.model.cards.Card;
import com.anthonytimotheou.model.com.anthonytimotheou.environment.Match;
import com.anthonytimotheou.model.com.anthonytimotheou.environment.Player;

public class SlyDeal extends ActionCard {

  @Override
  public int getMonetaryValue() {
    return 4;
  }

  @Override
  public boolean isPlayable(Match pMatch, Player lSourcePlayer, Player pTargetPlayer, PropertyGroup pTargetPropertyGroup, PropertyGroup pSourcePropertyGroup) {
    // null check
    if (pTargetPlayer.getPropertyArea().get(pTargetPropertyGroup) == null) {
      return false;
    }
    // Check target property group has at least one property group
    if (pTargetPlayer.getPropertyArea().get(pTargetPropertyGroup).size() > 0 ) {
      return true;
    }
    return false;
  }

  @Override
  public boolean executeBehaviour(Match pMatch, Player pSourcePlayer, Player pTargetPlayer, PropertyGroup pPropertyGroup, PropertyGroup pSourcePropertyGroup) {
    // Logic of choosing the property  to steal is handled by the player
    // Grab property to steal
    // TODO AT - Player may need to specify the exact card so that they can grab wildcards first and rearrange them, et cetera
    // For now just steal the first card in the group
    Card lCardToSteal = pTargetPlayer.getPropertyArea().get(pPropertyGroup).get(0);
    // Remove property set from source player
    pTargetPlayer.getPropertyArea().get(pPropertyGroup).remove(0);
    // Give property Set
    pSourcePlayer.getPropertyArea().get(pPropertyGroup).add(lCardToSteal);
    // TODO AT - Give the player a chance to use their just say no
    return true;
  }
}
