/*
 * CardMatch.java
 * 
 * Computer Science 112, Boston University
 * 
 * The main class for a program that plays a card game called CardMatch.
 * It also serves as a blueprint class for a CardMatch object, which maintains
 * the state of the game.
 *
 * modified by: ALan Grissette, <hsalley@bu.edu>
 */

import java.util.*;

public class Player {

    private String name;
    private Card[] hand;
    private int numCards;

    public Player(String name) {
        // constructor method to inditialze player
        this.name = name;
        this.hand = new Card[CardMatch.MAX_CARDS];

    }

    public String getName() {
        // returns the name
        return name;
    }

    public int getNumCards() {
        // returns amount of cards
        return numCards;
    }

    public String toString() {
        // returns name
        return name;
    }

    public void addCard(Card card) {
        // adds card to array
        if (card == null || numCards == hand.length) {
            throw new IllegalArgumentException();
        } else {
            hand[numCards] = card;
            numCards++;
        }
    }

    public Card getCard(int number) {
        // gets the value of the card depending on inputted index
        if (number > numCards || number < 0 || hand[number] == null) {
            throw new IllegalArgumentException();
        } else {
            return hand[number];
        }

    }

    public int getHandValue() {
        // adds the values in the hand together
        int result = 0;
        for (int i = 0; i < hand.length; i++) {
            if (hand[i] != null) {
                result += hand[i].getValue();
            }
        }
        return result;
    }

    public void displayHand() {
        // displays what is in the players hand for players to see
        System.out.println(name + "'s hand:");
        for (int i = 0; i < hand.length; i++) {
            if (hand[i] == null) {
                continue;
            }
            System.out.println("  " + i + ": " + hand[i].getColor() + " " + hand[i].getValue());

        }

    }

    public Card removeCard(int x) {
        // removes card from array and switches the last value to replace
        Card save = hand[x];
        if (hand[x] == null) {
            throw new IndexOutOfBoundsException();
        } else {
            hand[x] = hand[numCards - 1];
            hand[numCards - 1] = null;
            numCards--;
        }
        return save;

    }

    public int getPlay(Scanner input, Card discard) {
        // shows the card that will be put out or drawn
        System.out.println(name + ": Enter a number!");
        int play = input.nextInt();
        if (play == -1) {
            return -1;
        } else {
            if (play < -1 || play > numCards) {
                throw new IllegalArgumentException();
            } else {
                return play;
            }
        }
    }

}
