import java.util.*;
import java.io.*;

public class KnightsTour{

    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";

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
		if (!board[i][j].equals("*")) {
		    ans = ans + board[i][j] + "   ";
		}
	    }
	    ans = ans + "\n";
	}
	return hide + go(0,0) + ans + "\n" + show;
    }

    public KnightsTour(int size){
	board = new String[size + 4][size + 4];
	System.out.println("Instantiated board");
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		if (i == 2 && j == 2) {
		    board[i][j] = "K";
		}
		else {
		    board[i][j] = "_";
		}
	    }
	}
	System.out.println(this);			
    }

    
    public void solve() {
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		if (board[i][j].equals("K")) {
		    solve(i, j, 0);
		}
	    }
	}
	System.out.println(this);			
    }

		
    public boolean solve(int x,int y,int currentMoveNumber){
	//System.out.println(this);
	//wait(20);
      	
	if (board[x][y].equals("_") || board[x][y].equals("K")) {
	    board[x][y] = "" + currentMoveNumber;
	    if (currentMoveNumber == (board.length - 4) * (board.length - 4) - 3) {
		return true;
	    }
	    if (solve(x - 1, y + 2, currentMoveNumber + 1) || 
		solve(x + 1, y + 2, currentMoveNumber + 1) || 
		solve(x + 2, y - 1, currentMoveNumber + 1) || 
		solve(x + 2, y + 1, currentMoveNumber + 1) || 
		solve(x + 1, y + 2, currentMoveNumber + 1) || 
		solve(x - 1, y + 2, currentMoveNumber + 1) || 
		solve(x - 2, y + 1, currentMoveNumber + 1) || 
		solve(x - 2, y - 1, currentMoveNumber + 1)) {
		board[x][y] = "" + currentMoveNumber;
		return true;
	    }
	    else {
		board[x][y] = "_";
	    }
	}
	return false;
    }
    public static void main(String[] arrrrrrrr) {
	System.out.println("In Main function");
	System.out.println(clear);	
	KnightsTour k = new KnightsTour(6);
	k.solve();	
    }
}