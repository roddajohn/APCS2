public class Point {
    private int x;
    private int y;
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
    public String toString() {
	return "(" + x + ", " + y + ")";
    }
}