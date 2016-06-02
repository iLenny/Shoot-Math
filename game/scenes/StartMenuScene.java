package game.scenes;

import game.scenes.layouts.StartMenuLayout;
import javafx.scene.Scene;

/**
 * 
 * @author Leibniz H. Berihuete
 * 
 * Date Started: 6/1/2016 8:56 PM
 * Last Modification: 6/1/2016 9:07 PM
 * 
 * StartMenuScene class
 * This class is a scene that contains a layout that will show
 * the start menu of this game. The purpose of this scene is to
 * be used by a Stage class. * 
 */
public class StartMenuScene extends Scene {
	private static final StartMenuLayout MENU_LAYOUT = new StartMenuLayout();
	
	/**
	 * Constructor
	 *  Initializes the scene with a StartMenuLayout that already contains
	 *  the menu itself along with its menu buttons and functionalities.
	 *  It also initializes the windows size in pixels.
	 * @param windowWidth holds the windows' width
	 * @param windowHeight holds the windows' height
	 */
	public StartMenuScene(int windowWidth, int windowHeight) {
		super(MENU_LAYOUT, windowWidth, windowHeight);
		
	}
}
