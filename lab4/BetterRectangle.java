package labs.lab4;
import java.awt.Rectangle;
/**
 * The java.awt.Rectangle class of the standard Java library does not supply a
 * method to compute the area or perimeter of a rectangle. Provide a subclass
 * BetterRectangle of the Rectangle class that has getPerimeter and getArea
 * methods.
 *
 * Do not add any instance variables.
 *
 * In the constructor, DO NOT call the setLocation and setSize methods of the
 * Rectangle class but invoke the superclass constructor instead.
 */
public class BetterRectangle extends Rectangle {
    /**
     * Constructs a new rectangle whose upper-left corner is specified as x,y)
     and
     * whose width and height are specified by the arguments of the same name.
     *
     * @param x the specified X coordinate
     * @param y the specified Y coordinate
     * @param width the width of the Rectangle
     * @param height the height of the Rectangle
     */
    public BetterRectangle(int x, int y, int width, int height) {
// HINT: CALL THE SUPERCLASS CONSTRUCTOR AS PART OF YOUR IMPLEMENTATION
// FILL IN
        super(x,y,width,height);
    }
    /**
     * Calculates the perimeter of the rectangle.
     *
     * @return the perimeter of the rectangle
     */
    public double getPerimeter() {
        return 2*width + 2*height; // FIX ME
    }
    /**
     * Calculates the area of the rectangle.
     *
     * @return the area of the rectangle
     */
    public double getArea() {
        return width * height; // FIX ME
    }

    public static void main (String [] args){
        BetterRectangle r1 = new BetterRectangle(2, 3, 15, 17);
        System.out.println(r1.getX()); // returns 2.0
        System.out.println(r1.getY()); // returns 3.0
        System.out.println(r1.getWidth()); // returns 15.0
        System.out.println(r1.getHeight()); // returns 17.0
        System.out.println(r1.getPerimeter()); // returns 64.0
        System.out.println(r1.getArea()); // returns 255.0
    }
}
