package model.rules;

import model.Dealer;
import model.Deck;
import model.Player;

class AmericanNewGameStrategy implements NewGameStrategy {

  public boolean newGame(Deck deck, Dealer dealer, Player player) {

    deck.getShowDealCard(true, dealer, player);
    deck.getShowDealCard(true, dealer, dealer);
    deck.getShowDealCard(true, dealer, player);
    deck.getShowDealCard(false, dealer, dealer);

    return true;
  }
}