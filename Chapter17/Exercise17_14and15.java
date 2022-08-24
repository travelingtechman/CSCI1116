package chapter17;

import java.io.*;
import java.util.Scanner;

public class Exercise17_14and15 {

	public static void main(String[] args) throws IOException  {

	//	String outPutFileName = scan.next();
		int i = 0;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("enter 1 to encrypt or 2 to decrypt ");
		int user = scan.nextInt();
		
		if(user == 1) {
			System.out.println("Please enter the name of the file to be encrypted");
			String encryptedFIle = scan.next();
			System.out.println("please enter the new name of the encrypted file");
			String fileName = scan.next();
		
			try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(
					"C:\\Users\\ethan\\eclipse-workspace\\CSCI_1112\\src\\chapter17\\" + (encryptedFIle) + ".txt"));
			
				BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(
						"C:\\Users\\ethan\\eclipse-workspace\\CSCI_1112\\src\\chapter17\\" + (fileName) + ".txt"));
				
		) {		
			int r = 0;
		
			while((r = input.read()) != -1) {
				output.write(r+5);	
			}
		}
			catch (EOFException e) {
				System.out.println("end of file reached");
			}
		}else if(user == 2) {
			System.out.println("Please enter the name of the file to be decrypted");
			String encryptedFIle = scan.next();
			System.out.println("please enter the new name of the decrypted file");
			String fileName = scan.next();
			
			try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(
				"C:\\Users\\ethan\\eclipse-workspace\\CSCI_1112\\src\\chapter17\\" + (encryptedFIle) + ".txt"));
				
				BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(
					"C:\\Users\\ethan\\eclipse-workspace\\CSCI_1112\\src\\chapter17\\" + (fileName) + ".txt"));
					
			) {		
				int r = 0;
			
				while((r = input.read()) != -1) {
					output.write(r-5);	
				}
			}
				catch (EOFException e) {
					System.out.println("end of file reached");
				}
			}
	}
	
	}

