package com.anthonytimotheou.model.cards;


import com.anthonytimotheou.model.Location;
import com.anthonytimotheou.model.PropertyGroup;
import com.anthonytimotheou.model.cards.actioncards.Hotel;
import com.anthonytimotheou.model.cards.actioncards.House;
import com.anthonytimotheou.model.com.anthonytimotheou.environment.Match;
import com.anthonytimotheou.model.com.anthonytimotheou.environment.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RentCard extends Card {
  List<PropertyGroup> mPropertyGroupList = new ArrayList<>();

  public RentCard(PropertyGroup ... pPropertyGroups) {
    mPropertyGroupList = new ArrayList<>(Arrays.asList(pPropertyGroups));
    mName += Arrays.toString(mPropertyGroupList.toArray()) + " Rent Card";
  }

  @Override
  public int getMonetaryValue() {
    // TODO AT - standard cost of 5 at the moment, need to look up values depending on property group(s) specified
    return 5;
  }

  @Override
  public List<Location> allowedLocations() {
    return null;
  }

  @Override
  public boolean isPlayable(Match pMatch, Player lSourcePlayer, Player pTargetPlayer, PropertyGroup pTargetPropertyGroup, PropertyGroup pSourcePropertyGroup) {
    // TODO AT - Should check the source group is in the mPropertyGroupList
    if (!(lSourcePlayer.getPropertyArea().get(pSourcePropertyGroup) == null) && lSourcePlayer.getPropertyArea().get(pSourcePropertyGroup).size() > 0) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public boolean executeBehaviour(Match pMatch, Player pSourcePlayer, Player pTargetPlayer, PropertyGroup pPropertyGroup, PropertyGroup pSourcePropertyGroup) {

    // use the source property group to calculate the rent (grab it from the property group)
    int lRentValue = 0;
    List<Integer> lGroupRentValues = pSourcePropertyGroup.getRentValues();
    List<Card> lPropertyCards = pSourcePlayer.getPropertyArea().get(pSourcePropertyGroup);

    if (lPropertyCards.size() <= pSourcePropertyGroup.getCompletedSetNumber()) {
      lRentValue = lGroupRentValues.get(lPropertyCards.size()-1);
    } else { // check for house and hotel values
      lRentValue = lGroupRentValues.get(pSourcePropertyGroup.getCompletedSetNumber()-1);
      for (Card lCard : lPropertyCards) {
        if (lCard instanceof House || lCard instanceof Hotel) {
          lRentValue += 4;
        }
      }
    }

    // If it is a multivalue rent where you select a target player than ask that player for rent
    if (lPropertyCards.size() > 1) {
      List<Card> lPaymentCards = pTargetPlayer.getPayment(lRentValue);
      pSourcePlayer.givePayment(lPaymentCards);
    } else { // otherwise it's for all players and ask for rent
      for (Player lPlayer : pMatch.getPlayers()) {
        if (lPlayer != pSourcePlayer) {
          List<Card> lPaymentCards = lPlayer.getPayment(lRentValue);
          pSourcePlayer.givePayment(lPaymentCards);
        }
      }
    }

    return true;
  }
}
