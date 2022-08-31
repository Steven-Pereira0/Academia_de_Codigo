package org.academiadecodigo.bananayellow.screens;

import org.academiadecodigo.bananayellow.Utils;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class Screen implements KeyboardHandler {

    public abstract void drawPictures();
    public abstract void close();
    public abstract void init () throws IOException;

    public void drawScreen() {
        Picture picture = new Picture(Utils.PADDING, Utils.PADDING, "resources/MainMenu.png");
        picture.draw();
    }


}
