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
		    System.out.print();
		}
	    }
	    System.out.println("");
	}
	return hide + go(0,0) + ans + "\n" + show;
    }

    public KnightsTour(int size){
	board = new String[size + 4][size + 4];
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		if ((1 - i >= 0 || board.length - i >= 0) && (1 - j >= 0 || board[i].length - j >= 0)) {
		    board[i][j] = "*";
		}
		if (i == 2 && j == 2) {
		    board[i][j] = "K";
		}
	    }
	}			
    }

    
    public void solve() {
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		if (board[i][j].equals("K")) {
		    solve(i, j, 0);
		}
	    }
	}			
    }

		
    public boolean solve(int x,int y,int currentMoveNumber){
	System.out.println(this);
	wait(20);
	if (currentMoveNumber == board.length * board.length - 1) {
	    return true;
	}
	if (board[x][y].equals(" ")) {
	    if (solve(x - 1, y + 2, ++currentMoveNumber) || solve(x + 1, y + 2, ++currentMoveNumber) || solve(x + 2, y - 1, ++currentMoveNumber) || solve(x + 2, y + 1, ++currentMoveNumber) || solve(x + 1, y + 2, ++currentMoveNumber) || solve(x - 1, y + 2, ++currentMoveNumber) || solve(x - 2, y + 1, ++currentMoveNumber) || solve(x - 2, y - 1, ++currentMoveNumber)) {
		board[x][y] = "" + currentMoveNumber;
	    }
	}
	return false;
    }
    public static void main(String[] arrrrrrrr) {
	KnightsTour k = new KnightsTour(6);
	k.solve();	
    }
}