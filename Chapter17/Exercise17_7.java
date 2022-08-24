package chapter17;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ethan Hunt
 */


import java.io.*;

public class Exercise17_7 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Loan loan1 = new Loan();
        Loan loan2 = new Loan(1.8, 10, 10000);
        
        try (
             ObjectInputStream input = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream("Exercise17_07.dat")))
        ) {
            while (true) {
            	outputData(input);
            	            }
        } 
       
        catch (EOFException e) {
        	System.out.println("END OF FILE");
        }
       
    }
    public static void outputData(ObjectInputStream input) throws ClassNotFoundException, IOException {
    	Loan L = (Loan)input.readObject();
    	System.out.println(L);
    	System.out.printf("The total loan payment is : $%.2f\n" , L.getTotalPayment());
    	System.out.println();

    }
}
