import java.util.*;
import java.lang.NullPointerException;
import java.io.*;
public class Mazesolver{

    private char[][]maze;
    private int maxx, maxy;
    private int startx, starty;
    private int endx, endy;
    private ArrayList<Point> solution;
    private Frontier rest;

    public static void main(String[] args) {
	
	Mazesolver a = new Mazesolver(args[0]);
	a.solve(0);
	System.out.println(a);
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
	for(int i=0;i<ans.length();i++){
	    char c = ans.charAt(i);
	    maze[i%maxx][i/maxx]= c;
	    if(c=='E'){
		endx = i%maxx;
		endy = i/maxx;
	    }
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
    
    public String toString() {
	String ans = "";
	for (int i = 0; i < maze.length; i++) {
	    for (int j = 0; j < maze[i].length; j++) {
		ans = ans + maze[i][j];
	    }
	    ans = ans + "\n";
	}
	for (int i = 0; i < solution.size(); i++) {
	    ans += solution.get(i).toString();
	}
	return hide() + clear() + invert() + go(0, 0) + ans;
    }
    public String toString(boolean animate) {
	String ans = "";
	for (int i = 0; i < maze.length; i++) {
	    for (int j = 0; j < maze[i].length; j++) {
		ans = ans + maze[i][j];
	    }
	    ans = ans + "\n";
	}
	return hide()+clear()+invert()+go(0,0)+ans+"\n"+show();
    }
    
    public boolean solve(int mode){
	boolean animate = true;
	rest = new Frontier(mode);
	Point start = new Point(startx, starty);

	rest.add(start);

	boolean solved = false;
	try {
	    while(!solved && rest.hasNext()){
		if(animate && !solved) {
		    wait(100);
		    System.out.println(toString(true));
		}
		Point next = rest.remove();
		if (!(next.getX() < 0 || next.getX() > maze.length || next.getY() < 0 || next.getY() > maze[0].length)) {
		    if(endx == next.getX() && endy == next.getY()) {
			System.out.println("Ran solved");
			addCoordinatesToSolutionArray(next);
		    	solved = true;
		    }
		    else if (maze[next.getX()][next.getY()] == '?' || maze[next.getX()][next.getY()] == 'S') {
			maze[next.getX()][next.getY()]='x';
			for(Point p : getNeighbors(next)) {
			    if (p != null) {
				rest.add(p);
				maze[p.getX()][p.getY()] = '?';
			    }
			}
		    }
		}
	    }
	}
	catch (NullPointerException e) {
	    return false;
	}
	return true;
     }

    public Point[] getNeighbors(Point p) {
	Point[] neighbors = new Point[4];
	if (maze[p.getX() - 1][p.getY()] != '#' && maze[p.getX() - 1][p.getY()] != '?' && maze[p.getX() - 1][p.getY()] != 'x') {
	    neighbors[0] = new Point(p.getX() - 1, p.getY(), p);
	    
	}
	if (maze[p.getX() + 1][p.getY()] != '#' && maze[p.getX() + 1][p.getY()] != '?' && maze[p.getX() + 1][p.getY()] != 'x') {
	    neighbors[1] = new Point(p.getX() + 1, p.getY(), p);
		
	}
	if (maze[p.getX()][p.getY() + 1] != '#' && maze[p.getX()][p.getY() + 1] != '?' && maze[p.getX()][p.getY() + 1] != 'x') {
	    neighbors[2] = new Point(p.getX(), p.getY() + 1, p);
	
	}
	if (maze[p.getX()][p.getY() - 1] != '#' && maze[p.getX()][p.getY() - 1] != '?' && maze[p.getX()][p.getY() - 1] != 'x') {
	    neighbors[3] = new Point(p.getX(), p.getY() - 1, p);
	    
	}
	return neighbors;
    }

    public void addCoordinatesToSolutionArray(Point p) {
	solution = new ArrayList<Point>();
	solution.add(p);
	while (p.hasNext()) {
	    solution.add(p.previousPoint());
	    maze[p.getX()][p.getY()] = 'P';
	    p = p.previousPoint();
	}
	maze[p.getX()][p.getY()] = 'P';
	Collections.reverse(solution);
    }

}
