package com.anthonytimotheou.model;

import java.util.ArrayList;
import java.util.List;

public enum PropertyGroup {
  // TODO AT - must be a more succint way of initialising these, it's just a list of values
    BROWN(2, new ArrayList<Integer>(){{add(1);add(2);}})
  , LIGHT_BLUE(3, new ArrayList<Integer>(){{add(1);add(3);add(4);}})
  , PINK(3, new ArrayList<Integer>(){{add(1);add(3);add(5);}})
  , ORANGE(3, new ArrayList<Integer>(){{add(1);add(3);add(5);}})
  , RED(3, new ArrayList<Integer>(){{add(2);add(4);add(6);}})
  , YELLOW(3, new ArrayList<Integer>(){{add(2);add(4);add(6);}})
  , GREEN(3, new ArrayList<Integer>(){{add(2);add(4);add(6);}})
  , DARK_BLUE(2, new ArrayList<Integer>(){{add(3);add(8);}})
  , RAILROAD(4, new ArrayList<Integer>(){{add(1);add(2);add(3);add(4);}})
  , UTILITY(2, new ArrayList<Integer>(){{add(1);add(2);}});

  int mCompletedSetNumber;
  List<Integer> mRentValues;

  PropertyGroup(int pCompletedSetNumber, List<Integer> pRentValues) {
    mCompletedSetNumber = pCompletedSetNumber;
    mRentValues = pRentValues;
  }

  public int getCompletedSetNumber() {
    return mCompletedSetNumber;
  }

  public List<Integer> getRentValues() {
    return mRentValues;
  }
}
