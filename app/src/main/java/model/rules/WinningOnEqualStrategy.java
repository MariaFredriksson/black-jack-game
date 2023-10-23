package model.rules;

import model.Player;

public interface WinningOnEqualStrategy {
  boolean isDealerWinnerOnEqual(Player dealer, Player player);
}
