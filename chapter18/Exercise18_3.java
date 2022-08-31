package chapter18;

/**
 * @author Ethan Hunt
 * 8/31/22
 */
import java.util.Scanner;
public class Exercise18_3 {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter 2 nonnegative integers: ");

		int n = input.nextInt();
		int m = input.nextInt();
		int gcd = gcd(n,m);	    
		// Display factorial 
		System.out.printf("the gcd of %d and %d is %d.",n,m,gcd);
		}
			    

	public static int gcd(int n,int m) {
		if(m != 0) {                                                        
			return gcd(m, n % m);
		} else 
			
			return n ; 
		
	}
	}