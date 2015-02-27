import java.io.*;
import java.nio.file.*;
import java.nio.charset.*;
import java.util.*;

public class ctravel {
    static int rows, columns, second, startx, starty, endx, endy;
    static String[][] field;
    static int solutions;
    public static void main(String[] args) throws IOException {
	List<String> lines = Files.readAllLines(Paths.get("ctravel.in"), StandardCharsets.UTF_8);
	String[] firstLineArray = lines.get(0).split(" ");
	rows = Integer.parseInt(firstLineArray[0]);
	columns = Integer.parseInt(firstLineArray[1]);
	second = Integer.parseInt(firstLineArray[2]);
	field = new String[rows][columns];
	lines.remove(0);
	for (int i = 0; i < rows; i++) {
	    for (int j = 0; j < columns; j++) {
		field[i][j] = lines.get(0).split(" ")[j];
	    }
	    lines.remove(0);
	}
	firstLineArray = lines.get(0).split(" ");
	startx = Integer.parseInt(firstLineArray[0]) - 1;
	starty = Integer.parseInt(firstLineArray[1]) - 1;
	endx = Integer.parseInt(firstLineArray[2]) - 1;
	endy = Integer.parseInt(firstLineArray[3]) - 1;
	System.out.println(solve());
    }
    public static String solve() {
	isSolution(startx, starty, 0);
	return "" + solutions;
    }

    public static void isSolution (int x, int y, int t) {
	if (x == endx && y == endy && t <= second) {
	    ++solutions;
	    System.out.println(solutions);
	}
	if (!(x == rows || y == columns) && !(x == -1 || y == -1)) {
	    if (field[x][y].equals(".") && t <= second) {
		field[x][y] = "*";
		isSolution(x, y + 1, ++t);
		isSolution(x + 1, y, ++t);
		isSolution(x - 1, y, ++t);
		isSolution(x, y - 1, ++t);
	    }
	}
    }
}