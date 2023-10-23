package model.rules;

import model.Player;

public class PlayerWinsOnEqual implements WinningOnEqualStrategy {
  
    @Override
    public boolean isDealerWinnerOnEqual(Player dealer, Player player) {
      return dealer.calcScore() > player.calcScore();
    }
}
