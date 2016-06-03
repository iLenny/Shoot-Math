package game.characters;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
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
	private final int DELAY_COUNT = 90;
	private int spriteCount = 0;
	private int delay = DELAY_COUNT;	
	
	// For walking sprite:
	private Rectangle2D [] frame = new Rectangle2D[12];
	
	// For walking sprite with weapon:
	private Rectangle2D [] frameW = new Rectangle2D[12];
	
	// For getting down:
	private Rectangle2D frameDown;
	
	// For getting down with weapon:
	private Rectangle2D frameDownW;
	
	
	/**
	 * Default Constructor
	 * This constructor initializes and seperates all the sprites into frames
	 */
	public Alien() { 
		
		// Initialize sprites-frame (no weapon)
		frame[0] = new Rectangle2D(0, 203, 77, 172);
		frame[1] = new Rectangle2D(124, 203, 77, 172);
		frame[2] = new Rectangle2D(259, 204, 77, 172);
		frame[3] = new Rectangle2D(384, 204, 77, 172);
		frame[4] = new Rectangle2D(259, 204, 77, 172);
		frame[5] = new Rectangle2D(124, 204, 77, 172);
		frame[6] = new Rectangle2D(0, 203, 77, 172);
		frame[7] = new Rectangle2D(129, 388, 77, 172);
		frame[8] = new Rectangle2D(251, 388, 77, 172);
		frame[9] = new Rectangle2D(377, 388, 77, 172);
		frame[10] = new Rectangle2D(251, 388, 77, 172);
		frame[11] = new Rectangle2D(129, 388, 77, 172);
		
		// Initialize sprite-frame (sprite for weapon switch)
		frameW[0] = new Rectangle2D(0, 583, 77, 172);
		frameW[1] = new Rectangle2D(124, 583, 77, 172);
		frameW[2] = new Rectangle2D(259, 584, 77, 172);
		frameW[3] = new Rectangle2D(384, 584, 77, 172);
		frameW[4] = new Rectangle2D(259, 584, 77, 172);
		frameW[5] = new Rectangle2D(124, 584, 77, 172);
		frameW[6] = new Rectangle2D(0, 583, 77, 172);
		frameW[7] = new Rectangle2D(129, 770, 77, 172);
		frameW[8] = new Rectangle2D(251, 770, 77, 172);
		frameW[9] = new Rectangle2D(377, 770, 77, 172);
		frameW[10] = new Rectangle2D(251, 770, 77, 172);
		frameW[11] = new Rectangle2D(129, 770, 77, 172);
		
		// Initialize sprite-frame - down:
		frameDown = new Rectangle2D(523, 452, 128, 110);
		
		frameDownW = new Rectangle2D(523, 648, 128, 110);

		// set sprite image to this images
		character.setImage(sprite);
		
		// set the view port of the character to its initial sprite:
		character.setViewport(frame[0]);
		
		this.setSpeed(11);
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
			
			
			if(this.getWeaponOn()) {
				// change sprite:
				character.setViewport(frameW[spriteCount]);
			}
			else {
				// change sprite:
				character.setViewport(frame[spriteCount]);
			}
			
			
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
		if(this.getWeaponOn()) {
			character.setViewport(frameW[spriteCount]);
		}
		else {
			character.setViewport(frame[spriteCount]);
		}
	}

	@Override
	protected void handleDownSprite() {
		if(this.getWeaponOn()) {
			character.setViewport(frameDownW);
		}
		else {
			character.setViewport(frameDown);
		}
		this.setTranslateX(this.getTranslateX()-25);
		this.setTranslateY(this.getTranslateY()+70);
		
	}

}
