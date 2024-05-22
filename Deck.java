import java.util.*;

public class Deck {
  private List<Card> cards;
  private Random rand;

  public Deck(int randomSeed) {
    cards = new ArrayList<>();

    // Generate the deck with all possible cards
    for (String color : Card.COLORS) {
      for (int value = Card.MIN_VALUE; value <= Card.MAX_VALUE; value++) {
        cards.add(new Card(color, value));
      }
    }

    rand = new Random(randomSeed);
  }

  public void shuffle() {
    Collections.shuffle(cards, rand);
  }

  public Card drawCard() {
    if (cards.isEmpty()) {
      throw new NoSuchElementException("No more cards in the deck");
    }
    return cards.remove(cards.size() - 1);
  }
}
