public class Point {
    private int x;
    private int y;
    private Point previous;
    public Point(int xa, int xy, Point p) {
	x = xa;
	y = xy;
	previous = p;
    }
    public Point(int xa, int xy) {
	x = xa;
	y = xy;
    }
    public int getX() {
	return x;
    }
    public int getY() {
	return y;
    }
    public Point previousPoint() {
	return previous;
    }
    public String toString() {
	return "(" + x + ", " + y + ")";
    }
    public boolean hasNext() {
	if (previous != null) {
	    return true;
	}
	return false;
    }
}