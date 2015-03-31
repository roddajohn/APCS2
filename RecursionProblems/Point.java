public class Point {
    private int x;
    private int y;
    private Point getPrevious;

    public Point (int xa, int ya) {
	x = xa;
	y = ya;
    }

    public String toString() {
	String toReturn = "";
	toReturn += x + ", " + y;
	return toReturn;
    }

    public int getX() {
	return x;
    }

    public int getY() {
	return y;
    }

    public Point getPrev() {
	return getPrevious;
    }
}