import java.util.*;
import java.io.*;

public class ctravel1 {

    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";
    boolean debug = false;

    static int solution = 0;
    static int maxSeconds = 0;

    private String[][]board;

    public String name() {
	return "john.rodda";
    }

    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }

    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
      
	}
    }

    public String toString(){
	String ans = "\n";
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		ans = ans + board[i][j] + "   ";    
	    }
	    ans = ans + "\n";
	}
	return hide + go(0,0) + ans + "\n" + show;
    }

    public ctravel1(int x, int y, int ex, int ey){
	solve(x, y, 0, ex, ey);
	System.out.println(solutions);
    }
		
    public void solve(int x,int y, int time, int ex, int ey){
	if (debug) {
	    System.out.println(this);
	    wait(50);
	}

	if (x == ex && y == ey && time <= seconds) {
	    ++solutions;
	    return;
	}

	try {
	    String a = board[x][y];
	}

	catch (IndexOutOfBoundsException e) {
	    return;
	}
      	
	if (board[x][y].equals(".") && time < seconds) {
	    solve(x + 1, y, time + 1, ex, ey);
	    solve(x, y - 1, time + 1, ex, ey);
	    solve(x - 1, y, time + 1, ex, ey);
	    solve(x, y + 1, time + 1, ex, ey);
	}

	return;
    }

    public void setDebug(boolean b) {
	debug = b;
    }

    public static void main(String[] args) {
	System.out.println("In Main function");
	System.out.println(clear);
	List<String> lines = Files.readAllLines(Paths.get("ctravel.in"), StandardCharsets.UTF_8);
        String[] firstLineArray = lines.get(0).split(" ");
        int rows = Integer.parseInt(firstLineArray[0]);
        int columns = Integer.parseInt(firstLineArray[1]);
        second = Integer.parseInt(firstLineArray[2]);
        board = new String[rows][columns];
        lines.remove(0);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = lines.get(0).split(" ")[j];
            }
            lines.remove(0);
        }
        firstLineArray = lines.get(0).split(" ");
        int startx = Integer.parseInt(firstLineArray[0]) - 1;
        int starty = Integer.parseInt(firstLineArray[1]) - 1;
        int endx = Integer.parseInt(firstLineArray[2]) - 1;
        int endy = Integer.parseInt(firstLineArray[3]) - 1;
	ctravel1 k = new ctravel1(startx, starty, endx, endy);
	if (args[0].equals("y")) {
	    k.setDebug(true);
	}
	else {
	    k.setDebug(false);
	}  
    }
}