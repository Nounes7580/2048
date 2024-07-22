/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewFx;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import model.Numbers;
import model.Game;

/**
 *
 * @author youne
 */
public class gridFxgauche extends GridPane implements Observer {

    private Game game;
/**
 * Simple constructor of class
 * @param game 
 */
    public gridFxgauche(Game game) {

        this.game = game;
        game.registerObserver(this);

        Pane zone = new Pane();
        zone.setMaxHeight(500);
        zone.setMaxWidth(500);
        tableau(game.getGrid().getGrille());

        getChildren().add(zone);
    }
    

    /**
     * method for placing the boxes and displaying their numbers
     * @param grid 
     */
    public void tableau(Numbers[][] grid) {
        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 4; column++) {

                Tile tile = new Tile(grid[row][column].getValeur());

                Text t = new Text("");
                if (grid[row][column].getValeur() != 0) {

                    t = new Text(String.valueOf(grid[row][column].getValeur()));
                }
                t.setFont(Font.font("Arial", FontWeight.BLACK, 20));

                StackPane tab = new StackPane();

                setRowIndex(tab, row);
                setColumnIndex(tab, column);
                setRowIndex(tile, row);
                setColumnIndex(tile, column);

                tab.getChildren().addAll(t, tile);

                getChildren().addAll(tile, tab);

            }
        }

    }
/**
 * update 
 */
    @Override
    public void update() {
        tableau(game.getGrid().getGrille());
    }
}
