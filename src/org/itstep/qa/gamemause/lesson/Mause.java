package org.itstep.qa.gamemause.lesson;

import java.util.Random;

public class Mause {
    private final int FORCE_WING = 2;

    private int startX;
    private int startY;
    private int currentX;
    private int currentY;
    private String name;
    private String colour;

    private int dXRun;
    private int dYRun;

    private int dXDig;
    private int dYDig;

    private int sizeField;

    public Mause(int startX, int startY, String name, int sizeField) {
        this.startX = startX;
        this.startY = startY;
        this.currentX = startX;
        this.currentY = startY;
        this.name = name;
        this.colour = "white";
        dXRun = 1;
        dYRun = 1;
        dXDig = 5;
        dYDig = 5;
        this.sizeField = sizeField;
    }

    public int getCurrentX() {
        return currentX;
    }

    public int getCurrentY() {
        return currentY;
    }

    public String getName() {
        return name;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getColour() {
        return colour;
    }

    public void runMouse() {
        Random random = new Random();
        int wingX = random.nextInt(FORCE_WING);
        int wingY = random.nextInt(FORCE_WING);
        dXRun = controlMouse(currentX, dXRun, wingX*dXRun);
        dYRun = controlMouse(currentY, dYRun, wingY*dYRun);
        currentX = currentX + dXRun + wingX*dXRun;
        currentY = currentY + dYRun + wingY*dYRun;
    }

    public void dig(){
        dXDig = controlMouse(currentX, dXDig, 0);
        dYDig = controlMouse(currentY, dYDig, 0);
        currentX = currentX + dXDig;
        currentY = currentY + dYDig;
    }

    private int controlMouse(int current, int d, int wing) {
        int temp = current + d + wing;
        if (temp >= sizeField || temp < 0) {
            d = -d;
        }
        return d;
    }
}



