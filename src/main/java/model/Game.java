package model;

import java.util.ArrayList;
import java.util.List;
import javafx.event.Event;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyEvent;
import viewFx.Observer;
import viewFx.ViewApp;

/**
 *
 * @author youne
 */
public class Game implements Observable {

    private List<Observer> observers = new ArrayList<>();
    private final Grid grid;
    private final int score;

    /**
     *
     */
    public Game() {
        this.grid = new Grid();
        this.score = 0;
    }

    /**
     * 
     * @return score;
     */
    public int getScore() {
        return score;
    }

    /**
     *
     * @return grid;
     */
    public Grid getGrid() {
        return grid;
    }

    /**
     *
     * method of moving forward where possible
     * if movement is not possible, this displays a Throw new illegal argument
     * @param direction
     */
    public void move(Direction direction) {

        boolean moved = false;

        switch (direction) {
            case DROITE:
                moved = grid.Right();
                break;
            case GAUCHE:
                moved = grid.Left();
                break;
            case HAUT:
                moved = grid.Top();
                break;
            case BAS:
                moved = grid.Bot();
                break;
        }

        if (moved) {
            grid.newElement();

        } else {

            throw new IllegalArgumentException("mouvement impossible");

        }

    }
/**
 * method of assigning a key to its direction
 * @param e
 * @return 
 */
    public Direction getdirection(KeyEvent e) {
        Direction direction;

        switch (e.getCode()) {
            case UP:
                direction = Direction.HAUT;
                break;

            case LEFT:
                direction = Direction.GAUCHE;
                break;

            case RIGHT:
                direction = Direction.DROITE;
                break;
            case DOWN:
                direction = Direction.BAS;
                break;
            default:
                direction = null;
        }
       
        
        return direction;
    }
/**
 * method of moving forward where possible in JavaFx
 * she calls the method getdirection
 * 
 * @param e 
 */
    public void playFx(KeyEvent e) {
        Direction direction = getdirection(e);

        if (grid.gameOver()) {
            throw new IllegalArgumentException("vous avez perdu ,veuillez relancer");
        }

        switch (direction) {
            case HAUT:
                move(Direction.HAUT);

                break;

            case GAUCHE:
                move(Direction.GAUCHE);

                break;

            case DROITE:
                move(Direction.DROITE);

                break;

            case BAS:
                move(Direction.BAS);

                break;

        }

        notifyObservers();

    }

    @Override
    public void registerObserver(Observer obs) {
        if (!observers.contains(obs)) {
            observers.add(obs);
        }
    }

//    @Override
//    public void removeObserver(Observer obs) {
//        if (observers.contains(obs)) {
//            observers.remove(obs);
//        }
//
//    }

    @Override
    public void notifyObservers() {
        for (Observer obs : observers) {
            obs.update();
        }
    }
}
