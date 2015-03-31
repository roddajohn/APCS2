import java.util.*;
import java.io.*;
import java.util.Deque;

public class Mazesolver{

    private char[][]maze;
    private int maxx,maxy;
    private int startx,starty;

    public static void main(String[] args) {
	Mazesolver x = new Mazesolve("data1.dat");
	x.solveBFS();
	System.out.println(x);
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
    
    public void solveBFS() {
	Queue<Point> points = new Queue<Point>();
	points.add(new Point(startx, starty));
	boolean run = true;
	while(run) {
	    Point temp = points.remove();
	    if (!(maze[temp.getX()][temp.getY()] == '#') && !(maze[temp.getX()][temp.getY()] == '*')) {
		if(maze[temp.getX()][temp.getY()] == 'E') {
		    run = false;
		}
		points.add(new Point(temp.getX() + 1, temp.getY()));
		points.add(new Point(temp.getX() - 1, temp.getY()));
		points.add(new Point(temp.getX(), temp.getY() + 1));
		points.add(new Point(temp.getX(), temp.getY() - 1));
		maze[temp.getX()][temp.getY()] = '*';
	    }
	}
	System.out.println(this);
    }

    public void solveDFS() {

    }
}
