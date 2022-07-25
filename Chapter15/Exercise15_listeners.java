import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class Exercise15_listeners extends Application{
		@Override 
	public void start(Stage primaryStage) {                   
			Circle circle = new Circle(70.0, 30.0, 20.0);
			
			circle.setFill(Color.WHITE);
			circle.setStroke(Color.BLACK);
			
			Pane pane = new Pane();
			pane.getChildren().add(circle);
			BorderPane bPane = new BorderPane();
			
			HBox hbox = new HBox(5);
			hbox.setAlignment(Pos.CENTER);
		
			Button btLeft = new Button("Left");
			Button btRight = new Button("Right");
			Button btUp = new Button("Up");
			Button btDown = new Button("Down");
			
			hbox.getChildren().addAll(btLeft, btRight, btUp, btDown);
			bPane.setCenter(pane);
			bPane.setBottom(hbox);
			
			Scene scene = new Scene(bPane, 200, 150); 
			primaryStage.setTitle("HandleEvent");
			primaryStage.setScene(scene);
			primaryStage.show();
	         
			btLeft.setOnAction(e->{
				circle.setCenterX(circle.getCenterX() > 0 ? circle.getCenterX() - 10:0);
			});
			
			btRight.setOnAction(e->{
				circle.setCenterX(circle.getCenterX() < scene.getWidth()  ? circle.getCenterX() + 10: scene.getWidth());
			});
			
			btUp.setOnAction(e->{
				circle.setCenterY(circle.getCenterY() > 0 ? circle.getCenterY() - 10:0);
			});
			
			btDown.setOnAction(e->{
				circle.setCenterY(circle.getCenterY() < scene.getHeight() ? circle.getCenterY() + 10: scene.getHeight());
			});
		
		}         	
		
	public static void main(String[] args) {
		launch(args);
	}
	
}
	