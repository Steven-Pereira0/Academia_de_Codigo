package org.academiadecodigo.bananayellow.screens;


import org.academiadecodigo.bananayellow.Utils;
import org.academiadecodigo.bananayellow.cards.CardNipe;
import org.academiadecodigo.bananayellow.cards.CardValue;
import org.academiadecodigo.bananayellow.cards.Cards;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.*;

import static org.academiadecodigo.bananayellow.Utils.cardNipeShuffle;
import static org.academiadecodigo.bananayellow.Utils.cardTypeShuffle;


public class HorseRace extends Screen implements KeyboardHandler {

    public List<CardNipe> cardNipes;
    public List<String> cardTypes;

    Cards playerWinner;

    private List<Cards> cards;

    private int positionY;
    private boolean nipeInTop;
    private boolean winnner;
    private int idCoverToDelete;
    private Cards cardWithNipe;


    public HorseRace() {
        this.cardNipes = new ArrayList<CardNipe>();
        this.cardTypes = new ArrayList<String>();
    }

    private void resetInicialProperties(){
        this.nipeInTop = true;
        this.winnner = false;
        this.positionY = 550;
        this.idCoverToDelete = 4;
    }

    public List<Cards> getCards() {
        return cards;
    }

    public void setCards(List<Cards> cards) {
        this.cards = cards;
    }


    public boolean isNipeInTop() {
        return nipeInTop;
    }

    public void setNipeInTop(boolean nipeInTop) {
        this.nipeInTop = nipeInTop;
    }

    public Cards getCardWithNipe() {
        Cards result = isNipeInTop() ? cards.get(cards.size() - 1) : cards.get(idCoverToDelete - 1);
        return result;
    }

    public void setCardWithNipe(Cards cardWithNipe) {
        this.cardWithNipe = cardWithNipe;
    }

    public void drawScreen() {
        Picture horse_race_sreen = new Picture(Utils.PADDING, Utils.PADDING,"resources/horseRace.png");
        horse_race_sreen.draw();
    }

    private void createCardsList(ArrayList<Cards> cardToAdd, ArrayList<Cards> cardToShuffle) {
        this.cards = new ArrayList<Cards>();
        this.cards.addAll(cardToAdd);
        this.cards.addAll(cardToShuffle);

    }

    public void setAllNipesAndTypes() {
        //System.out.println("\nSetting All Nipes And Types ...");
        List<CardNipe> cardNipes = new ArrayList<>();
        List<String> cardType = new ArrayList<>();
        List<CardNipe> fullCardNipeList = cardNipeShuffle();
        List<String> fullCardTypeList = cardTypeShuffle();

        int counter = 0;
        for (int i = 0; i < fullCardTypeList.size(); i++) {
            for (int j = 0; j < fullCardNipeList.size(); j++) {
                cardNipes.add(fullCardNipeList.get(j));
                cardType.add(fullCardTypeList.get(i));
                counter++;
            }
        }

        Collections.shuffle(cardNipes);
        Collections.shuffle(cardType);
        this.cardNipes = cardNipes;
        this.cardTypes = cardType;
    }


    private List<Cards> createShuffleList() {
        //System.out.println("\nCreating Shuffle List ...");
        int counter = 0;
        int counterShuffle = 0;
        List<CardNipe> cardNipes = this.cardNipes;
        List<String> carTypes = this.cardTypes;
        List<Cards> shuffleList = new ArrayList<Cards>();

        for (int i = 0; i < cardNipes.size(); i++) {
            String cardType = carTypes.get(i);
            String path = Utils.FILE_SOURCE + cardNipes.get(i).getName() + cardType + ".png";
            Cards cardsNew1 = new Cards();

            cardsNew1.setCardNipe(cardNipes.get(i));

            int pos = (counter < 5) ? counter : 6;
            int[] POS_X = {660, 660, 660, 660, 660, 660, 60};
            int[] POS_Y = {550, 450, 350, 250, 150, 50, 90};

            Picture picture = new Picture(POS_X[pos], POS_Y[pos], path);
            Picture backCover = new Picture(POS_X[pos], POS_Y[pos], Utils.FILE_SOURCE + "verso.png");
            cardsNew1.setPicture(picture);
            cardsNew1.setBackCover(backCover);

            shuffleList.add(cardsNew1);
            counter++;
        }
        return shuffleList;
    }

    private List<Cards> createAcesList() {

        int counter = 0;
        CardNipe[] cardNipes = CardNipe.values();
        CardValue[] cardValues = CardValue.values();
        String[] carTypes = Utils.CARD_TYPE;
        List<Cards> acesList = new ArrayList<>();
        List<Cards> cardToAdd = new ArrayList<>();

        for (int x = 0; x < cardNipes.length; x++) {
            String cardType = "_A";
            String path = Utils.FILE_SOURCE + cardNipes[x].toString() + cardType + ".png";

            Cards cardsNew = new Cards();
            cardsNew.setCardNipe(cardNipes[x]);
            cardsNew.setCardValue(CardValue.C__A);
            int[] POS_X = {180, 300, 420, 540};
            int[] POS_Y = {550, 550, 550, 550};
            Picture picture = new Picture(POS_X[x], POS_Y[x], path);

            cardsNew.setPicture(picture);
            acesList.add(cardsNew);
        }

        return acesList;
    }

    public void moveBottonDeckCar() {
        boolean condition = this.isNipeInTop();
        int yPosition = (condition) ? -Utils.moveToYposition : Utils.moveToYposition;
        Cards card = this.getCardWithNipe();

        selectCardToMove(yPosition);
        removeCardAfterMove(condition, card);

    }

    private void removeCardAfterMove(boolean condition, Cards card) {
        if (condition) {
            card.getPicture().delete();
            cards.remove(cards.size() - 1);

        } else {
            card.getBackCover().delete();
        }
    }

    private boolean selectCardToMove(int yPos) {

        Cards card = getCardWithNipe();
        List<Integer> sameYPosition = new ArrayList<>();
        List<Boolean> winners = new ArrayList<>();

        boolean result;
        for (int i = 0; i < 4; i++) {
            if (cards.get(i).getCardNipe().equals(card.getCardNipe())) {
                int yPositionOfCardToMove = cards.get(i).getPicture().getY();
                if (yPositionOfCardToMove > Utils.minYposition &&
                        yPositionOfCardToMove < Utils.maxYposition+1) {
                    cards.get(i).getPicture().translate(0, yPos);
                    winners.add(cards.get(i).getPicture().getY() == Utils.minYposition);
                    this.playerWinner = cards.get(i);
                }


                //System.out.println("\n" +card.getPicture() +" \nmoved " + cards.get(i).getPicture());

            }
            this.winnner = (winners.contains(true));

            if(cards.get(i).getPicture().getY() >= this.positionY){
                sameYPosition.add(1);
            } else {
                sameYPosition.add(0);
            }


        }
        //System.out.println(" HAS WINNER?: " +winnner);
        ;
        //result = sameYPosition.contains(this.positionY);
        result = sameYPosition.contains(1);
        if (!result) {
            cards.get(idCoverToDelete).getBackCover().delete();
            this.positionY -= 100;
            this.idCoverToDelete++;
            this.nipeInTop = false;
        } else {
            this.nipeInTop = true;
        }

        return result;
    }


    public void keyboardInit(KeyboardEvent keyboardEvent) {
        //PLAY A GAME
        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_SPACE);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(down);


    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        System.out.println("Has Winner? " + !this.winnner);
        switch (keyboardEvent.getKey()){

            case KeyboardEvent.KEY_SPACE:
                if (!this.winnner) {
                    moveBottonDeckCar();
                } else {
                    doWinnerStuff();
                    this.playerWinner = new Cards();
                }
                break;
        }


    }

    private void doWinnerStuff() {
        System.out.println("PRESS \tRIGHT_KEY to New Game\n\t\tQ to Quit");
        System.out.println(this.playerWinner.getPicture());
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        // Not implemented yet
    }


    @Override
    public void drawPictures() {
        int i = 0;
        //System.out.println("Drawing Pictures ...");
        for (Cards card : cards) {
            i++;
            card.getPicture().draw();
            if (i > 4 && i < 18) {
                card.getBackCover().draw();
            }
            //////System.out.println(i + " - " + card.getPicture());
        }

        this.cardWithNipe = this.cards.get(cards.size() - 1);

    }

    @Override
    public void close() {



    }


    @Override
    public void init() {
        resetInicialProperties();
        drawScreen();
        setAllNipesAndTypes();
        ArrayList<Cards> cardToAdd = (ArrayList<Cards>) createAcesList();
        ArrayList<Cards> cardToShuffle = (ArrayList<Cards>) createShuffleList();
        createCardsList(cardToAdd, cardToShuffle);
        drawPictures();
        keyboardInit(new KeyboardEvent());
        System.out.println("cards.size: "+cards.size());
    }

}

