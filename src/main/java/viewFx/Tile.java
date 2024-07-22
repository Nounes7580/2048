/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewFx;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author youne
 */
public class Tile extends StackPane {

    private final int value;
/**
 * Constructor of class
 * @param value 
 */
    public Tile(int value) {
        this.value = value;

        Rectangle border = new Rectangle(99, 99);
        border.setFill(null);
        border.setStroke(Color.BISQUE);
        setAlignment(Pos.CENTER);
        getChildren().add(border);
        num(value, border);

    }
/**
 * method that allows to select a colour of the number of the tile. 
 * @param chiffre
 * @param border 
 */
    public void num(int chiffre, Rectangle border) {

        switch (chiffre) {

            case 0:

                border.setFill(Color.rgb(204, 192, 179));

                break;
            case 2:
                border.setFill(Color.rgb(238, 228, 218));

                break;
            case 4:
                border.setFill(Color.rgb(237, 224, 200));
                break;
            case 8:
                border.setFill(Color.rgb(242, 177, 121));
                break;
            case 16:
                border.setFill(Color.rgb(245, 149, 99));
                break;
            case 32:
                border.setFill(Color.rgb(246, 124, 95));
                break;
            case 64:
                border.setFill(Color.rgb(246, 94, 59));
                break;

            case 128:
                border.setFill(Color.rgb(237, 207, 114));
                break;
            case 256:
                border.setFill(Color.rgb(237, 204, 97));
                break;
            case 512:
                border.setFill(Color.rgb(237, 200, 80));
                break;
            case 1024:
                border.setFill(Color.rgb(237, 197, 63));
                break;
            case 2048:
                border.setFill(Color.rgb(237, 194, 46));
                break;
            case 4096:
                border.setFill(Color.ROSYBROWN);
                break;
            case 8192:
                border.setFill(Color.PURPLE);
                break;

        }

    }
}
