package com.yavdev.section15;

import java.util.ArrayList;
import java.util.List;

public class Card {
    private final Face face;
    private final Suit suit;
    private final int rank;

    public Card(Face face, Suit suit) {
        this(face, suit, face.getRank());
    }

    public Card(Face face, Suit suit, int rank) {
        this.face = face;
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return String.format(
                "%s%c(%d)",
                this.face.getAbbreviation(),
                (char) this.suit.getSuitAsciiCode(),
                this.rank
        );
    }

    public static Card getNumericCard(Suit suit, int number) {
        if (!(number < Face.JACK.getRank() && number > 0)) {
            throw new IllegalStateException("Value out of range [0, 8]: " + number);
        }

        return new Card(Face.fromNumber(number), suit);
    }

    public static Card getFaceCard(Suit suit, String abbreviation) {
        final Face face = switch (abbreviation) {
            case "J" -> Face.JACK;
            case "Q" -> Face.QUEEN;
            case "K" -> Face.KING;
            case "A" -> Face.ACE;
            default ->
                    throw new IllegalStateException("Valid values are J, Q, K, A. Unexpected value: " + abbreviation);
        };

        return new Card(face, suit);
    }

    public static List<Card> getStandardDeck() {
        final List<Card> standardDeckOfCards = new ArrayList<>();

        for (var suit : Suit.values()) {
            for (var face : Face.values()) {
                standardDeckOfCards.add(new Card(face, suit));
            }
        }

        return standardDeckOfCards;
    }

    public static void main(String[] args) {
        System.out.println(getStandardDeck());
    }
}
