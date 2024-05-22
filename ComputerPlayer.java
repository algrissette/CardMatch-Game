
import java.util.*;

public class ComputerPlayer extends Player {

    public ComputerPlayer(String name) {
        // constructor that allows the computer to inherit methods from its super class
        super(name);

    }

    public void displayHand() {
        // displays the amount of cards the computer has but not the values
        System.out.println(getName() + "'s hand:");
        if (getNumCards() == 1) {
            System.out.println(getNumCards() + " card");

        } else {
            System.out.println("  " + getNumCards() + " cards");
        }

    }

    public int getPlay(Scanner input, Card discard) {
        // chooses what is the best card for the computer to choose
        int count = -1;
        int savedvalue = 0;
        for (int i = 0; i < getNumCards(); i++) {
            if (getCard(i).matches(discard)) {
                if (getCard(i).getValue() > savedvalue) {
                    count = i;
                }

            }

        }
        return count;

    }

}