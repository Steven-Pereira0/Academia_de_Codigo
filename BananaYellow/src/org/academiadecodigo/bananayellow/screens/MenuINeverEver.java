package org.academiadecodigo.bananayellow.screens;

import org.academiadecodigo.bananayellow.Utils;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MenuINeverEver extends Screen {
    private int idGame;

    private Screen[] screens;

    public void drawScreen() {
        Picture picture = new Picture(Utils.PADDING, Utils.PADDING, "resources/MenuIneverEver.png");
        picture.draw();
    }

    @Override
    public void drawPictures() {

    }

    @Override
    public void close() {

    }

    @Override
    public void init() throws FileNotFoundException {
        drawScreen();

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {


    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }



    private void start() throws IOException {
        screens[this.idGame].init();
    }

}
