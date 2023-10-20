package model.rules;

import model.Card;
import model.Player;

class BasicHitStrategy implements HitStrategy {
  private static final int hitLimit = 17;

  public boolean doHit(Player dealer) {
    return dealer.calcScore() < hitLimit || soft17(dealer);
  }

   // Soft 17 rule, when dealer has 17 and an ace, dealer can choose to hit
   private boolean soft17(Player dealer) {
    if (dealer.calcScore() == 17) {
      for (Card c : dealer.getHand()) {
        if (c.getValue() == Card.Value.Ace) {
          return true;
        }
      }
    }
    return false;
  }
}