package org.academiadecodigo.bananayellow.cards;

public enum CardNipe {
    HEARTS("hearts_"), CLUBS("clubs_"), DIAMONDS("diamonds_"), SPADES("spades_");

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    CardNipe(String name) {
        this.name = name;
    }
}
