package model.rules;

import model.Player;

/**
 * Strategy for determining if the dealer wins on equal score.
 */
public interface WinningOnEqualStrategy {
  boolean isDealerWinnerOnEqual(Player dealer, Player player);
}
