/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewFx;

import java.util.Calendar;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.Game;

/**
 *
 * @author youne
 */
public class ViewApp extends Application {

    @Override
    public void start(Stage stage) {

        int minute;
        int hour;
        

        /**
         * All the names necessary for the application
         */
        Game gameFx = new Game();
        HBox root = new HBox();
        VBox tray = new VBox();
        VBox panel = new VBox();
        HBox bouton = new HBox();
        Button button = new Button("relancer");
        Button button2 = new Button("quitter");
        DropShadow shadow = new DropShadow();
        final Pane spacer = new Pane();
        ListView<String> commande = new ListView<>();
        gridFxgauche grid = new gridFxgauche(gameFx);

        /**
         *  it allows me to have the time during the game
         */
        Calendar cal = Calendar.getInstance();
        minute = cal.get(Calendar.MINUTE);
        hour = cal.get(Calendar.HOUR_OF_DAY);
        /**
         * It allows me to create a space allowing me to place it between my elements
         */
        HBox.setHgrow(spacer, Priority.ALWAYS);
        spacer.setMinSize(1, 50);
        /**
         * Is the placement of my buttons 
         */
        bouton.getChildren().addAll(button, button2);
        HBox.setMargin(button, new Insets(0, 0, 0, 50));
        bouton.setSpacing(100);
        /**
         * design of my button1 and its size
         */
        button.setMaxSize(200, 50);
        button.setStyle("-fx-background-color:beige;");
        button.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        /**
         *design of my button2 and its size
         */
        button2.setMaxSize(200, 50);
        button2.setStyle("-fx-background-color:beige;");
        button2.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        /**
         *placement of the child grid elements ,space and bouton in my VBox tray
         */
        tray.getChildren().addAll(grid, spacer, bouton);
        /**
         * displays the welcome message in ListView and application of a writing style
         */
        commande.getItems().add(hour + ":" + (minute) + "  - Salutations joueur :)");
        commande.setStyle("-fx-font-family: Arial;" + "-fx-font-weight: bold;" + "-fx-font-size: 15;");
        commande.setFocusTraversable(false);
        /**
         * indicate the size of the Vbox Panel and placement of the listView 
         */
        panel.setMaxSize(400, 1000);
        panel.setMinSize(400, 1000);
        panel.getChildren().addAll(commande);
        /**
         * Positioning of panel an tray 
         */
        HBox.setMargin(tray, new Insets(170, 100, 500, 50));
        HBox.setMargin(panel, new Insets(170, 0, 0, 0));
        /**
         * placment tray an panel in root
         */
        root.getChildren().addAll(tray, panel);
        root.setBackground(new Background(new BackgroundFill(Color.BURLYWOOD, CornerRadii.EMPTY, Insets.EMPTY)));

        Scene scene = new Scene(root, 1000, 750);
        /**
         * The event makes it possible to put a shadow when the cursor is on it.
         */
        button.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {

                button.setEffect(shadow);

            }
        });
        /**
         * The event remove effect when the cursor isn't on it.
         */
        button.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                button.setEffect(null);

            }
        });
        /**
         * The event makes it possible to put a shadow when the cursor is on it.
         */
        button2.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {

                button2.setEffect(shadow);
            }
        });
        /**
         * The event remove effect when the cursor isn't on it.
         */
        button2.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {

                button2.setEffect(null);

            }
        });
        /**
         * the event restart de game
         */
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {

                start(stage);

            }

        });
        /**
         *  the event exit the window
         */
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {

                Platform.exit();

            }
        });
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            int i = 1;

            /**
             * the event allows you to move in game (JavaFx)
             */
            @Override
            public void handle(KeyEvent t) {

                if (i == 1) {
                    commande.getItems().add(hour + ":" + (minute) + "  - Partie commancer ");
                }
                i++;

                try {
                    gameFx.playFx(t);

                } catch (Exception e) {
                    commande.getItems().addAll(hour + ":" + (minute) + " - " + e.getMessage());
                }

            }

        });

        stage.setResizable(false);
        stage.setTitle("Jeu 2048");
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
    }

}
