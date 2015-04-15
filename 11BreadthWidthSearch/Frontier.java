public class Frontier {
    private int toggle;
    MyDoubleEndedQueue<Point> frontier;
    public Frontier(int mode) {
	toggle = mode;
	frontier = new MyDoubleEndedQueue<Point>();
    }
    public String toString() {
	return frontier.toString();
    }
    public void add(Point p) {
	frontier.addLast(p);
    }
    public Point remove() {
	if (toggle == 0) {
	    return frontier.removeLast();
	}
	else {
	    return frontier.removeFirst();
	}
    }
    public boolean hasNext() {
	if (frontier.size() != 0) {
	    return true;
	}
	return false;
    }
}