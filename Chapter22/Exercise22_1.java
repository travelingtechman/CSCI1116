package chapter22;

import java.util.LinkedList;
import java.util.Scanner;

public class Exercise22_1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		LinkedList<Character> m = new LinkedList<>();
		LinkedList<Character> l = new LinkedList<>();

		System.out.print("Enter a string: ");
		String string = input.nextLine(); 
		for (int i = 0; i < string.length(); i++) { 		
			if (l.size() > 1 && string.charAt(i) <= l.getLast() && 
					l.contains(string.charAt(i))) {
				l.clear();
			}
			l.add(string.charAt(i));
			if (l.size() > m.size()) { 
				m.clear();
				m.addAll(l);
			}
		}
		for (Character ch: m) {
			System.out.print(ch);
		}
		System.out.println();
	}
}
