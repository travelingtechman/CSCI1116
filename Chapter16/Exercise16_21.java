import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
/*
 * Ethan hunt
 * 8/17/22
 */
public class Exercise16_21 extends Application {
		TextField tf = new TextField("");
		
		Timeline time = new Timeline(new KeyFrame(Duration.millis(1000), e->{
			int seconds = Integer.parseInt(tf.getText());
			tf.setText(seconds - 1 +"");
			if(seconds - 1 <= 0) {
				stopAnimation();
			}
		}));
		
		//Media media = new Media("http://liveexample.pearsoncmg.com/common/audio/anthem/anthem0.mp3");
		//MediaPlayer mp = new MediaPlayer(media);
		
		 @Override // Override the start method in the Application class
		 public void start(Stage primaryStage) {
			//mp.setCycleCount(Timeline.INDEFINITE);
			
			time.setCycleCount(Timeline.INDEFINITE);
			
			tf.setAlignment(Pos.CENTER);
			tf.setOnAction(e-> {
				time.play();
			});
			 
			tf.setFont(Font.font("TImes", 35));
			 
		Scene scene = new Scene(tf, 500, 500);
		
		primaryStage.setTitle("16_21"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	 }
		 private void stopAnimation() {
			 time.stop();
			 
			// mp.play();
		 }

	 public static void main(String[] args) {
		 launch(args);
		 }
}

