package org.itstep.qa.gamemause.runner;

import org.itstep.qa.gamemause.lesson.Kust;
import org.itstep.qa.gamemause.lesson.Mause;

import java.util.Random;

public class result {
    private static final int SIZE_FIELD = 100;
    private static final int COUNT_BUSHES = 18;

    public static void main(String[] args) {
        String[] colours = {"Черный", "Зеленый", "Красный", "Зеленый",
                "Синий", "Желтый", "Коричневый"};
        Random random = new Random();
        Kust[] arrayBushes = initBushes(colours);
        Mause mouseOne = new Mause(random.nextInt(SIZE_FIELD - 1),
                random.nextInt(SIZE_FIELD - 1),
                "Оптимистина",
                SIZE_FIELD);
        Mause mouseTwo = new Mause(random.nextInt(SIZE_FIELD - 1),
                random.nextInt(SIZE_FIELD - 1),
                "Пессемистина",
                SIZE_FIELD);
        boolean isRun = true;
        while (isRun) {
            for (int i = 0; i < arrayBushes.length; i++) {
                if (controlWin(mouseOne, arrayBushes[i])) {
                    mouseOne.setColour(arrayBushes[i].getColour());
                }
                if (controlWin(mouseTwo, arrayBushes[i])) {
                    mouseTwo.setColour(arrayBushes[i].getColour());
                }
                if (controlWin(mouseOne, arrayBushes[i])
                        || controlWin(mouseTwo, arrayBushes[i])) {
                    isRun = false;
                    break;
                }
            }
            if (isRun) {
                mouseOne.runMouse();
                mouseTwo.runMouse();
            }
        }
        printWinner(mouseOne);
        printWinner(mouseTwo);
    }

    private static void printWinner(Mause mouse) {
        if (!mouse.getColour().equals("white")) {
            System.out.println("Мышь " + mouse.getName()
                    + " победила!");
            System.out.println("Ее координаты "
                    + mouse.getCurrentX() + ":" + mouse.getCurrentY());
            System.out.println("Ей присвоен цвет " + mouse.getColour());
        }
    }

    private static boolean controlWin(Mause mause, Kust bush) {
        if (mause.getCurrentX() == bush.getCurrentX() &&
                mause.getCurrentY() == bush.getCurrentY()) {
            return true;
        } else {
            return false;
        }
    }

    private static Kust[] initBushes(String[] colours) {
        Kust[] bushes = new Kust[COUNT_BUSHES];
        Random random = new Random();
        for (int i = 0; i < bushes.length; i++) {
            bushes[i] = new Kust(random.nextInt(SIZE_FIELD - 1),
                    random.nextInt(SIZE_FIELD - 1),
                    colours[random.nextInt(colours.length - 1)]);
        }
        return bushes;
    }
}
