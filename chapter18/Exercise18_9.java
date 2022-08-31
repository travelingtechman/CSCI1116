package chapter18;

import java.util.Scanner;

public class Exercise18_9 {
	public static void main(String args []) {
		Scanner scan = new Scanner(System.in);
		String value = scan.next();
		
		reverseDisplay(value);
		
		
	}

	public static void reverseDisplay(String value) {
		
		if(value.length() > 0 ) {
			String word = value.substring(value.length()-1);
			System.out.print(word);
			
		
			reverseDisplay(value.substring(0,(value.length()-1)));
		} else System.out.println("\ndone");
	}
}
