package com.yavdev.section15;

public enum Suit {
    CLUB(9827),
    DIAMOND(9830),
    HEART(9829),
    SPADES(9824),
    ;

    private final int suitAsciiCode;

    Suit(int asciiCode) {
        suitAsciiCode = asciiCode;
    }

    public int getSuitAsciiCode() {
        return suitAsciiCode;
    }
}
