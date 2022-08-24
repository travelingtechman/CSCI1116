package chapter17;

import java.io.*;
/**
 * 
 * @author ethan hunt
 * Date: 8/18/22
 *
 */

public class Exercise17_3 {
  public static void main(String[] args) {
    int num = 0;

    fileMaker();
    
    try(
      DataInputStream dis = new DataInputStream(new FileInputStream("Exercise17_03.dat"));
    ) {
      while (true) {
       
        	num += dis.readInt();
        
      }
    }
    catch (EOFException eof) {
      System.out.println("file read.");
      System.out.println(num + " ");
    }
    catch (IOException ioe) {
      ioe.printStackTrace();
    }
    
  
    
  }
  public static void fileMaker() {
	  try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("Exercise17_03.dat"));) {
			for (int i = 1; i <= 100; i++) {
				dos.writeInt((int)(Math.random()*100));
			}	
		}
		 catch(IOException ioe) {
			
			 ioe.printStackTrace();
			 }
		 }
}

