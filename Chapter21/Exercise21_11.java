package chapter21;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise21_11 extends Application {
	final int BOYS_NAMES = 2;
	final int GIRLS_NAMES = 6;
	private static Map<String, Integer>[] mapForBoy = new HashMap[10];
	private static Map<String, Integer>[] mapForGirl = new HashMap[10];
	// Map[] boys = getNames(BOYS_NAMES);
	// Map[] girls = getNames(GIRLS_NAMES); 

	private Button btFindRanking = new Button("Find Ranking");
	private ComboBox<Integer> cboYear = new ComboBox<>();
	private ComboBox<String> cboGender = new ComboBox<>();
	private TextField tfName = new TextField();
	private Label lblResult = new Label();

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {

		GridPane gridPane = new GridPane();
		gridPane.add(new Label("Select a year:"), 0, 0);
		gridPane.add(new Label("Male or Female?"), 0, 1);
		gridPane.add(new Label("Enter a name:"), 0, 2);
		gridPane.add(cboYear, 1, 0);
		gridPane.add(cboGender, 1, 1);
		gridPane.add(tfName, 1, 2);
		gridPane.add(btFindRanking, 1, 3);
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setHgap(5);
		gridPane.setVgap(5);
		
		getNames();
		btFindRanking.setOnAction(e ->  getRank());
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(gridPane);
		borderPane.setBottom(lblResult);
		BorderPane.setAlignment(lblResult, Pos.CENTER);

		// Create a scene and place it in the stage
		Scene scene = new Scene(borderPane, 370, 160);
		primaryStage.setTitle("Exercise21_11"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

		for (int year = 2001; year <= 2010; year++) {
			cboYear.getItems().add(year);
		}
		cboYear.setValue(2001);

		cboGender.getItems().addAll("Male", "Female");
		cboGender.setValue("Male");




	}



	private void getRank() {
		int year = cboYear.getValue()-2001;
		String name = tfName.getText().trim();

		if (cboGender.getValue().equals("Male")) {
			if(mapForBoy[year].containsKey(name)) {
				lblResult.setText(name + " is ranked " + mapForBoy[year].get(name));			
			}
			else {
				lblResult.setText(name + " is not ranked for " + (year+2001));
			}
		}
		else {
			
				if(mapForGirl[year].containsKey(name)) {
					lblResult.setText(name + " is ranked " + mapForGirl[year].get(name));			
				}
				else {
					lblResult.setText(name + " is not ranked for " + (year+2001));
				}
			
		}
	}

	//private String getGender() {
	//	return cboGender.getValue().equals("Male") ? "boys" : "girls";
	//}

	private void getNames() {
		try {

			Map<String, String>[] array = new Map[10];

			for (int i = 0;  i < 10; i++) {
				//Map<String, String> map = new HashMap<>();

				// Read data from url

				java.net.URL url = new java.net.URL(
						"https://liveexample.pearsoncmg.com/data/babynamesranking" 
								+ (2001+i) + ".txt");

				// Create input file from url
				Scanner input = new Scanner(url.openStream());
				mapForBoy[i] = new HashMap<>();
				mapForGirl[i] = new HashMap<>();

				while (input.hasNext()) {
					int ranking = input.nextInt();
					String boyboy = input.next();
					input.nextInt();
					String girlgril = input.next();
					input.nextInt();

					mapForBoy[i].put(boyboy, ranking);
					mapForGirl[i].put(girlgril, ranking);
				} 
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	/**
	 * The main method is only needed for the IDE with limited
	 * JavaFX support. Not needed for running from the command line.
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
