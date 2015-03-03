import java.io.IOException;
import java.nio.file.*;
import java.nio.charset.*;
import java.util.*;

public class makelake {
    static int[][] ground;
    static int finalLakeElevation;
    static int rows;
    static int columns;

    public static String getPrintable() {
	String toReturn = "";
	for (int i = 0; i < ground.length; i++) {
	    for (int j = 0; j < ground[i].length; j++) {
		toReturn = toReturn + ("" + ground[i][j]) + "  ";
	    }
	    toReturn = toReturn + "\n";
	}
	return toReturn;
    }

    public static void main (String[] args) throws IOException {
	List<String> lines = Files.readAllLines(Paths.get("makelake.in"), StandardCharsets.UTF_8);
	String[] firstLineArray = lines.get(0).split(" ");
	rows = Integer.parseInt(firstLineArray[0]);
	columns = Integer.parseInt(firstLineArray[1]);
	finalLakeElevation = Integer.parseInt(firstLineArray[2]);
	lines.remove(0);
	ground = new int[rows][columns];
	for (int i = 0; i < rows; i++) {
	    for (int j = 0; j < columns; j++) {
		ground[i][j] = Integer.parseInt(lines.get(0).split(" ")[j]);
	    }
	    lines.remove(0);
	}
	for (int k = 0; k < lines.size(); k++) {
	    String[] currentLines = lines.get(k).split(" ");
	    stomp(Integer.parseInt(currentLines[0]) - 1, Integer.parseInt(currentLines[1]) - 1, Integer.parseInt(currentLines[2]));
	    System.out.println(getPrintable());
	}
	System.out.println(calculateVolume());
    }

    public static void stomp (int x, int y, int e) {
	int maxNumber = 0;
	for (int i = 0; i < 3; i++) {
	    for (int j = 0; j < 3; j++) {
		if (ground[i + x][j + y] > maxNumber) {
		    maxNumber = ground[i + x][j + y];
		}
	    }
	}
	for (int l = 0; l < e; l++) {
	    for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {
		    if (ground[i + x][j + y] == maxNumber) {
			ground[i + x][j + y]--;
		    }
		}
	    }
	    maxNumber--;
	}
    }

    public static double calculateVolume() {
	int numberOfCubicStuff = 0;
	for (int i = 0; i < ground.length; i++) {
	    for (int j = 0; j < ground[i].length; j++) {
		if (ground[i][j] < finalLakeElevation) {
		    numberOfCubicStuff += finalLakeElevation - ground[i][j];
		}
	    }
	}
	return numberOfCubicStuff * 72 * 72;
    }

}