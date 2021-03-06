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
		
		board[i][j] = "_";
		
	    }
	}
	System.out.println(this);			
    }

    
    public void solve() {
	solve(0);
    }

    public boolean solve(int x) {
	if (debug) {
	    wait(200);
	    System.out.println(this);
	}
	
	
	return false;
    }

    public void setDebug(boolean b) {
	debug = b;
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
	boolean go = true;
	int i = 0;
	while (go) {
	    try {
		if (board[x + i][y + i].equals("Q")) {

		}
	    }
	    catch (ArrayIndexOutOfBoundsException e) {

	    }
	    try {
		if (board[x - i][y - i]
	}
	//Figure out how this check will work, everything else will work
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