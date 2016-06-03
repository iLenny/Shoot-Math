package game.scenes.layouts;

import game.Controller;
import game.characters.Alien;
import game.tools.MenuButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * 
 * @author Leibniz H. Berihuete
 * 
 * Date Started: 6/1/2016 8:01 PM
 * Last Modification: 6/1/2016 8:56 PM
 * 
 * StartMenuLayout class
 * This class contains a background image, and a menu that has a start-button, settings-button,
 * and an exit-button. This class also extends to the Pane class, which is a container that
 * can take any node and position it at coordinate (0,0) unless relocated.
 */

public class StartMenuLayout extends Pane {
	// Background Image:
	private static final Image BACKGROUND_IMG = 
			new Image(StartMenuLayout.class.getResourceAsStream("../../images/startMenuBG.jpg"));
	
	// Background View -- in order to display the background:
	private static final ImageView BACKGROUND = new ImageView(BACKGROUND_IMG);
	
/* ********************
 * 	  CONSTRUCTORS
 * ********************/
	/**
	 * Default constructor
	 * It initializes the menu along with the menu buttons
	 */
	public StartMenuLayout() {
		// Initialize menu buttons:
		MenuButton startButton = new MenuButton("START", 200, 40);
		MenuButton settingsButton = new MenuButton("SETTINGS");
		MenuButton exitButton = new MenuButton("EXIT");
		
		// Reduce background image by 50%;
		BACKGROUND.setFitWidth(BACKGROUND_IMG.getWidth()*0.50);
		BACKGROUND.setFitHeight(BACKGROUND_IMG.getHeight()*0.50);
		
		// Create Menu
		VBox menu = new VBox(startButton, settingsButton, exitButton);
		menu.setSpacing(5);
		menu.relocate(250, 260);
		
		Alien alien = new Alien();
		Controller controls = new Controller();
		
		alien.buildControls(controls);
		
		// Add background and menu to this container
		this.getChildren().addAll(BACKGROUND, menu, alien);
	}
}
