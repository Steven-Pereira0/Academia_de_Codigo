package org.academiadecodigo.bananayellow.screens;



import org.academiadecodigo.bananayellow.Utils;
import org.academiadecodigo.bananayellow.enumclasses.PhrasesType;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;


import java.io.File;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;


public class INeverEver extends Screen implements KeyboardHandler {

    Text randomText;
    private String gameMode;
    private final List<Text> listOfPhrasesAsText;
    private final List<String> listOfPhrasesAsString;
    private List<Picture> tmpListOfPictureFromText;
    private  Picture randomPicture;
    private PhrasesType file;

    private Keyboard keyboard;

    private KeyboardEvent event;


    public INeverEver(PhrasesType file) throws FileNotFoundException {
        this.gameMode = gameMode;
        this.listOfPhrasesAsText = new ArrayList<>();
        this.listOfPhrasesAsString = new ArrayList<>();
        this.file = file;

    }



    public void readFile(String file_source) throws FileNotFoundException {
        File file = new File(Utils.FILE_SOURCE+ file_source + ".txt");

        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();

            System.out.println("RANDOM TEXT:" +data +"" + data.length());

            listOfPhrasesAsText.add(new Text(140, 380, data));
            listOfPhrasesAsString.add( data);

        }
        scanner.close();
    }



    public void showText() throws IOException {
        int random = (int) Math.floor(Math.random() * listOfPhrasesAsText.size());
        randomText = listOfPhrasesAsText.get(random);
        this.tmpListOfPictureFromText = Utils.createPicturesFromText(listOfPhrasesAsString.get(random));
        ///randomText.setColor(Color.WHITE);
        ///randomText.draw();
    }

    public void setGameMode(String gameMode) {
        this.gameMode = gameMode;
    }

    public void removeText() {
        ///randomText.delete();
        this.tmpListOfPictureFromText.forEach((picture -> picture.delete()));
    }


    public void keyboardInit() {
        this.keyboard = new Keyboard(this);

        KeyboardEvent spacePressed = new KeyboardEvent();
        spacePressed.setKey(KeyboardEvent.KEY_SPACE);
        spacePressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        this.event = spacePressed;

        keyboard.addEventListener(spacePressed);
    }

    public void keyboardClose() {
        KeyboardEvent keyboardEvent = new KeyboardEvent();
        keyboardEvent.setKey(KeyboardEvent.KEY_SPACE);

        keyboard.removeEventListener(event);

    }



    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            removeText();
            try {
                showText();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void drawPictures() {

    }



    @Override
    public void init() throws IOException {
        this.file.getBackground().draw();
        readFile(file.getFileName());
        showText();
        keyboardInit();
        removeText();
    }

    public void close(){
        removeText();
        file.getBackground().delete();
        keyboardClose();

    }
}



