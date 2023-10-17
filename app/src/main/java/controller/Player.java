package controller;

import model.Game;
import view.View;
import view.View.ActionOptions;

/**
 * Scenario controller for playing the game.
 */
public class Player {

  /**
   * Runs the play use case.

   * @param game The game state.
   * @param view The view to use.
   * @return True as long as the game should continue.
   */
  public boolean play(Game game, View view) {
    view.displayWelcomeMessage();

    view.displayDealerHand(game.getDealerHand(), game.getDealerScore());
    view.displayPlayerHand(game.getPlayerHand(), game.getPlayerScore());

    if (game.isGameOver()) {
      view.displayGameOver(game.isDealerWinner());
    }

    ActionOptions action = view.getAction();

    if (action == ActionOptions.PLAY) {
      game.newGame();
    } else if (action == ActionOptions.HIT) {
      game.hit();
    } else if (action == ActionOptions.STAND) {
      game.stand();
    }

    return action != ActionOptions.QUIT;
  }
}