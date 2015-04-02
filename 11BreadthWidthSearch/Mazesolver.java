import java.util.*;
import java.lang.NullPointerException;
import java.io.*;
public class Mazesolver{

    private char[][]maze;
    private int maxx,maxy;
    private int startx,starty;

    public static void main(String[] args) {
	
	Mazesolver a = new Mazesolver(args[0]);
	System.out.println(a.clear());
	a.BFS(false);
	System.out.println(a.clear());
	//	Mazesolver b = new Mazesolver(args[0]);
	//	b.DFS(true);
    }

    public Mazesolver(String filename){
	startx = -1;
	starty = -1;
	String ans = "";
	try{
	    Scanner in = new Scanner(new File(filename));
	    
	    //keep reading next line
	    while(in.hasNext()){
		String line= in.nextLine();
		if(maxy==0){
		    //calculate width of the maze
		    maxx=line.length();
		}
		//every new line add 1 to the height of the maze
		maxy++;
		ans+=line;
	    }
	}
	catch(Exception e){
	    System.out.println("File: "+filename+" could not be opened.");
	    e.printStackTrace();
	    System.exit(0);
	}
	
	maze = new char[maxx][maxy];
	for(int i=0;i<ans.length();i++){
	    char c = ans.charAt(i);
	    maze[i%maxx][i/maxx]= c;
	    if(c=='S'){
		startx = i%maxx;
		starty = i/maxx;
	    }
	}
    }

    public boolean BFS(boolean animate) {
	try {
	    MyDoubleEndedQueue<Point> moves = new MyDoubleEndedQueue<Point>();
	    boolean run = true;
	    moves.addLast(new Point(startx, starty));
	    while (run) {
		if (animate) {
		    System.out.println(this);
		    wait(100);
		}
		//	    System.out.println(moves);
		Point checking = moves.removeFirst();
		//		System.out.println(checking);
		int x = checking.getX();
		int y = checking.getY();
		if (maze[x][y] == 'E') {
		    run = false;
		}
		else if (maze[x][y] == ' ' || maze[x][y] == 'S') {
		    moves.addLast(new Point(x + 1, y));
		    moves.addLast(new Point(x - 1, y));
		    moves.addLast(new Point(x, y + 1));
		    moves.addLast(new Point(x, y - 1));
		    maze[x][y] = 'x';
		}
	    }
	    System.out.println(this);
	    System.out.println(moves);
	    return true;
	}
	catch (NullPointerException e) {
	    return false;
	}
    }

    public boolean DFS(boolean animate) {
	try {
	    MyDoubleEndedQueue<Point> moves = new MyDoubleEndedQueue<Point>();
	    boolean run = true;
	    moves.addLast(new Point(startx, starty));
	    while (run) {
		if (animate) {
		    System.out.println(this);
		    wait(100);
		}
		System.out.println(moves);
		Point checking = moves.removeLast();
		//          System.out.println(checking);
		int x = checking.getX();
		int y = checking.getY();
		if (maze[x][y] == 'E') {
		    run = false;
		}
		else if (maze[x][y] == ' ' || maze[x][y] == 'S') {
		    moves.addLast(new Point(x + 1, y));
		    moves.addLast(new Point(x - 1, y));
		    moves.addLast(new Point(x, y + 1));
		    moves.addLast(new Point(x, y - 1));
		    maze[x][y] = 'x';
		}
	    }
	    System.out.println(this);
	    System.out.println(moves);
	    return true;
	}
	catch (NullPointerException e) {
	    return false;
	}
    }    
    
    
    private String go(int x,int y){
	return ("["+x+";"+y+"H");
    }
    
    private String clear(){
	return  "[2J";
    }
    
    private String hide(){
	return  "[?25l";
    }
    
    private String show(){
	return  "[?25h";
    }
    private String invert(){
	return  "[37";
    }
    
    
    
    public void clearTerminal(){
	System.out.println(clear());
    }
    
    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }
    
    public String toString(){
	String ans = ""+maxx+","+maxy+"\n";
	for(int i=0;i<maxx*maxy;i++){
	    if(i%maxx ==0 && i!=0){
		ans+="\n";
	    }
	    ans += maze[i%maxx][i/maxx];
	}
	return hide()+invert()+go(0,0)+ans+"\n"+show();
    }
    
    public boolean solve(){
	if(startx < 0){
	    System.out.println("No starting point 'S' found in maze.");
	    return false;				
	}else{
	    maze[startx][starty]=' ';
	    return solve(startx,starty);
	}
    }
    
    public boolean solve(int x,int y){
	System.out.println(this);
	wait(20);
	if (maze[x][y] == 'E') {
	    return true;
	}
	else if (maze[x][y] == ' ') {
	    maze[x][y] = '@';
	    if (solve(x + 1, y) || solve(x, y - 1) || solve(x - 1, y) || solve(x, y + 1)) {
		return true;
	    }
	    maze[x][y] = '.';
		}
	
	return false;
     }

}
