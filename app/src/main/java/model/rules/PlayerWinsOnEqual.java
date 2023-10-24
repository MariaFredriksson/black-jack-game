package model.rules;

import model.Player;

/**
 * Strategy for determining if the dealer wins on equal score.
 */
public class PlayerWinsOnEqual implements WinningOnEqualStrategy {
  
  @Override
  public boolean isDealerWinnerOnEqual(Player dealer, Player player) {
    return dealer.calcScore() > player.calcScore();
  }
}
