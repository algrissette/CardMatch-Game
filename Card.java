/*
 * Card.java
 * 
 * A blueprint class for objects that represent a single playing card 
 * for a game in which cards have both colors and numeric values.
 * 
 * starter code: CS 112 Staff (cs112-staff@cs.bu.edu)
 * completed by: Alan Grissette
 */

public class Card {
    private String color;
    private int value;
    /* The smallest possible value that a Card can have. */
    public static final int MIN_VALUE = 0;

    /* The possible colors that a Card can have. */
    public static final String[] COLORS = { "blue", "green", "red", "yellow" };

    /* Define the third class constant here. */
    public static final int MAX_VALUE = 9;

    /* Put the rest of your class definition below. */

    public Card(String COLOR, int VALUE) {
        // constructor method. sets value and color and checks it
        this.color = COLOR;
        this.value = VALUE;
        setColor(COLOR);
        setValue(VALUE);

    }

    public static boolean isValidColor(String color) {
        // checks if color listed is valid
        for (int i = 0; i < COLORS.length; i++) {
            if (COLORS[i] == color) {
                return true;
            }

        }
        return false;

    }

    public void setColor(String color) {
        // sets the color and checks if the color is valid
        if (isValidColor(color) == true) {
            this.color = color;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void setValue(int value) {
        // sets value and checks if it is valid
        if (MAX_VALUE >= value && value >= MIN_VALUE) {
            this.value = value;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String getColor() {
        // returns the color at the moment
        return this.color;
    }

    public int getValue() {
        // returns the value that is listed
        return this.value;

    }

    public String toString() {
        // converts object data to string
        return this.color + " " + this.value;
    }

    public boolean matches(Card other) {
        // checks if color or value match
        if (other == null) {
            return false;
        }

        if (this.color == other.color || this.value == other.value) {
            return true;
        } else {
            return false;
        }

    }

    public boolean equals(Card other) {
        // checks if color and value matches
        if (other == null) {
            return false;
        }
        if (this.color == other.color && this.value == other.value) {
            return true;

        } else {
            return false;
        }

    }
}
