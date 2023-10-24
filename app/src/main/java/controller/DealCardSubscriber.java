package controller;

import model.Player;

public interface DealCardSubscriber {
  void update(Player playerWithAddedCard);
}
