package finalProject1;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 * 
 * @author ethan hunt
 * 
 *
 */

public class FinalMainGui extends Application {
	static String roomDescription;
	static String buttonDescriptions;
	
	static MustyCavern musty = new MustyCavern();
	static AncientLibrary library = new AncientLibrary();
	static ForgottenTomb tomb = new ForgottenTomb();

	int II = 0;
	int playerChoiceGlobal ;
	Player player = new Player(10,2);
	@Override // Override the start method in the Application class
	
	public void start(Stage primaryStage) {
		
		Text healthTxt = new Text("Current Player Health" + player.getHealth());// make this do somthing!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		TextArea txt = new TextArea("Welcome to the my game! If the game closes after selecting an option that means you died instantly! \n     Select Start to begin\n\n" );
		txt.setEditable(false);
		txt.setPrefSize(925, 600);
		//Text health = new Text();
		Button choice0 = new Button("0");
		//choice0.setPrefSize(15, 25);
		choice0.setOnAction(e->{
			playerChoiceGlobal = 0;
		});
		Button choice1 = new Button("1");
		//choice1.setPrefSize(15, 25);
		choice1.setOnAction(e->{
			playerChoiceGlobal = 1;
		});
		Button choice2 = new Button("2");
		//choice2.setPrefSize(15, 25);
		choice2.setOnAction(e->{
			playerChoiceGlobal = 2;
		});

		Button start = new Button("start");
		start.setOnAction(buttonClicked->{
			txt.clear();
			start.setVisible(false);
			mustyCavGuiOverride(II, txt, player, choice0, choice1, choice2, healthTxt);
		});

		HBox hb4Health = new HBox(healthTxt);
		HBox hbox4txt = new HBox(250);
		HBox hbox4ChoiceButtons = new HBox(15);
		HBox hb4StartButt = new HBox(10);

		hb4StartButt.getChildren().add(start);
		hbox4txt.getChildren().add(txt);
		hbox4ChoiceButtons.getChildren().addAll(choice0,choice1,choice2);
		
		hb4Health.setAlignment(Pos.CENTER_LEFT);
		hb4StartButt.setAlignment(Pos.CENTER);
		hbox4txt.setAlignment(Pos.TOP_CENTER);
		hbox4ChoiceButtons.setAlignment(Pos.BOTTOM_CENTER);

		BorderPane bPane = new BorderPane();
		bPane.setBottom(hbox4ChoiceButtons);
		bPane.setTop(hbox4txt);
		bPane.setCenter(hb4StartButt);
		bPane.setLeft(hb4Health);

		Scene scene = new Scene(bPane, 1000,1000);

		primaryStage.setTitle("MyJavaFX"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

	}

	public static void main(String[] args){
		launch(args);
	}

	/**
	 * 
	 * @param i: int, it is a place holder for the global II value
	 * @param txt: TextArea: the text that is displayed on the stage
	 * @param player: Player: acts as a placeholder for the global Player object
	 * @param choice0: Button: displays the given text for the first option and causes the program to either end or move to the next room if selected
	 * @param choice1: Button: displays the given text for the first option and causes the program to either end or move to the next room if selected
	 * @param choice2: Button: displays the given text for the first option and causes the program to either end or move to the next room if selected
	 * @param healthTxt: Text: displays the users health onto the gui
	 */
	public void mustyCavGuiOverride(int i, TextArea txt , Player player, Button choice0, Button choice1, Button choice2, Text healthTxt) {
		choice0.setVisible(true);
		choice1.setVisible(true);
		choice2.setVisible(true);
		txt.appendText(musty.roomDescription());
		choice0.setText(musty.choice0);
		choice1.setText(musty.choice1);
		choice2.setText(musty.choice2);
		if(player.getHealth()> 0) {
			choice0.setOnAction(buttonPushed->{
				playerChoiceGlobal = 0;
				player.setHealth(player.getHealth()-4);
				txt.appendText(musty.choiceDescription0());
				II++;
				System.out.println(player.getHealth());
				healthTxt.setText("Current Player Health" + player.getHealth());
				ancientLibraryLoop(II, txt, player, choice0, choice1, choice2, healthTxt);
			});
			choice1.setOnAction(buttonPushed->{
				playerChoiceGlobal = 1;
				player.setHealth(player.getHealth()-1);
				txt.appendText(musty.choiceDescription1());
				II++;
				System.out.println(player.getHealth());
				healthTxt.setText("Current Player Health" + player.getHealth());
				ancientLibraryLoop(II, txt, player, choice0, choice1, choice2, healthTxt);
			});
			choice2.setOnAction(buttonPushed->{
				playerChoiceGlobal = 2;
				player.setHealth(player.getHealth()-2);
				txt.appendText(musty.choiceDescription2());
				II++;
				System.out.println(player.getHealth());
				healthTxt.setText("Current Player Health" + player.getHealth());
				ancientLibraryLoop(II, txt, player, choice0, choice1, choice2, healthTxt);
			});

		} else if(player.getHealth()<= 0) {
			endGameSequince(player,txt, choice0, choice1, choice2, healthTxt);
		}
	}
	/**
	 * 
	 * @param i: int, it is a place holder for the global II value
	 * @param txt: TextArea: the text that is displayed on the stage
	 * @param player: Player: acts as a placeholder for the global Player object
	 * @param choice0: Button: displays the given text for the first option and causes the program to either end or move to the next room if selected
	 * @param choice1: Button: displays the given text for the first option and causes the program to either end or move to the next room if selected
	 * @param choice2: Button: displays the given text for the first option and causes the program to either end or move to the next room if selected
	 * @param healthTxt: Text: displays the users health onto the gui
	 */
	public void ancientLibraryLoop(int i, TextArea txt , Player player, Button choice0, Button choice1, Button choice2, Text healthTxt) {
		
		choice0.setVisible(true);
		choice1.setVisible(true);
		choice2.setVisible(true);
		txt.appendText(library.roomDescription());
		choice0.setText(library.choice0);
		choice1.setText(library.choice1);
		choice2.setText(library.choice2);
		if(player.getHealth()> 0) {	
			choice0.setOnAction(buttonPushed->{
				playerChoiceGlobal = 0;
				txt.appendText(library.choiceDescription0());
				II++;
				endGameSequince(player,txt, choice0, choice1, choice2, healthTxt);
				healthTxt.setText("Current Player Health" + player.getHealth());
				ForgottenTombLoop(II, txt, player, choice0, choice1, choice2, healthTxt);
			});
			choice1.setOnAction(buttonPushed->{
				playerChoiceGlobal = 1;
				player.setHealth(player.getHealth()-10); 
				txt.appendText(library.choiceDescription1());
				II++;
				endGameSequince(player,txt, choice0, choice1, choice2, healthTxt);
				healthTxt.setText("Current Player Health" + player.getHealth());
				ForgottenTombLoop(II, txt, player, choice0, choice1, choice2, healthTxt);
			});
			choice2.setOnAction(buttonPushed->{
				playerChoiceGlobal = 2;
				player.setHealth(player.getHealth()-5);
				txt.appendText(library.choiceDescription2());
				II++;
				endGameSequince(player,txt, choice0, choice1, choice2, healthTxt);
				healthTxt.setText("Current Player Health" + player.getHealth());
				ForgottenTombLoop(II, txt, player, choice0, choice1, choice2, healthTxt);
			});
		} else {
			endGameSequince(player,txt, choice0, choice1, choice2, healthTxt);		
			}
	}
	/**
	 * 
	 * @param i: int, it is a place holder for the global II value
	 * @param txt: TextArea: the text that is displayed on the stage
	 * @param player: Player: acts as a placeholder for the global Player object
	 * @param choice0: Button: displays the given text for the first option and causes the program to either end or move to the next room if selected
	 * @param choice1: Button: displays the given text for the first option and causes the program to either end or move to the next room if selected
	 * @param choice2: Button: displays the given text for the first option and causes the program to either end or move to the next room if selected
	 * @param healthTxt: Text: displays the users health onto the gui
	 */
	public void ForgottenTombLoop(int i, TextArea txt , Player player, Button choice0, Button choice1, Button choice2, Text healthTxt) {

		choice0.setVisible(true);
		choice1.setVisible(true);
		choice2.setVisible(true);
		txt.appendText(tomb.roomDescription());
		choice0.setText(tomb.choice0);
		choice1.setText(tomb.choice1);
		choice2.setText(tomb.choice2);
		if(player.getHealth()> 0) {
			choice0.setOnAction(buttonPushed->{
				playerChoiceGlobal = 0;
				player.setHealth(player.getHealth()-10);
				txt.appendText(tomb.choiceDescription0());
				healthTxt.setText("Current Player Health" + player.getHealth());
				II++;
				endGameSequince(player,txt, choice0, choice1, choice2, healthTxt);
				
			});
			choice1.setOnAction(buttonPushed->{
				playerChoiceGlobal = 1;
				player.setHealth(player.getHealth()-0); //fix this
				txt.appendText(tomb.choiceDescription1());
				healthTxt.setText("Current Player Health" + player.getHealth());
				II++;
				endGameSequince(player,txt, choice0, choice1, choice2, healthTxt);
				
			});
			choice2.setOnAction(buttonPushed->{
				playerChoiceGlobal = 2;
				player.setHealth(player.getHealth()-10); 
				txt.appendText(tomb.choiceDescription2());
				healthTxt.setText("Current Player Health" + player.getHealth());
				II++;
				endGameSequince(player,txt, choice0, choice1, choice2, healthTxt);
				
			});
		} else {
			endGameSequince(player,txt, choice0, choice0, choice2, healthTxt);
		}
	}
	/**
	 * 
	 * @param i: int, it is a place holder for the global II value
	 * @param txt: TextArea: the text that is displayed on the stage
	 * @param player: Player: acts as a placeholder for the global Player object
	 * @param choice0: Button: displays the given text for the first option and causes the program to either end or move to the next room if selected
	 * @param choice1: Button: displays the given text for the first option and causes the program to either end or move to the next room if selected
	 * @param choice2: Button: displays the given text for the first option and causes the program to either end or move to the next room if selected
	 * @param healthTxt: Text: displays the users health onto the gui
	 */
	public void endGameSequince(Player player, TextArea txt, Button choice0, Button choice1, Button choice2, Text healthTxt) {
		if(player.getHealth()<=0) {
			txt.appendText("You died... L \nRestart the program to play again");
			choice0.setVisible(false);
			choice2.setVisible(false);
			choice1.setText("Restart??");
			choice1.setOnAction(RestartButton->{
				//txt.clear();
				System.exit(0);
				
			});
			//}
		} else if((player.getHealth() > 0) && (II == 3)){
			txt.appendText("YOU WIN:)!!!!!!");
			choice0.setVisible(false);
			choice2.setVisible(false);
			choice1.setText("Restart??");
			choice1.setOnAction(RestartButton->{
				//txt.setText("");
				System.exit(0);
				
			});
		} else {
			
		}
	}
	
}
