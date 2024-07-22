package controller;

import model.Observable;
import java.util.ArrayList;
import java.util.List;
import model.Direction;
import model.Game;
import view.View;
import viewFx.Observer;

/**
 *
 * @author youne
 */
public class Controller {

    private final View view;
    private final Game game;

    /**
     *
     */
    public Controller() {
        this.view = new View();
        this.game = new Game();

    }

    /**
     *
     */
    public void play() {

        while (!game.getGrid().gameOver()) { // !gameOver()

            view.viewGrid(game.getGrid());

            char direction = view.askDirection();

            switch (direction) {
                case 'H':
                    try {
                    game.move(Direction.HAUT);
                    
                } catch (Exception e) {
                        System.out.println(e.getMessage());
                }
                    break;
                case 'B':
                    
                        try {
                    game.move(Direction.BAS);
                    
                } catch (Exception e) {
                        System.out.println(e.getMessage());
                }
                    break;
                case 'D':
                     try {
                    game.move(Direction.DROITE);
                    
                } catch (Exception e) {
                        System.out.println(e.getMessage());
                }
                    break;
                case 'G':
                        try {
                    game.move(Direction.GAUCHE);
                    
                } catch (Exception e) {
                        System.out.println(e.getMessage());
                }
                    break;
            }

        }

       
    }

}
