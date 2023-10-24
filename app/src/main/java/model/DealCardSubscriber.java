package model;

/**
 * Interface for subscribers to the deal card event.
 */
public interface DealCardSubscriber {
  public void update(Player playerWithAddedCard);
}
