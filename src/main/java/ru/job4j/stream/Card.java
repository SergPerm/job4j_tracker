package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public static List<Card> generatedCard() {
        return Stream.of(Suit.values())
                .flatMap(s -> Stream.of(Value.values())
                        .map(v -> new Card(s, v)))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "mast " + suit + " karta " + value;
    }

    public static void main(String[] args) {
        List<Card> cards = Card.generatedCard();
        cards.forEach(System.out::println);

    }
}