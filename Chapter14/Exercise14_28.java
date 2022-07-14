import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


	
	public class Exercise14_28 extends Application{
		@Override
		public void start(Stage primaryStage) {   
			int hour = (int) (Math.random()*11);
			int minuet = 0;
			int zeroOne = (int) (Math.random()*2);
			if(zeroOne == 0) {
				minuet = 0;
			} else if(zeroOne == 1) {
				minuet = 30;
			}
			
			ClockPane clock = new ClockPane();
			clock.setVisibiltyHourHand(true);
			clock.setVisibiltyMinuetHand(true);
			clock.setVisibiltySecondHand(false);
			clock.setHour(hour);
			clock.setMinute(minuet);
			clock.setVisibiltySecondHand(false);
			
			Scene scene = new Scene(clock,400, 400);
			
			primaryStage.setTitle("Clock"); 
			primaryStage.setScene(scene); 
			primaryStage.show();
		}
		
		
		public static void main(String[] args) {
			launch(args);
		}
	}

