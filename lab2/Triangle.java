package labs.lab2;
/**
 * A class to represent a triangle defined by the x- and y-coordinates of its
 * three corner points
 */
public class Triangle {
// ADD INSTANCE VARIABLES HERE
    /**
     * Constructs a triangle with the given corner points
     *
     * @param x1 x-value of corner point 1
     * @param y1 y-value of corner point 1
     * @param x2 x-value of corner point 2
     * @param y2 y-value of corner point 2
     * @param x3 x-value of corner point 3
     * @param y3 y-value of corner point 3
     */
    private double x1 ;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double
            y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
// FILL IN
    }
    /**
     * Returns the length of side 1: (x1, y1) to (x2, y2)
     *
     * @return the length of side 1
     */
    public double getSide1Length() {
        double distx = Math.pow((this.x1 - this.x2), 2);
        double disty = Math.pow((this.y1-this.y2), 2);
        return Math.sqrt(distx + disty); // FIX ME
    }
    /**
     * Returns the length of side 2: (x1, y1) to (x3, y3)
     *
     * @return the length of side 2
     */
    public double getSide2Length() {
        double distx = Math.pow((this.x1 - this.x3), 2);
        double disty = Math.pow((this.y1-this.y3), 2);
        return Math.sqrt(distx + disty);
    }
    /**
     * Returns the length of side 3: (x2, y2) to (x3, y3)
     *
     * @return the length of side 3
     */
    public double getSide3Length() {
        double distx = Math.pow((this.x2 - this.x3), 2);
        double disty = Math.pow((this.y2-this.y3), 2);
        return Math.sqrt(distx + disty);
    }
    /**
     * Returns the angle at corner 1 (x1, y1)
     *
     * @return the angle at corner 1
     */
    public double getAngle1() {

        double a = getSide3Length(); // Side opposite to angle 1
        double b = getSide1Length(); // Side adjacent to angle 1
        double c = getSide2Length(); // Third side

        // Using the Law of Cosines to calculate angle1
        return Math.acos((Math.pow(b, 2) + Math.pow(c, 2) - Math.pow(a, 2)) / (2 * b * c));
    }
    /**
     * Returns the angle at corner 2 (x2, y2)
     *
     * @return the angle at corner 2
     */
    public double getAngle2() {
        double a = getSide2Length(); // Side opposite to angle 1
        double b = getSide3Length(); // Side adjacent to angle 1
        double c = getSide1Length(); // Third side

        // Using the Law of Cosines to calculate angle1
        return Math.acos((Math.pow(b, 2) + Math.pow(c, 2) - Math.pow(a, 2)) / (2 * b * c));
    }
    /**
     * Returns the angle at corner 3 (x3, y3)
     *
     * @return the angle at corner 3
     */
    public double getAngle3() {
        double a = getSide1Length(); // Side opposite to angle 1
        double b = getSide2Length(); // Side adjacent to angle 1
        double c = getSide3Length(); // Third side

        // Using the Law of Cosines to calculate angle1
        return Math.acos((Math.pow(b, 2) + Math.pow(c, 2) - Math.pow(a, 2)) / (2 * b * c));
    }
    /**
     * Returns the perimeter of the triangle
     *
     * @return the perimeter of the triangle
     */
    public double getPerimeter() {
        return getSide1Length() + getSide2Length() + getSide3Length(); // FIX ME
    }
    /**
     * Returns the area of the triangle
     *
     * @return the area of the triangle
     */
    public double getArea() {
        return 0.5 * Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
    }

    public static void main (String [] args){
        Triangle triangle = new Triangle(0, 5, 1.5, 2, 8, 25.92);
        System.out.println("Side 1 Length: " + triangle.getSide1Length());
        System.out.println("Side 2 Length: " + triangle.getSide2Length());
        System.out.println("Side 3 Length: " + triangle.getSide3Length());

        // Print the angles in radians
        System.out.println("Angle 1 (radians): " + triangle.getAngle1());
        System.out.println("Angle 2 (radians): " + triangle.getAngle2());
        System.out.println("Angle 3 (radians): " + triangle.getAngle3());

        // Print the perimeter
        System.out.println("Perimeter: " + triangle.getPerimeter());

        // Print the area
        System.out.println("Area: " + triangle.getArea());
    }

}