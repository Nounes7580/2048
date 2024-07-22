package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author youne
 */
public class GridTest {

    public GridTest() {
    }

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void testNewElement() {
        System.out.println("newElement");
        Grid instance = new Grid();
        instance.newElement();

    }

//    @Test
//    public void testMoveRight() {
//        System.out.println("moveRight");
//        Grid instance = new Grid();
//        instance.moveRight();
//
//    }
//
//    @Test
//    public void testMoveLeft() {
//        System.out.println("moveLeft");
//        Grid instance = new Grid();
//        instance.moveLeft();
//
//    }
//
//    @Test
//    public void testMoveTop() {
//        System.out.println("moveTop");
//        Grid instance = new Grid();
//        instance.moveTop();
//
//    }
//
//    @Test
//    public void testMoveBot() {
//        System.out.println("moveBot");
//        Grid instance = new Grid();
//        instance.moveBot();
//
//    }
//
//    @Test
//    public void testFuseRight() {
//        System.out.println("fuseRight");
//        Grid instance = new Grid();
//        instance.fuseRight();
//
//    }
//
//    @Test
//    public void testFuseLeft() {
//        System.out.println("fuseLeft");
//        Grid instance = new Grid();
//        instance.fuseLeft();
//
//    }
//
//    @Test
//    public void testFuseBot() {
//        System.out.println("fuseBot");
//        Grid instance = new Grid();
//        instance.fuseBot();
//
//    }

    @Test
    public void testFuseTop() {
        System.out.println("fuseTop");
        Grid instance = new Grid();
        // instance.fuseTop();

    }

    @Test
    public void testGameOver() {
        System.out.println("gameOver");
        Grid instance = new Grid();
        boolean expResult = false;
        boolean result = instance.gameOver();
        assertEquals(expResult, result);

    }

}
