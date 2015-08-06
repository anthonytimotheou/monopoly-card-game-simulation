package com.anthonytimotheou.model.cards.actioncards;

import com.anthonytimotheou.model.PropertyGroup;
import com.anthonytimotheou.model.cards.Card;
import com.anthonytimotheou.model.com.anthonytimotheou.environment.Match;
import com.anthonytimotheou.model.com.anthonytimotheou.environment.Player;

import java.util.ArrayList;
import java.util.Arrays;

public class ForcedDeal extends ActionCard {

  public ForcedDeal() {
    mName = "ForcedDeal";
  }

  @Override
  public int getMonetaryValue() {
    return 0;
  }

  @Override
  public boolean isPlayable(Match pMatch, Player pSourcePlayer, Player pTargetPlayer, PropertyGroup pTargetPropertyGroup, PropertyGroup pSourcePropertyGroup) {
    // null check
    if (pSourcePlayer.getPropertyArea().get(pTargetPropertyGroup) == null || pTargetPlayer.getPropertyArea().get(pSourcePropertyGroup) == null) {
      return false;
    }

    // Check target property group has at least one property group
    if (pSourcePlayer.getPropertyArea().get(pTargetPropertyGroup).size() > 0 && pSourcePlayer.getPropertyArea().get(pSourcePropertyGroup).size() > 0) {
      return true;
    }

    return false;
  }

  @Override
  /**
   *@See SlyDeal for weaknesses
   */
  public boolean executeBehaviour(Match pMatch, Player pSourcePlayer, Player pTargetPlayer, PropertyGroup pPropertyGroup, PropertyGroup pSourcePropertyGroup) {
    // Grab card from target player and give to source player
    Card lTargetCardToSwap = pTargetPlayer.getPropertyArea().get(pPropertyGroup).get(0);
    pTargetPlayer.getPropertyArea().get(pPropertyGroup).remove(0);

    if (pSourcePlayer.getPropertyArea().get(pPropertyGroup) == null) {
      pSourcePlayer.getPropertyArea().put(pPropertyGroup, new ArrayList<>(Arrays.asList(lTargetCardToSwap)));
    } else {
      pSourcePlayer.getPropertyArea().get(pPropertyGroup).add(lTargetCardToSwap);
    }

    // Grab card from source player and give to target player
    Card lSourceCardToSwap = pSourcePlayer.getPropertyArea().get(pSourcePropertyGroup).get(0);
    pSourcePlayer.getPropertyArea().get(pSourcePropertyGroup).remove(0);

    if (pTargetPlayer.getPropertyArea().get(pSourcePropertyGroup) == null) {
      pTargetPlayer.getPropertyArea().put(pSourcePropertyGroup, new ArrayList<>(Arrays.asList(lSourceCardToSwap)));
    } else {
      pTargetPlayer.getPropertyArea().get(pSourcePropertyGroup).add(lSourceCardToSwap);
    }

    return true;
  }
}
