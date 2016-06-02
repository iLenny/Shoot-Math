package game.scenes.layouts;

import game.tools.MenuButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class StartMenuLayout extends Pane {
	private static final Image BACKGROUND_IMG = 
			new Image(StartMenuLayout.class.getResourceAsStream("../../images/startMenuBG.jpg"));
	private static final ImageView BACKGROUND = new ImageView(BACKGROUND_IMG);
	
	public StartMenuLayout() {
		MenuButton startButton = new MenuButton("START", 200, 40);
		MenuButton settingsButton = new MenuButton("SETTINGS");
		MenuButton exitButton = new MenuButton("EXIT");
		
		
		
		BACKGROUND.setFitWidth(BACKGROUND_IMG.getWidth()*0.50);
		BACKGROUND.setFitHeight(BACKGROUND_IMG.getHeight()*0.50);
		
		VBox vbox = new VBox(startButton, settingsButton, exitButton);
		vbox.setSpacing(5);
		vbox.relocate(400-150, 300-40);
		this.getChildren().addAll(BACKGROUND,vbox);
	}
}
