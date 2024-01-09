package org.udemy.collections;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Suit {
    CLUB((char) 9827),
    DIAMOND((char) 9830),
    HEART((char) 9829),
    SPADE((char) 9824);

    private final char image;
}
