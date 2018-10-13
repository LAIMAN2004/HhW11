package org.itstep.qa.gamemause.lesson;

public class Kust {
    private int currentX;
    private int currentY;
    private String colour;

    public Kust(int currentX, int currentY, String colour) {
        this.currentX = currentX;
        this.currentY = currentY;
        this.colour = colour;
    }

    public int getCurrentX() {
        return currentX;
    }

    public int getCurrentY() {
        return currentY;
    }

    public String getColour() {
        return colour;
    }

}
