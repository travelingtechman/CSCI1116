package chapter19;

/*
Author: Ethan Hunt
Date: 9/1/22
Description: 
 */
import java.util.ArrayList;
public class Exercise19_3 {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(14);
    list.add(24);
    list.add(14);
    list.add(42);
    list.add(25);
    
    ArrayList<Integer> newList = removeDuplicates(list);
    
   System.out.print(newList);
  }
  public static ArrayList<Integer> removeDuplicates(ArrayList<Integer> list){
	  ArrayList<Integer> cloneList = new ArrayList<Integer>();
	  for(Integer element : list) {
		  if(!cloneList.contains(element)) {
			  cloneList.add(element);
		  }
	  }
	  return cloneList;
  }
}
