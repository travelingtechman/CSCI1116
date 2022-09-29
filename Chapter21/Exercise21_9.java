package chapter21;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise21_9 {
	public static void main(String[] args) {	
		Scanner input = new Scanner(System.in);
		Map<String, String> statesAndCapitals = getData();
		System.out.print("Enter a state: ");
		String state = input.nextLine();
		if (statesAndCapitals.get(state) != null) {
			System.out.println("The capital of " + state + " is " 
					+ statesAndCapitals.get(state));
		}
	}
	public static Map<String, String> getData() {
		Map<String, String> map = new HashMap<>();
		String[][] data = {
				{"Alabama", "Montgomery"},
				{"Alaska", "Juneau"},
				{"Arizona", "Phoenix"},
				{"Arkansas", "Little Rock"},
				{"California", "Sacramento"},
				{"Colorado", "Denver"}, 
				{"Connecticut", "Hartford"}, 
				{"Delaware", "Dover"},
				{"Florida", "Tallahassee"}, 
				{"Georgia", "Atlanta"},
				{"Hawaii", "Honolulu"}, {"Idaho", "Boise"},
				{"Illinois", "Springfield"},
				{"Indiana", "Indianapolis"},
				{"Iowa Des", "Moines"},
				{"Kansas", "Topeka"}, {"Kentucky","Frankfort"}, 
				{"Louisiana", "Baton Rouge"},
				{"Maine", "Augusta"}, 
				{"Maryland", "Annapolis"},
				{"Massachusetts", "Boston"}, 
				{"Michigan", "Lansing"},
				{"Minnesota", "Saint Paul"}, 
				{"Mississippi", "Jackson"},
				{"Missouri", "Jefferson City"}, 
				{"Montana", "Helena"},
				{"Nebraska", "Lincoln"}, 
				{"Nevada	", "Carson City"},
				{"New Hampshire", "Concord"}, 
				{"New Jersey", "Trenton"},
				{"New Mexico", "Santa Fe"}, 
				{"New York", "Albany"},
				{"North Carolina", "Raleigh"}, 
				{"North Dakota", "Bismarck"},
				{"Ohio", "Columbus"},
				{"Oklahoma", "Oklahoma City"},
				{"Oregon", "Salem"}, 
				{"Pennsylvania", "Harrisburg"},
				{"Rhode Island", "Providence"}, 
				{"South Carolina", "Columbia"}, 
				{"South Dakota", "Pierre"}, 
				{"Tennessee", "Nashville"}, 
				{"Texas", "Austin"}, 
				{"Utah", "Salt Lake City"}, 
				{"Vermont", "Montpelier"}, 
				{"Virginia", "Richmond"}, 
				{"Washington", "Olympia"}, 
				{"West Virginia", "Charleston"}, 
				{"Wisconsin", "Madison"}, 
				{"Wyoming", "Cheyenne"}};

		for (int i = 0; i < data.length; i++) {
			map.put(data[i][0], data[i][1]);
		}
		return map;
	}
}