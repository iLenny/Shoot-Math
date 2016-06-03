package game;

import game.scenes.layouts.StartMenuLayout;
import game.tools.MenuButton;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Tester extends Application {
	// Window size:
	private static final int WINDOW_WIDTH = 800;
	private static final int WINDOW_HEIGHT = 600;
	
	
	@Override
	public void start(Stage primaryStage) {
		
		VBox v = new VBox();
		for(int i = 0; i < 5; i++) {
			MenuButton b = new MenuButton();
			v.getChildren().add(b);
		}
	
		
		Pane root = new Pane(new StartMenuLayout());
		//root.setStyle("-fx-background-color: WHITE");
		Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
		
		
		primaryStage.setTitle("Tester");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String [] args) {
		launch(args);
	}
}
