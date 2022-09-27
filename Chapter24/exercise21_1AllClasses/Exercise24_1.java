package exercise21_1AllClasses;

public class Exercise24_1 {
	public static void main(String[] args) {

		new Exercise24_1();
	}
	public Exercise24_1() {
		String[] name1 = {"Tom", "George", "Peter", "Jean", "Jane"};
		String[] name2 = {"Tom", "George", "Michael", "Michelle", "Daniel"};
		MyList<String> list1 = new MyArrayList<>(name1); 
		MyList<String> list2 = new MyArrayList<>(name2);  
		System.out.println("created 2 arrays");
		System.out.println("list1:" + list1);
		System.out.println("list2:" + list2 + "\n");
		
		System.out.println("printed list1 and list2 after running list1.addAll(list2):");
		list1.addAll(list2);
		System.out.println("list1:" + list1);
		System.out.println("list2:" + list2 + "\n");
		
		System.out.println("printed list1 & list2 after remaking list1 and list2, and running list1.removeAll(list2)");
		list1.clear();
		list1.addAll(new MyArrayList<>(name1));
		list1.removeAll(list2);
		System.out.println("list1:" + list1);
		System.out.println("list2:" + list2 + "\n");

		System.out.println("printed list1 & list2 after remaking list1 and list2 and running list1.retainAll(list2)");
		list1.clear();
		list1.addAll(new MyArrayList<>(name1));
		list1.retainAll(list2);
		System.out.println("list1:" + list1);
		System.out.println("list2:" + list2 + "\n");
		
	}
}
