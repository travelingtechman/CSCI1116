package chapter17;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * 
 * @author ethan hunt
 *
 */
public class Exercise17_1 {
	public static void main(String[] args) {
		
		try(PrintWriter print = new PrintWriter(new FileOutputStream(new File("Exercise17_01.txt"),true));) {
			for (int i = 1; i <= 100; i++) {
				print.print((int)(Math.random()*100) + " ");
			}	
		}
		 catch(FileNotFoundException FNF) {
			 System.out.println("No shot champ.");
			 FNF.printStackTrace();
			 }
		 }
	}

