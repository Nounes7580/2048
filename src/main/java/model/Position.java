package model;

/**
 *
 * @author younes
 */
public class Position {
    private final  int x;
    private final int y;
/**
 * constructor of position 
 * 
 * @param x
 * @param y 
 */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
/**
 * getter of value x
 * @return x
 */
    public int getX() {
        return x;
    }
/**
 * getter of value y
 * @return y
 */
    public int getY() {
        return y;
    }
    
}
