import java.util.*;
import java.io.*;

public class NQueens{

    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";
    boolean debug = false;

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

    public NQueens(int size){
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
	System.out.println(this);
    }

    public boolean solve(int x) {
	if (debug) {
	    wait(100);
	    System.out.println(this);
	}

	if (x == board.length) {
	    return true;
	}
	for (int i = 0; i < board[x].length; i++) {
	    board[x][i] = "Q";
	    if (debug) {
		wait(100);
		System.out.println(this);
	    }
	    if (noQueenDiagonally(x, i) && noQueenLeftRight(x, i)) {
		if (solve(x + 1)) {
		    return true;
		}
	    }
	    board[x][i] = "_"; 
	}
	
	return false;
    }

    public void setDebug(boolean b) {
	debug = b;
    }

    public boolean noQueenDiagonally(int x, int y) {
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		if (Math.abs(i - x) == Math.abs(j - y) && board[i][j].equals("Q") && x != i && y != j) {
		    return false;
		}
	    }
	}
	return true;
    }

    public boolean noQueenLeftRight(int x, int y) {
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		if (i == x && board[i][j].equals("Q") && j != y) {
		    return false;
		}
		if (y == j && board[i][j].equals("Q") && i != x) {
		    return false;
		}
	    }
	}
	return true;
    }

    public static void main(String[] args) {
	System.out.println("In Main function");
	System.out.println(clear);	
	NQueens k = new NQueens(Integer.parseInt(args[0]));
	if (args[1].equals("y")) {
	    k.setDebug(true);
	}
	else {
	    k.setDebug(false);
	}
	k.solve();	
    }
}