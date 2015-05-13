import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
	Scanner console = new Scanner(System.in);
        RunningMedian a = new RunningMedian();
        String input = "";
        while(!input.equals("quit")) {
            input = console.next();
            if (input.equals("add")) {
                a.add(Integer.parseInt(console.next()));
                System.out.println(a);
            }
            else if (input.equals("get")) {
                a.getMedian();
                System.out.println(a);
            }
        }	
    }
}