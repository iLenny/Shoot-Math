package game.characters;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
/**
 * 
 * @author Leibniz H. Berihuete
 * Date Started: 6/3/2016 7:34 AM
 * Last Modification: 6/3/2016 8:31 AM
 * 
 * Alien Class
 * Alien is a character class, that contains its own
 * sprites and animation.
 */
public class Alien extends Character {
	// Sprite Image;
	private static final Image sprite = 
			new Image(Alien.class.getResourceAsStream("../images/ShootMathSprite.png"));;
	
	// Delay count for sprite animation:
	private final int DELAY_COUNT = 100;
	private int spriteCount = 0;
	private int delay = DELAY_COUNT;	

	private Rectangle2D [] frame = new Rectangle2D[14];
	
	
	/**
	 * Default Constructor
	 * This constructor initializes and seperates all the sprites into frames
	 */
	public Alien() { 
		
		// Initialize all frames
		frame[0] = new Rectangle2D(0, 203, 77, 172);
		frame[1] = new Rectangle2D(124, 203, 77, 172);
		frame[2] = new Rectangle2D(259, 204, 77, 172);
		frame[3] = new Rectangle2D(390, 204, 77, 172);
		frame[4] = new Rectangle2D(129, 388, 77, 172);
		frame[5] = new Rectangle2D(390, 204, 77, 172);
		frame[6] = new Rectangle2D(259, 204, 77, 172);
		frame[7] = new Rectangle2D(124, 203, 77, 172);
		frame[8] = new Rectangle2D(0, 203, 77, 172);
		frame[9] = new Rectangle2D(129, 388, 77, 172);
		frame[10] = new Rectangle2D(251, 388, 77, 172);
		frame[11] = new Rectangle2D(377, 388, 77, 172);
		frame[12] = new Rectangle2D(251, 388, 77, 172);
		frame[13] = new Rectangle2D(129, 388, 77, 172);

		// set sprite image to this images
		character.setImage(sprite);
		
		// set the view port of the character to its initial sprite:
		character.setViewport(frame[0]);
	}
	
	@Override
	protected void handleSprites() {
		// When delay equals zero, it will change sprites
		if(delay <= 0) {
			//if not at the end of the array, increment spriteCount
			if(spriteCount < frame.length-1) {
				spriteCount++;
			}
			else {
				spriteCount = 0;
			}
			// change sprite:
			character.setViewport(frame[spriteCount]);
			
			// set delay back to its original count
			delay = DELAY_COUNT;
		}
		else {
			delay--;
		}	
	}

	@Override
	protected void handleLeftScale() {
		this.setScaleX(-1);
		
	}

	@Override
	protected void handleRightScale() {
		this.setScaleX(1);
	}

	@Override
	protected void resetSprite() {
		spriteCount = 0;
		character.setViewport(frame[spriteCount]);
		
	}

}
