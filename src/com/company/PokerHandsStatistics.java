package com.company;

/*
Trang Hoang
CS111B - Assignment 2B Bonus
 */

import java.util.Random;

public class PokerHandsStatistics {
    private static final int size = 5;
    private static final int low = 2;
    private static final int high = 9;
    private static final int numInt = (high - low + 1);

    public static void main(String[] args) {
        int numOfHands = 1000000;
        int totalFourOfaKind, totalFullHouse, totalStraight, totalThreeOfaKind,
                totalTwoPair, totalPair, totalHigh;
        int[] hand = new int[size];

        totalFourOfaKind = totalFullHouse = totalStraight = totalThreeOfaKind = 0;
        totalTwoPair = totalPair = totalHigh = 0;

        for (int i = 1; i <= numOfHands; i++) {
            randHand(hand);

            if (containsFourOfaKind(hand)) {
                totalFourOfaKind++;
            } else if (containsFullHouse(hand)) {
                totalFullHouse++;
            } else if (containsStraight(hand)) {
                totalStraight++;
            } else if (containsThreeOfaKind(hand)) {
                totalThreeOfaKind++;
            } else if (containsTwoPair(hand)) {
                totalTwoPair++;
            } else if (containsPair(hand)) {
                totalPair++;
            } else {
                totalHigh++;
            }
        }

        System.out.printf("Statistics from %,d Hands\n", numOfHands);
        System.out.println("--------------------------------");
        System.out.printf("Four of a Kind: %,d ", totalFourOfaKind);
        System.out.printf("(%.2f%%)\n", ((totalFourOfaKind * 100.00) / numOfHands));
        System.out.printf("Full House: %,d ", totalFullHouse);
        System.out.printf("(%.2f%%)\n", ((totalFullHouse * 100.00) / numOfHands));
        System.out.printf("Straight: %,d ", totalStraight);
        System.out.printf("(%.2f%%)\n", ((totalStraight * 100.00) / numOfHands));
        System.out.printf("Three of a Kind: %,d ", totalThreeOfaKind);
        System.out.printf("(%.2f%%)\n", ((totalThreeOfaKind * 100.00) / numOfHands));
        System.out.printf("Two Pairs: %,d ", totalTwoPair);
        System.out.printf("(%.2f%%)\n", ((totalTwoPair * 100.00) / numOfHands));
        System.out.printf("One Pair: %,d ", totalPair);
        System.out.printf("(%.2f%%)\n", ((totalPair * 100.00) / numOfHands));
        System.out.printf("High Card: %,d ", totalHigh);
        System.out.printf("(%.2f%%)\n", ((totalHigh * 100.00) / numOfHands));
    }


    /**
     * The randHand method calls randCardValue to obtain 5 cards that are stored in an array that was passed by
     * reference.
     * @param hand Array to store value of 5 cards
     */

    public static void randHand(int[] hand) {
        for (int i = 0; i < size; i++) {
            hand[i] = randCardValue();
        }
    }


    /**
     * The randCardValue method returns an integer, randomly generated, between low (2) and high (9) range of values.
     * @return Integer between 2 - 9
     */

    public static int randCardValue() {
        Random rand = new Random();

        return rand.nextInt(numInt) + low;
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
Statistics from 1,000,000 Hands
--------------------------------
Four of a Kind: 8,677 (0.87%)
Full House: 17,164 (1.72%)
Straight: 14,744 (1.47%)
Three of a Kind: 103,103 (10.31%)
Two Pairs: 153,651 (15.37%)
One Pair: 512,593 (51.26%)
High Card: 190,068 (19.01%)

Process finished with exit code 0
 */
