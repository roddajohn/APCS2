public class Point {
    private int x;
    private int y;
    private Point previous;
    private int step;
    public Point(int xa, int xy, Point p, int s) {
	x = xa;
	y = xy;
	previous = p;
	step = s + 1;
    }
    public Point(int xa, int xy) {
	x = xa;
	y = xy;
	step = 0;
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
    public int getSteps() {
	return step;
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