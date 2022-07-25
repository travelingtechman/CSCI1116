import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise15_Animation extends Application {
	
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {   
				
		Rectangle square = new Rectangle(40,40,40,40);
		square.setFill(Color.BLUE);
		
		Polygon pentagon = new Polygon();
		pentagon.getPoints().addAll(new Double[] {
			125.0,100.0,
			150.0,150.0,
			200.0,150.0,
			225.0,100.0,
			175.0,60.0,		
		});
		
		pentagon.setFill(Color.BLACK);
		FadeTransition fade = new FadeTransition(Duration.seconds(3));
		PathTransition trans = new PathTransition();
		
		trans.setCycleCount(Animation.INDEFINITE);
		trans.setDuration(Duration.seconds(3));
		trans.setNode(square);
		trans.setPath(pentagon);
		fade.setFromValue(1.0);
		fade.setToValue(0.1);
		fade.setCycleCount(Timeline.INDEFINITE);
		fade.setNode(square);
		fade.play();
		trans.play();
		
		BorderPane pane = new BorderPane();
		pane.getChildren().addAll(pentagon,square);		
		pane.setOnMousePressed(e -> {
			if (e.isPrimaryButtonDown()) {
				fade.play();
				trans.play();
	         } else if (e.isSecondaryButtonDown()) {
	            	trans.pause();
	            	fade.pause();
	            	}
			});
	
		Scene scene = new Scene (pane, 300, 250);	
		primaryStage.setTitle("Fade Animation");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}


public void mouse() {
	
}
}
	
	
	
	
	
	
	
	
	

