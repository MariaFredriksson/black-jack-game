package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import model.rules.RulesFactory;



public class TestSoft17 {

 // Make a test to check for soft 17
  @Test
  public void testSoft17() {
    Dealer dealer = new Dealer(new RulesFactory());
    
    dealer.newGame(dealer);
    dealer.clearHand();

    Card.Mutable ace = new Card.Mutable(Card.Color.Diamonds, Card.Value.Ace);
    Card.Mutable four = new Card.Mutable(Card.Color.Diamonds, Card.Value.Four);
    Card.Mutable two = new Card.Mutable(Card.Color.Diamonds, Card.Value.Two);

    dealer.dealCard(ace);
    dealer.dealCard(four);
    dealer.dealCard(two);

    dealer.showHand();

    assertEquals(17, dealer.calcScore());
    assertEquals(true, dealer.hit(dealer));

  }

  @Test
  public void test16() {
    Dealer dealer = new Dealer(new RulesFactory());
    
    dealer.newGame(dealer);
    dealer.clearHand();

    Card.Mutable ace = new Card.Mutable(Card.Color.Diamonds, Card.Value.Ace);
    Card.Mutable three = new Card.Mutable(Card.Color.Diamonds, Card.Value.Three);
    Card.Mutable two = new Card.Mutable(Card.Color.Diamonds, Card.Value.Two);

    dealer.dealCard(ace);
    dealer.dealCard(three);
    dealer.dealCard(two);

    dealer.showHand();

    assertEquals(16, dealer.calcScore());
    assertEquals(true, dealer.hit(dealer));

  }

  @Test
  public void testNotSoft17() {
    Dealer dealer = new Dealer(new RulesFactory());
    
    dealer.newGame(dealer);
    dealer.clearHand();

    Card.Mutable king = new Card.Mutable(Card.Color.Diamonds, Card.Value.King);
    Card.Mutable four = new Card.Mutable(Card.Color.Diamonds, Card.Value.Four);
    Card.Mutable three = new Card.Mutable(Card.Color.Diamonds, Card.Value.Three);

    dealer.dealCard(king);
    dealer.dealCard(four);
    dealer.dealCard(three);

    dealer.showHand();

    assertEquals(17, dealer.calcScore());
    assertEquals(false, dealer.hit(dealer));

  }

  @Test
  public void test18() {
    Dealer dealer = new Dealer(new RulesFactory());
    
    dealer.newGame(dealer);
    dealer.clearHand();

    Card.Mutable king = new Card.Mutable(Card.Color.Diamonds, Card.Value.King);
    Card.Mutable five = new Card.Mutable(Card.Color.Diamonds, Card.Value.Five);
    Card.Mutable three = new Card.Mutable(Card.Color.Diamonds, Card.Value.Three);

    dealer.dealCard(king);
    dealer.dealCard(five);
    dealer.dealCard(three);

    dealer.showHand();

    assertEquals(18, dealer.calcScore());
    assertEquals(false, dealer.hit(dealer));

  }

}
