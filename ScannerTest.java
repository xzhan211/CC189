import java.util.*;
import java.io.*;
//import java.lang.Exception;
public class ScannerTest{
	public static void main(String[] args) throws Exception{
		//Scanner sc = new Scanner(new File("q4p8.java")); // read input from a file
		Scanner sc = new Scanner(System.in); // read input from keyboard
		
		//sc.useDelimiter("\n");// use enter as end char.
		//use space as end char.

		while(sc.hasNext()){
			System.out.println(">> " + sc.next());
		}

		// while(sc.hasNextLine()){
		// 	System.out.println(">> " + sc.nextLine());
		// }
	}
}

// two kind of input method