package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import model.Card.Mutable;
import model.rules.RulesFactory;

//import static org.junit.jupiter.api.Assertions.assertTrue;
//import org.junit.jupiter.api.Test;


public class SimpleTest {


  //^^Get this test to work!
 // Make a test to check for soft 17
  @Test
  public void testSoft17() {
    Dealer dealer = new Dealer(new RulesFactory());
    
    Card.Mutable ace = new Card.Mutable(Card.Color.Diamonds, Card.Value.Ace);
    Card.Mutable four = new Card.Mutable(Card.Color.Diamonds, Card.Value.Four);
    Card.Mutable two = new Card.Mutable(Card.Color.Diamonds, Card.Value.Two);

    dealer.dealCard(ace);
    dealer.dealCard(four);
    dealer.dealCard(two);

    dealer.showHand();

    assertEquals(17, dealer.calcScore());

  }

}
