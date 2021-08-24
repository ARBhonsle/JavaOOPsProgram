package com.json;

import java.util.Random;

public class DeckOfCards {
    // variables
    static int playerCard;
    static String[] cardSuit = {"Clubs", "Diamonds", "Hearts", "Spades"};
    static String[] cardRank = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    static String[][] playerCards = new String[4][9];

    // shuffle card for a player
    public static void cardShuffle(int player, int round) {
        StringBuilder card = new StringBuilder();
        playerCard = (int) Math.floor(Math.random() * 10) % 13;
        card.append(cardRank[playerCard]);
        playerCard = (int) Math.floor(Math.random() * 10) % 4;
        card.append(" of ").append(cardSuit[playerCard]);
        playerCards[player][round] = card.toString();
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Deck of Cards");
        System.out.println("9 cards given to 4 players at random");
        for (int count = 0; count < 9; count++) {
            for (int player = 0; player < 4; player++) {
                cardShuffle(player, count);
            }
        }

        for (int player = 0; player < 4; player++) {
            System.out.println("Player "+(player+1));
            for (int count = 0; count < 9; count++) {
                System.out.println("Card: "+playerCards[player][count]);
            }
        }
    }
}
