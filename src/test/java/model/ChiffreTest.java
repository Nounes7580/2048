package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author youne
 */
public class ChiffreTest {

    @Test
    public void testToString() {
        System.out.println("toString");
        Numbers instance = new Numbers();
        String expResult = "    ";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    @Test
    public void testToString2() {
        System.out.println("toString");
        Numbers instance = new Numbers();
        instance.setValeur(2);
        String expResult = "   2";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    @Test
    public void testToString32() {
        System.out.println("toString");
        Numbers instance = new Numbers();
        instance.setValeur(32);
        String expResult = "  32";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    @Test
    public void testToString256() {
        System.out.println("toString");
        Numbers instance = new Numbers();
        instance.setValeur(256);
        String expResult = " 256";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    @Test
    public void testToString1024() {
        System.out.println("toString");
        Numbers instance = new Numbers();
        instance.setValeur(1024);
        String expResult = "1024";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    @Test
    public void testSplit() {
        System.out.println("split");
        Numbers instance = new Numbers();
        instance.split();
        assertTrue(instance.getRank() == 2);
    }

    @Test
    public void testSplit4() {
        System.out.println("split");
        Numbers instance = new Numbers();
        instance.setValeur(2);
        instance.split();
        assertTrue(instance.getRank() == 4);
    }
     @Test
    public void testSplit8() {
        System.out.println("split");
        Numbers instance = new Numbers();
        instance.setValeur(4);
        instance.split();
        assertTrue(instance.getRank() == 8);
    }

    @Test
    public void testSetValeur() {
        System.out.println("setValeur");
        int valeur = 4;
        Numbers instance = new Numbers();
        instance.setValeur(valeur);
        assertTrue(instance.getRank() == 4);
    }

}
