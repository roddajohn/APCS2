import java.util.*;
import java.io.*;

public class nQueens{

    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";
    boolean debug = false;

    private String[][]board;

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

    public nQueens(int size){
	board = new String[size][size];
	System.out.println("Instantiated board");
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		if (j == 0 /*&& i == 0*/) {
		    board[i][j] = "Q";
		}
		else {
		    board[i][j] = "_";
		}
	    }
	}
	System.out.println(this);			
    }

    
    public void solve() {
	solve(0, 0);
    }

		
    public boolean solve(int x,int y){
	
	try {
	    String lol = board[x][y];
	}
	catch (IndexOutOfBoundsException e) {
	    return false;
	}
	board[x][y] = "Q";
	if (debug) {
	    System.out.println(this);
	    wait(200);
	}
      	if (boardDone()) {
	    return true;
	}
	if (solve(x, y + 1)) {
	    return true;
	}
	board[x][y] = "_";
	if (solve(x + 1, y)) {
	    return true;
	}
	
	return false;
    }

    public void setDebug(boolean b) {
	debug = b;
    }

    public boolean boardDone() {
	boolean done = true;
	boolean doneCounter = false;
	int counter = 0;
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		if (board[i][j].equals("Q")) {
		    counter++;
		}
	    }
	}
	if (counter == board.length - 1) {
	    doneCounter = true;
	}
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		if (board[i][j].equals("Q")) {
		    if (isQueenDiagonally(i, j) || isQueenInStraightLines(i, j)) {
			done = false;
		    }
		}
	    }
	}
	return done && doneCounter;
    }

    public boolean isQueenInStraightLines(int x, int y) {
	for (int i = 0; i < board[x].length; i++) {
	    if (board[x][i].equals("Q") && i != y) {
		return true;
	    }
	}
	for (int i = 0; i < board.length; i++) {
	    if (board[i][y].equals("Q") && x != i) {
		return true;
	    }
	}
	return false;
    }
    public boolean isQueenDiagonally(int x, int y) {
	try {
	    String lol = board[x][y];
	}
	catch (IndexOutOfBoundsException e) {
	    return true;
	}

	if(board[x][y].equals("Q")) {
	    return false;
	}
	else if (isQueenDiagonally(x + 1, y + 1) && isQueenDiagonally(x - 1, y + 1) && isQueenDiagonally(x - 1, y - 1) && isQueenDiagonally(x + 1, y - 1)) {
	    return true;
	}
	return false;
    }

    public static void main(String[] args) {
	System.out.println("In Main function");
	System.out.println(clear);	
	nQueens k = new nQueens(Integer.parseInt(args[0]));
	if (args[1].equals("y")) {
	    k.setDebug(true);
	}
	else {
	    k.setDebug(false);
	}
	k.solve();	
    }
}