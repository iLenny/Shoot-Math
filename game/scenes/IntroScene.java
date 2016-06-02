package game.scenes;

import game.scenes.layouts.IntroLayout;
import javafx.scene.Scene;
/**
 * 
 * @author Leibniz H. Berihuete
 * 
 * Date Started: 5/31/2016 8:20 PM
 * Last Modification: 5/31/2016 10:28 PM
 * 
 * IntroScene class
 * This class is a scene and it contains a layout that will show
 * an introductory video of this game. The purpose of this scene is to
 * be used by a Stage class.
 * 
 */
public class IntroScene extends Scene {
	private static final IntroLayout INTRO_LAYOUT = new IntroLayout();
	
	/**
	 * Constructor
	 *  Initializes the scene with a IntroLayout that already
	 *  comes with the IntroScene class as a 'static final'.
	 *  It also initializes the windows size in pixels.
	 * @param windowWidth holds the windows' width
	 * @param windowHeight holds the windows' height
	 */
	public IntroScene(int windowWidth, int windowHeight) {
		super(INTRO_LAYOUT, windowWidth, windowHeight);
		
		// Play the intro:
		INTRO_LAYOUT.play();
	}
}
