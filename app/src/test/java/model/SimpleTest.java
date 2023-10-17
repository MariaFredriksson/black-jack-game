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
    Player player = new Player();
    Dealer dealer = new Dealer(new RulesFactory());

    dealer.newGame(player);

    dealer.hit(player);
    Card.Mutable ace = new Card.Mutable(Card.Color.Diamonds, Card.Value.Ace);
    Card.Mutable four = new Card.Mutable(Card.Color.Diamonds, Card.Value.Four);
    Card.Mutable two = new Card.Mutable(Card.Color.Diamonds, Card.Value.Two);

    dealer.dealCard(ace);
    dealer.dealCard(four);
    dealer.dealCard(two);

    assertEquals(17, dealer.calcScore());

  }

//   public class AlbumGeneratorTest {
//    @Test
//   public void testAlbumGenerator() {
//     // Tests that the constructor and getters works correctly.
//     AlbumGenerator albumGenerator = new AlbumGenerator();
//     Album[] greatestAlbums = albumGenerator.generateAlbums();
//     assertEquals(4, greatestAlbums.length);

//     for (Album a : greatestAlbums) {
//       assertNotNull(a);
//       assertNotEquals("No name", a.getName());
//       assertNotEquals("No artist", a.getArtist());
//       assertNotEquals(-1, a.getYear());
//     }
//   }
// }
}
