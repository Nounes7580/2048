package view;

import java.util.Scanner;
import model.Grid;

/**
 *
 * @author younes
 */
public class View {


/**
 * display the grid of game
 * @param grid 
 */
    public void viewGrid(Grid grid) {

        System.out.println();

        for (int row = 0; row < grid.getGrille().length * 2; row++) {
            for (int column = 0; column < grid.getGrille().length; column++) {
                if (row % 2 == 0) {
                    System.out.print("- - -");
                } else {
                    System.out.print('|' + grid.getGrille()[row / 2][column].toString());
                }
            }
            System.out.println();
        }
    }


    /**
     * 
     * ask where we want to move 
     * 
     * @return choix
     */
    public char askDirection() {
        Scanner keybord = new Scanner(System.in);

        System.out.println("Choisissez une direction [HAUT(H); BAS (B) ; GAUCHE (G) ; DROITE (D)");

        char choice = keybord.next().toUpperCase().charAt(0);

        while (choice != 'H' && choice != 'B' && choice != 'G' && choice != 'D') {
            System.out.println("Entrez une direction valide");
            choice = keybord.next().toUpperCase().charAt(0);
        }
        return choice;
    }
/**
 * display the message of end game
 */
    public void displayMessage() {
        System.out.println("C'est terminer, c'est bien jouer!");
    }
}
