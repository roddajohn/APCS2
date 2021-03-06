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
	int[][] fieldNew = new int[rows][columns];
	int[][] fieldOld = new int[rows][columns];
	fieldOld[startx][starty] = 1;
	printArr(fieldOld);
	System.out.println("That was the new array");
	for (int i = 0; i < second; i++) {
	    fieldNew = new int[rows][columns];
	    for (int j = 0; j < fieldOld.length; j++) {
		for (int k = 0; k < fieldOld[j].length; k++) {
		    int left = 0, right = 0, up = 0, down = 0;
		    try {
			if (field[j][k].equals(".")) {
			    left = fieldOld[j - 1][k];
			}
		    }
		    catch(Exception e) {}
		    try {
			if (field[j][k].equals(".")) {
			    right = fieldOld[j + 1][k];
			}
		    }
		    catch(Exception e) {}
		    try {
			if (field[j][k].equals(".")) {
			    up = fieldOld[j][k + 1];
			}
		    }
		    catch (Exception e) {}
		    try {
			if (field[j][k].equals(".")) {
			    down = fieldOld[j][k - 1];
			}
		    }
		    catch (Exception e) {}
		    fieldNew[j][k] = left + right + up + down;
		}
	    }
	    fieldOld = fieldNew;
	    printArr(fieldOld);
	    System.out.println("");
	}
	return "" + fieldOld[endx][endy];
    }

    public static void printArr(int[][] a) {
	for (int i = 0; i < a.length; i++) {
	    for (int j = 0; j < a[i].length; j++) {
		System.out.print(a[i][j] + " ");
	    }
	    System.out.println("");
	}
    }
}