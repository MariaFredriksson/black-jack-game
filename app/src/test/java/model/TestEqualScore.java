package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.rules.RulesFactory;

public class TestEqualScore {
  @Test
  public void testPlayerWinsOnEqual() {
    Dealer dealer = new Dealer(new RulesFactory());
    Player player = new Player();
    
    dealer.newGame(dealer);
    dealer.clearHand();
    player.clearHand();

    Card.Mutable king = new Card.Mutable(Card.Color.Diamonds, Card.Value.King);
    Card.Mutable fourDiamonds = new Card.Mutable(Card.Color.Diamonds, Card.Value.Four);

    dealer.dealCard(king);
    dealer.dealCard(fourDiamonds);

    Card.Mutable queen = new Card.Mutable(Card.Color.Diamonds, Card.Value.Queen);
    Card.Mutable fourSpades = new Card.Mutable(Card.Color.Spades, Card.Value.Four);

    player.dealCard(queen);
    player.dealCard(fourSpades);

    dealer.showHand();
    player.showHand();

    assertEquals(14, dealer.calcScore());
    assertEquals(14, player.calcScore());
    assertEquals(false, dealer.isDealerWinner(player));

  }

  @Test
  public void testPlayerWins() {
    Dealer dealer = new Dealer(new RulesFactory());
    Player player = new Player();
    
    dealer.newGame(dealer);
    dealer.clearHand();
    player.clearHand();

    Card.Mutable king = new Card.Mutable(Card.Color.Diamonds, Card.Value.King);
    Card.Mutable fourDiamonds = new Card.Mutable(Card.Color.Diamonds, Card.Value.Four);

    dealer.dealCard(king);
    dealer.dealCard(fourDiamonds);

    Card.Mutable queen = new Card.Mutable(Card.Color.Diamonds, Card.Value.Queen);
    Card.Mutable five = new Card.Mutable(Card.Color.Spades, Card.Value.Five);

    player.dealCard(queen);
    player.dealCard(five);

    dealer.showHand();
    player.showHand();

    assertEquals(14, dealer.calcScore());
    assertEquals(15, player.calcScore());
    assertEquals(false, dealer.isDealerWinner(player));

  }

  @Test
  public void testDealerWins() {
    Dealer dealer = new Dealer(new RulesFactory());
    Player player = new Player();
    
    dealer.newGame(dealer);
    dealer.clearHand();
    player.clearHand();

    Card.Mutable king = new Card.Mutable(Card.Color.Diamonds, Card.Value.King);
    Card.Mutable five = new Card.Mutable(Card.Color.Diamonds, Card.Value.Five);

    dealer.dealCard(king);
    dealer.dealCard(five);

    Card.Mutable queen = new Card.Mutable(Card.Color.Diamonds, Card.Value.Queen);
    Card.Mutable fourSpades = new Card.Mutable(Card.Color.Spades, Card.Value.Four);

    player.dealCard(queen);
    player.dealCard(fourSpades);

    dealer.showHand();
    player.showHand();

    assertEquals(15, dealer.calcScore());
    assertEquals(14, player.calcScore());
    assertEquals(true, dealer.isDealerWinner(player));

  }
}
