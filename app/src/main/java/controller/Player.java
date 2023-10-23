package controller;

import model.Game;
import view.View;
import view.View.ActionOptions;

/**
 * Scenario controller for playing the game.
 */
public class Player implements DealCardSubscriber {
  private Game game;
  private View view;

  /**
   * Creates a new instance of the player.
   * @param game The game state.
   * @param view The view to use.
   */
  public Player(Game game, View view) {
    this.game = game;
    this.view = view;
    game.addSubscriber(this);
  }

  // ! Hit does not display the cards, but it happens, maybe...

  /**
   * Runs the play use case.

   * @return True as long as the game should continue.
   */
  public boolean play() {
    view.displayWelcomeMessage();

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

  @Override
  public void update() {
    view.displayDealerHand(game.getDealerHand(), game.getDealerScore());
    view.displayPlayerHand(game.getPlayerHand(), game.getPlayerScore());
  }
}