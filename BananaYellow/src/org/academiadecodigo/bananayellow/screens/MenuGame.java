package org.academiadecodigo.bananayellow.screens;

import org.academiadecodigo.bananayellow.enumclasses.PhrasesType;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;

import java.io.FileNotFoundException;
import java.io.IOException;


public class MenuGame extends Screen {

    private final int pictureNumber;
    private final int rectangleNumber;
    private int idGame;

    private Screen[] screens;

    public MenuGame(int pictureNumber, int rectangleNumber) throws FileNotFoundException {
        this.pictureNumber = pictureNumber;
        this.rectangleNumber = rectangleNumber;
        this.idGame = 0;
        startScreens();

    }

    private void startScreens() throws FileNotFoundException {
        this.screens = new Screen[]{
                this,
                new HorseRace(),
                new MenuINeverEver(),
                new INeverEver(PhrasesType.DIRTY),
                new INeverEver(PhrasesType.NICE),
                new INeverEver(PhrasesType.RATHER)
        };
    }

    public int getIdGame() {
        return idGame;
    }

    public void setIdGame(int idGame) {
        this.idGame = idGame;
    }

    public void start() throws IOException {

        screens[this.idGame].init();
    }


    @Override
    public void init() {
        this.drawScreen();
        //drawRectangles();
        //drawPictures();
        keyboardInit(new KeyboardEvent());
    }



    @Override
    public void drawPictures() {

    }


    public void close() {

    }



    public void keyboardInit(KeyboardEvent keyboardEvent) {
        //PLAY A GAME1
        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent key_1 = new KeyboardEvent();
        key_1.setKey(KeyboardEvent.KEY_1);
        key_1.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(key_1);

        //PLAY A GAME2
        KeyboardEvent key_2 = new KeyboardEvent();
        key_2.setKey(KeyboardEvent.KEY_2);
        key_2.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(key_2);

        //PLAY A GAME3
        KeyboardEvent key_3 = new KeyboardEvent();
        key_3.setKey(KeyboardEvent.KEY_3);
        key_3.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(key_3);

        //PLAY A GAME4
        KeyboardEvent key_4 = new KeyboardEvent();
        key_4.setKey(KeyboardEvent.KEY_4);
        key_4.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(key_4);

        //PLAY A GAME5
        KeyboardEvent key_5 = new KeyboardEvent();
        key_5.setKey(KeyboardEvent.KEY_5);
        key_5.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(key_5);


    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_1:
                try {
                    runGameOne();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case KeyboardEvent.KEY_2:
                try {
                    runGameTwo();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case KeyboardEvent.KEY_4:
                try {
                    runGameThree();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case KeyboardEvent.KEY_3:
                try {
                    runGameFour();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;

            case KeyboardEvent.KEY_5:
                try {
                    runGameFive();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;

        }

    }

    private void runGameFive() throws IOException {
        System.out.println("Starting a game 4 ");
        this.close();
        this.screens[idGame].close();
        this.idGame=5;
        this.start();
    }

    private void runGameFour() throws IOException {
        System.out.println("Starting a game 4 ");
        this.close();
        this.screens[idGame].close();
        this.idGame=4;
        this.start();
    }

    private void runGameThree() throws IOException {
        System.out.println("Starting a game 3 ");
        this.close();
        this.screens[idGame].close();
        this.idGame=3;
        this.start();
    }

    private void runGameTwo() throws IOException {
        System.out.println("Starting a game 2 ");
        this.close();
        this.screens[idGame].close();
        this.idGame=2;
        this.start();
    }

    private void runGameOne() throws IOException {
        System.out.println("Starting a game 1 ");
        this.close();
        this.screens[idGame].close();
        this.idGame=1;
        this.start();

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

}

