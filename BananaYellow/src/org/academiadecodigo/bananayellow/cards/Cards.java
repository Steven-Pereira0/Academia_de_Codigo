package org.academiadecodigo.bananayellow.cards;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Cards {
    //private String imgSource;
    private CardNipe cardNipe;
    private CardValue cardValue;

    private Picture picture;
    private Picture backCover;

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public Picture getBackCover() {
        return this.backCover;
    }

    public void setBackCover(Picture backCover) {
        this.backCover = backCover;
    }

    public CardNipe getCardNipe() {
        return cardNipe;
    }

    public void setCardNipe(CardNipe cardNipe) {
        this.cardNipe = cardNipe;
    }

    public CardValue getCardValue() {
        return cardValue;
    }

    public void setCardValue(CardValue cardValue) {
        this.cardValue = cardValue;
    }
}
