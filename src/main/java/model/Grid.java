package model;

import java.util.LinkedList;

/**
 *
 * @author younes
 */
public class Grid {

    private static final int SIZE = 4;
    private Numbers[][] grille;

    /**
     * constructor of grid and allows you to give the size of the game
     */
    public Grid() {
        grille = new Numbers[SIZE][SIZE];

        for (int row = 0; row < SIZE; row++) {
            for (int column = 0; column < SIZE; column++) {
                grille[row][column] = new Numbers();

            }

        }
        newElement();
    }

    /**
     * getter of constructor grid
     *
     * @return grille
     */
    public Numbers[][] getGrille() {
        return grille;
    }

    /**
     * method that allows to show where it does not have a position to occupy
     *
     * @return listVide
     */
    private LinkedList<Position> posEmpty() {
        LinkedList<Position> listVide = new LinkedList<>();
        for (int row = 0; row < SIZE; row++) {
            for (int column = 0; column < SIZE; column++) {
                if (grille[row][column].getRank() == 0) {
                    listVide.add(new Position(row, column));
                }
            }
        }
        return listVide;
    }

    /**
     * method of adding a new value to the game
     */
    public void newElement() {
        LinkedList posEmpty = posEmpty();
        if (posEmpty.size() > 0) {
            int index = (int) (Math.random() * (posEmpty.size()));
            Position pos = (Position) posEmpty.get(index);
            grille[pos.getX()][pos.getY()].split();
        }
    }

    /**
     * method that allows to move right
     */
    private Boolean moveRight() {
        boolean move = false;
        for (int row = 0; row < SIZE; row++) {
            for (int column = 0; column < SIZE; column++) {
                for (int k = column; k + 1 < SIZE && grille[row][k + 1].getRank() == 0; k++) {
                    if (grille[row][column].getRank() != 0) {
                        grille[row][k + 1].setValeur(grille[row][k].getRank());

                        grille[row][k].setValeur(0);
                        move = true;
                    }

                }

            }
        }
        return move;
    }

    /**
     * method that allows to move left
     */
    private Boolean moveLeft() {
        boolean move = false;
        for (int row = 0; row < SIZE; row++) {
            for (int column = SIZE - 1; column >= 0; column--) {
                for (int k = column; k - 1 >= 0 && grille[row][k - 1].getRank() == 0; k--) {
                    if (grille[row][column].getRank() != 0) {
                        grille[row][k - 1].setValeur(grille[row][k].getRank());
                        grille[row][k].setValeur(0);
                        move = true;
                    }

                }
            }
        }
        return move;
    }

    /**
     * method that allows to move upwards
     */
    private boolean moveTop() {
        boolean move = false;
        for (int row = SIZE - 1; row >= 0; row--) {
            for (int column = 0; column < SIZE; column++) {
                for (int k = row; k - 1 >= 0 && grille[k - 1][column].getRank() == 0; k--) {
                    if (grille[row][column].getRank() != 0) {
                        grille[k - 1][column].setValeur(grille[k][column].getRank());
                        grille[k][column].setValeur(0);
                        move = true;
                    }

                }
            }
        }
        return move;
    }

    /**
     * method that allows to move downwards
     */
    private boolean moveBot() {
        boolean move = false;
        for (int row = SIZE - 1; row >= 0; row--) {
            for (int column = 0; column < SIZE; column++) {
                for (int k = row; k + 1 < SIZE && grille[k + 1][column].getRank() == 0; k++) {
                    if (grille[row][column].getRank() != 0) {
                        grille[k + 1][column].setValeur(grille[k][column].getRank());
                        grille[k][column].setValeur(0);
                        move = true;
                    }

                }
            }
        }
        return move;
    }

    /**
     * method that allows to fuse right
     */
    private boolean fuseRight() {
        boolean fused = false;
        for (int row = 0; row < SIZE; row++) {
            for (int column = SIZE - 1; column >= 0; column--) {
                if (grille[row][column].getRank() != 0 && column + 1 < SIZE && grille[row][column].getRank() == grille[row][column + 1].getRank()) {
                    grille[row][column + 1].split();
                    grille[row][column].setValeur(0);
                    fused = true;
                }
            }
        }
        return fused;
    }

    /**
     * method that allows to fuse left
     */
    private boolean fuseLeft() {
        boolean fused = false;
        for (int row = 0; row < SIZE; row++) {
            for (int column = 0; column < SIZE; column++) {
                if (grille[row][column].getRank() != 0 && column - 1 >= 0 && grille[row][column].getRank() == grille[row][column - 1].getRank()) {
                    grille[row][column - 1].split();
                    grille[row][column].setValeur(0);
                    fused = true;
                }
            }
        }
        return fused;
    }

    /**
     * method that allows to fuse downwards
     */
    private boolean fuseBot() {
        boolean fused = false;
        for (int row = SIZE - 1; row >= 0; row--) {
            for (int column = SIZE - 1; column >= 0; column--) {
                if (grille[row][column].getRank() != 0 && row + 1 < SIZE && grille[row][column].getRank() == grille[row + 1][column].getRank()) {
                    grille[row + 1][column].split();
                    grille[row][column].setValeur(0);
                    fused = true;
                }
            }
        }
        return fused;
    }

    /**
     * method that allows to fuse upwards
     */
    private boolean fuseTop() {
        boolean fused = false;
        for (int row = SIZE - 1; row >= 0; row--) {
            for (int column = 0; column < SIZE; column++) {
                if (grille[row][column].getRank() != 0 && row - 1 >= 0 && grille[row][column].getRank() == grille[row - 1][column].getRank()) {
                    grille[row - 1][column].split();
                    grille[row][column].setValeur(0);
                    fused = true;
                }
            }
        }
        return fused;
    }

    /**
     *
     * method that sees when we lose
     *
     * @return isOver
     */
    public boolean gameOver() {
        boolean isOver = true;
        for (int row = 0; row < SIZE; row++) {
            for (int column = 0; column < SIZE; column++) {
                if (grille[row][column].getRank() == 0) {
                    isOver = false;
                }
                if (row > 0 && grille[row][column].getRank() == grille[row - 1][column].getRank()) {
                    isOver = false;
                }
                if (row < SIZE - 1 && grille[row][column].getRank() == grille[row + 1][column].getRank()) {
                    isOver = false;
                }
                if (column > 0 && grille[row][column].getRank() == grille[row][column - 1].getRank()) {
                    isOver = false;
                }
                if (column < SIZE - 1 && grille[row][column].getRank() == grille[row][column + 1].getRank()) {
                    isOver = false;
                }
            }
        }
        return isOver;

    }
/**
 * method which combines the "moveRight" and "fuseRight" 
 * @return moved(true) if we can fuse if not false
 */
  
    public boolean Right() {

        boolean moved = false;

        while (moveRight()) {
            moved = true;
            
        }
        if (fuseRight()) {
            moved = true;
        }
        moveRight();
        return moved;
    }
/**
 * method which combines the "moveLeft" and "fuseLeft" 
 * @return moved(true) if we can fuse if not false 
 */
    public boolean Left() {
        boolean moved = false;
        while (moveLeft()) {
            moved = true;
        }
        if (fuseLeft()) {
            moved = true;
        }
        moveLeft();
        return moved;
    }
/**
 * 
 * method which combines the "moveBot" and "fuseBot" 
 * @return moved(true) if we can fuse if not false
 */
    public boolean Bot() {
        boolean moved = false;
        while (moveBot()) {
            moved = true;

        }
        if (fuseBot()) {
            moved = true;
           
        }
        moveBot();
        return moved;
    }
/**
 * method which combines the "moveTop" and "fuseTop" 
 * @return moved(true) if we can fuse if not false
 */
    public boolean Top() {
        boolean moved = false;
        while (moveTop()) {
            moved = true;
        }
        if (fuseTop()) {
            moved = true;
        }
        moveTop();
        return moved;
    }

}
