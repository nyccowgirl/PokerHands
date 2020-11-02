package com.company;

/*
Trang Hoang
CS111B - Assignment 2B
 */

import java.util.Scanner;

public class PokerHands {

    private static final int size = 5;
    private static final int low = 2;
    private static final int high = 9;
    private static final int numInt = (high - low + 1);
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
	    int[] hand = new int[size];

	    getCards(hand);

	    if (containsFourOfaKind(hand)) {
            System.out.println("Four of a Kind!");
        } else if (containsFullHouse(hand)) {
            System.out.println("Full House!");
        } else if (containsStraight(hand)) {
	        System.out.println("Straight!");
        } else if (containsThreeOfaKind(hand)) {
	        System.out.println("Three of a Kind!");
        } else if (containsTwoPair(hand)) {
	        System.out.println("Two Pair!");
        } else if (containsPair(hand)) {
	        System.out.println("Pair!");
        } else {
	        System.out.println("High Card!");
        }
    }


    /**
     * The getCards method asks user to provide 5 cards that are stored in an array that was passed by reference.
     * @param hand Array to store value of 5 cards
     */

    public static void getCards(int[] hand) {
        int card;

        System.out.println("Enter five numeric cards, no face cards. Use " + low + " - " + high + ".");

        for (int i = 0; i < size; i++) {
            System.out.print("Card " + (i + 1) + ": ");
            card = input.nextInt();
            hand[i] = validateCard(card);
        }
    }


    /**
     * The validateCard method returns a valid card between 2 - 9 after checking user input. If not valid, it asks
     * user to input another card within the valid range.
     * @param card Value of card to validate
     * @return integer within the valid range
     */
    public static int validateCard(int card) {
        while (card < 2 || card > 9) {
            System.out.println("Invalid input: card has to be from " + low + " - " + high + ".");
            System.out.print("Re-enter card: ");
            card = input.nextInt();
        }
        return card;
    }


    /**
     * The containsFourOfaKind returns true if the hand has a four of a kind. Otherwise, it returns false.
     * @param hand Array with 5 card values
     * @return True if the array has at least a four of a kind or false otherwise
     */

    public static boolean containsFourOfaKind(int[] hand) {
        int[] count = new int[numInt];

        for (int i = 0; i < size; i++) {
            count[hand[i] - low]++;
        }

        for (int i = 0; i < numInt; i++) {
            if (count[i] >= 4) {
                return true;
            }
        }
        return false;
    }


    /**
     * The containsFullHouse returns true if the hand has a full house. Otherwise, it returns false.
     * @param hand Array with 5 card values
     * @return True if the array has at least a full house or false otherwise
     */

    public static boolean containsFullHouse(int[] hand) {
        return (containsThreeOfaKind(hand) && containsTwoPair(hand));
    }


    /**
     * The containsStraight method returns true if the hand has a straight. Otherwise, it returns false.
     * @param hand Array with 5 card values
     * @return True if the array has at least a straight or false otherwise
     */

    public static boolean containsStraight(int[] hand) {
        int sequence = 0;
        int[] count = new int[numInt];

        for (int i = 0; i < size; i++) {
            count[hand[i] - low]++;
        }

        for (int i = 0; i < numInt; i++) {
            if (count[i] > 0) {
                sequence++;
            } else {
                sequence = 0;
            }

            if (sequence >= 5) {
                return true;
            }
        }
        return false;
    }


    /**
     * The containsThreeOfaKind method returns true if the hand has a three of a kind. Otherwise, it returns false.
     * @param hand Array with 5 card values
     * @return True if the array has at least a three of a kind or false otherwise
     */

    public static boolean containsThreeOfaKind(int[] hand) {
        int[] count = new int[numInt];

        for (int i = 0; i < size; i++) {
            count[hand[i] - low]++;
        }

        for (int i = 0; i < numInt; i++) {
            if (count[i] >= 3) {
                return true;
            }
        }
        return false;
    }


    /**
     * The containsTwoPair returns true if the hand has two pairs. Otherwise, it returns false.
     * @param hand Array with 5 card values
     * @return True if the array has at least two pairs or false otherwise
     */

    public static boolean containsTwoPair(int[] hand) {
        int pair = 0;
        int[] count = new int[numInt];

        for (int i = 0; i < size; i++) {
            count[hand[i] - low]++;
        }

        for (int i = 0; i < numInt; i++) {
            if (count[i] >= 2) {
                pair++;
            }

            if (pair == 2) {
                return true;
            }
        }
        return false;
    }


    /**
     * The containsPair method returns true if the hand has a pair. Otherwise, it returns false.
     * @param hand Array with 5 card values
     * @return True if the array has at least a pair or false otherwise.
     */

    public static boolean containsPair(int[] hand) {
        int[] count = new int[numInt];

        for (int i = 0; i < size; i++) {
            count[hand[i] - low]++;
        }

        for (int i = 0; i < numInt; i++) {
            if (count[i] >= 2) {
                return true;
            }
        }
        return false;
    }
}

/*
Enter five numeric cards, no face cards. Use 2 - 9.
Card 1: 8
Card 2: 7
Card 3: 8
Card 4: 2
Card 5: 7
Two Pair!

Enter five numeric cards, no face cards. Use 2 - 9.
Card 1: 4
Card 2: 5
Card 3: 6
Card 4: 8
Card 5: 7
Straight!

Enter five numeric cards, no face cards. Use 2 - 9.
Card 1: 9
Card 2: 2
Card 3: 3
Card 4: 4
Card 5: 5
High Card!

Enter five numeric cards, no face cards. Use 2 - 9.
Card 1: 7
Card 2: 2
Card 3: 7
Card 4: 2
Card 5: 7
Full House!

Enter five numeric cards, no face cards. Use 2 - 9.
Card 1: 6
Card 2: 2
Card 3: 6
Card 4: 6
Card 5: 6
Four of a Kind!
 */
