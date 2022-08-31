package org.academiadecodigo.bananayellow;

import org.academiadecodigo.bananayellow.cards.CardNipe;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Utils {
    public static int posX;
    public static int posY;
    public static int width = 800;
    public static int heigth = 650;
    public static final int PADDING = 10;

    public static final int moveToYposition = 100;
    public static final int minYposition = 50;
    public static final int maxYposition = 550;

    public static final String FILE_SOURCE = "resources/";


    //public static final String CARDS_PATH = "resources/";
    public static String[] CARD_TYPE = {"K", "J", "Q", "10", "9", "8", "7", "6", "5", "4", "3", "2"};

    public static final int[] POS_X = {180, 300, 420, 540, 660, 660, 660, 660, 660, 660};
    public static final int[] POS_Y = {550, 550, 550, 550, 550, 450, 350, 250, 150, 50};


    public List<String> allTypes;
    public List<CardNipe> allNipes;


    public static List<String> cardTypeShuffle(){
        List<String > list = new ArrayList<>();
        for (String type : CARD_TYPE) {
            list.add(type);
            Collections.shuffle(list);
        }
        return list;
    }

    public static List<Picture> createPicturesFromText(String text) throws IOException {
        List<Picture> tmpListOfPictureFromText = new ArrayList<>();
        List<String> listOfText = breakStringAt(text, 26);
        for (int i = 0; i < listOfText.size(); i++) {
            convertTextToGraphic(listOfText.get(i), Utils.FILE_SOURCE+"txtImg" + i + ".png");
            int posX = (Utils.width/2) -(listOfText.get(i).length()*8)-20;
            int posY = 320+ (i*40);
            Picture picture = new Picture(posX, posY, Utils.FILE_SOURCE+"txtImg" + i + ".png");
            picture.draw();
            System.out.println("\npicture.getMaxY(): " + picture.getMaxX());
            System.out.println("listOfText.get(i).length(): " +listOfText.get(i).length());
            tmpListOfPictureFromText.add(picture);
        }
        return tmpListOfPictureFromText;
    }

    public static List<CardNipe> cardNipeShuffle(){
        List<CardNipe > list = new ArrayList<>();
        for (CardNipe type : CardNipe.values()) {
            list.add(type);
            Collections.shuffle(list);
        }
        return list;
    }


    private static List<String> breakStringAt(String text, int breakAt) {
        List<String> breakedString = new ArrayList<>();
        String newString = "";
        for (int i = 0; i < text.length(); i++) {
            newString+=text.charAt(i);
            if (newString.length()>=breakAt && newString.endsWith(" ")){
                breakedString.add(newString);
                newString="";
            }
        }
        breakedString.add(newString);
        breakedString.forEach((n)-> System.out.println(n));
        return breakedString;
    }

    private static void convertTextToGraphic(String text, String fileName) throws IOException {
        //public static BufferedImage convertTextToGraphic(String text, String fileName) throws IOException {
        Font font=new Font("Arial", Font.PLAIN, 40);
        Color color = Color.YELLOW;

        BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();

        g2d.setFont(font);
        FontMetrics fm = g2d.getFontMetrics();
        int width = fm.stringWidth(text);
        int height = fm.getHeight();
        g2d.dispose();

        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        g2d = img.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        g2d.setFont(font);
        fm = g2d.getFontMetrics();
        g2d.setColor(color);
        g2d.drawString(text, 0, fm.getAscent());
        g2d.dispose();
        ImageIO.write(img, "png", new File(fileName));
    }


}
