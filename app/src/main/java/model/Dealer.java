package model;

import java.util.ArrayList;
import model.rules.HitStrategy;
import model.rules.NewGameStrategy;
import model.rules.RulesFactory;
import model.rules.WinningOnEqualStrategy;

/**
 * Represents a dealer player that handles the deck of cards and runs the game using rules.
 */
public class Dealer extends Player {

  private Deck deck;
  private NewGameStrategy newGameRule;
  private HitStrategy hitRule;
  private WinningOnEqualStrategy winningOnEqualRule;
  private ArrayList<DealCardSubscriber> subscribers = new ArrayList<DealCardSubscriber>();

  /**
   * Initializing constructor.

   * @param rulesFactory A factory that creates the rules to use.
   */
  public Dealer(RulesFactory rulesFactory) {

    newGameRule = rulesFactory.getNewGameRule();
    hitRule = rulesFactory.getHitRule();
    winningOnEqualRule = rulesFactory.getWinningOnEqualRule();
  }

  public void addSubscriber(DealCardSubscriber subscriber) {
    subscribers.add(subscriber);
  }

  public void removeSubscriber(DealCardSubscriber subscriber) {
    subscribers.remove(subscriber);
  }

  /**
   * Starts a new game if the game is not currently under way.

   * @param player The player to play against.
   * @return True if the game could be started.
   */
  public boolean newGame(Player player) {
    if (deck == null || isGameOver()) {
      deck = new Deck();
      clearHand();
      player.clearHand();
      return newGameRule.newGame(deck, this, player);
    }
    return false;
  }

  public void dealCardToPlayer(Card.Mutable c, Player playerToDealCardTo) {
    playerToDealCardTo.dealCard(c);
    updateShowCards(playerToDealCardTo);
  }

  private void updateShowCards(Player playerWithAddedCard) {
    for (DealCardSubscriber sub : subscribers) {
      sub.update(playerWithAddedCard);
    }
  }

  /**
   * Gives the player one more card if possible. I.e. the player hits.

   * @param player The player to give a card to.
   * @return true if the player could get a new card, false otherwise.
   */
  public boolean hit(Player player) {
    if (deck != null && player.calcScore() < maxScore && !isGameOver()) {
      deck.getShowDealCard(true, this, player);
      return true;
    }
    return false;
  }

  /**
   * Checks if the dealer is the winner compared to a player.

   * @param player The player to check against.
   * @return True if the dealer is the winner, false if the player is the winner.
   */
  public boolean isDealerWinner(Player player) {
    if (player.calcScore() > maxScore) {
      return true;
    } else if (calcScore() > maxScore) {
      return false;
    }
    return winningOnEqualRule.isDealerWinnerOnEqual(this, player);
  }

  /**
   * Checks if the game is over, i.e. the dealer can take no more cards.

   * @return True if the game is over.
   */
  public boolean isGameOver() {
    if (deck != null && hitRule.doHit(this) != true) {
      return true;
    }
    return false;
  }

  /**
   * The player has chosen to take no more cards, it is the dealers turn.
   */
  public boolean stand() {
    showHand();
    if (deck != null) {
      while (hitRule.doHit(this)) {
        deck.getShowDealCard(true, this, this);
      }
      return true;
    }
    return false;
  }

}