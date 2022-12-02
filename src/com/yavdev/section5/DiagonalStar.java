package com.yavdev.section5;

public class DiagonalStar {
    public static void printSquareStar(int size) {
        for (int i = 0; i < size; i++) {
            if(i == 0 || i == size - 1) {
                fillRowWithStars(size, i == size - 1);
            } else {
                drawRow(size, i, size - i - 1);
            }
        }
    }

    private static void fillRowWithStars(int size, boolean lastRow) {
        for (int i = 0; i < size; i++) {
            drawStar();
        }

        if (!lastRow) {
            moveToNextRow();
        }
    }

    private static void drawRow(int size, int positionFromLeft, int positionFromRight) {
        drawStar();
        for (int i = 1; i != size - 1; i++) {
            if (i == positionFromLeft || i == positionFromRight) {
                drawStar();
            } else {
                drawEmptySpace();
            }
        }
        drawStar();
        moveToNextRow();
    }

    private static void drawStar() {
        System.out.print("*");
    }

    private static void drawEmptySpace() {
        System.out.print(" ");
    }

    private static void moveToNextRow() {
        System.out.println();
    }
}
