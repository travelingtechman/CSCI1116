import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * 
 * @author ethan hunt
 * Date: 8/17/2022
 *
 */
public class Exercise16_1 extends Application {
	protected Text text = new Text(50, 50, "Programmig is Fun");
	protected BorderPane getPane() {
	HBox paneForButtons = new HBox(20);
	HBox paneForRadioButtons = new HBox(15);
	Button btLeft = new Button("Left");
	Button btRight = new Button("Right");
	paneForButtons.getChildren().addAll(btLeft, btRight);
	paneForButtons.setAlignment(Pos.CENTER);
	paneForButtons.setStyle("-fx-border-color: green");
	
	RadioButton redBut = new RadioButton("Red");
	RadioButton yelBut = new RadioButton("Yellow");
	RadioButton blaBut = new RadioButton("Black");
	RadioButton oraBut = new RadioButton("Orange");
	RadioButton greBut = new RadioButton("Green");
	ToggleGroup group = new ToggleGroup();
	redBut.setToggleGroup(group);
	yelBut.setToggleGroup(group);
	blaBut.setToggleGroup(group);
	oraBut.setToggleGroup(group);
	greBut.setToggleGroup(group);
	redBut.setOnAction(e -> {
		if (redBut.isSelected()) {
			text.setFill(Color.RED);
		}
		});
	yelBut.setOnAction(e -> {
		if (yelBut.isSelected()) {
			text.setFill(Color.YELLOW);
		}
		});
	blaBut.setOnAction(e -> {
		if (blaBut.isSelected()) {
			text.setFill(Color.BLACK);
		}
		});
	oraBut.setOnAction(e -> {
		if (oraBut.isSelected()) {
			text.setFill(Color.ORANGE);
		}
		});
	greBut.setOnAction(e -> {
		if (greBut.isSelected()) {
			text.setFill(Color.GREEN);
		}
		});
	paneForRadioButtons.getChildren().addAll(redBut,yelBut,blaBut,oraBut,greBut);
	paneForRadioButtons.setAlignment(Pos.TOP_CENTER);
	
	
	BorderPane pane = new BorderPane();
	pane.setBottom(paneForButtons);
	pane.setTop(paneForRadioButtons);
	Pane paneForText = new Pane();
	paneForText.getChildren().add(text);
	pane.setCenter(paneForText);
	btLeft.setOnAction(e ->{ 
		if(text.getX()> 0) {  text.setX(text.getX()-10);
	
	}
	});
	
	btRight.setOnAction(e ->{ 
		if(text.getX() <= 290) {
			text.setX(text.getX() + 10.0);
		}
	});
	return pane;
	}
	
	@Override 
	public void start(Stage primaryStage) {
		Scene scene = new Scene(getPane(), 400, 400);
		
		
		primaryStage.setTitle("Exercise16_1"); 
		primaryStage.setScene(scene); 
		primaryStage.show();
	}
		   
	void main(String[] args) {
		launch(args);
		}	
	
}

