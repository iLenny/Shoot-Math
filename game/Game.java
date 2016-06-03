package game;

import game.scenes.GamePlayScene;
import game.scenes.IntroScene;
import game.scenes.StartMenuScene;
import javafx.application.Application;
import javafx.stage.Stage;
/**
 * @author Leibniz H. Berihuete
 * Date Started: 6/1/2016 8:30 PM
 * Last Modification: 6/2/2016 8:45 PM
 * 
 * Game Class
 * This class connects all the scenes of the game,
 * such as IntroScene, StartMenuScene, GameplayScene.
 * 
 */
public class Game extends Application {
	// Window Size:
	private static final int WINDOW_WIDTH = 800;
	private static final int WINDOW_HEIGHT = 600;
	
	// Scenes:
	private IntroScene IntroScene;
	private StartMenuScene startMenuScene;
	private GamePlayScene gamePlayScene;
	
	
	@Override
	public void start(Stage primaryStage) {
		//Initialize:
		startMenuScene = new StartMenuScene(WINDOW_WIDTH, WINDOW_HEIGHT);		
		
		// Set window title:
		primaryStage.setTitle("Shoot Math");
		
		// Set window's first scene:
		primaryStage.setScene(startMenuScene);
		
		// Show window:
		primaryStage.show();
	}
	
	
/* ******************
 * 	     MAIN
 * ******************/
	public static void main(String [] args) {
		launch(args);
	}
}
