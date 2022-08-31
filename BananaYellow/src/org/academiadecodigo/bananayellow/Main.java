package org.academiadecodigo.bananayellow;


import org.academiadecodigo.bananayellow.screens.MenuGame;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        MenuGame game = new MenuGame(4, 1);
        game.start();

        //WouldYouRather would_you_rather = new WouldYouRather();
        //would_you_rather.init(SentencesType.RATHER);

    }
}
