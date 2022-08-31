package org.academiadecodigo.bananayellow.enumclasses;

import org.academiadecodigo.bananayellow.Utils;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public enum PhrasesType {
    DIRTY(new Picture(Utils.PADDING, Utils.PADDING, Utils.FILE_SOURCE+"spicy.png"), "Dirty"),
    NICE(new Picture(Utils.PADDING, Utils.PADDING, Utils.FILE_SOURCE+"light.png"), "Nice"),

    RATHER (new Picture(Utils.PADDING, Utils.PADDING, Utils.FILE_SOURCE+"rather.png"),"Rather");

    private Picture background;
    private String fileName;

    public Picture getBackground() {
        return background;
    }

    public void setBackground(Picture background) {
        this.background = background;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    PhrasesType(Picture background, String fileName) {
        this.background = background;
        this.fileName = fileName;
    }
}
