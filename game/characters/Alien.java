package game.characters;

import game.Controller;
import game.characters.weapons.Weapon;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
/**
 * 
 * @author Leibniz H. Berihuete
 * Date Started: 6/3/2016 7:34 AM
 * Last Modification: 6/5/2016 9:18 AM
 * 
 * Alien Class
 * Alien is a character class, that contains its own
 * sprites and animation.
 */
public class Alien extends Character {
	// Sprite Image;
	private static final Image SPRITE = 
			new Image(Alien.class.getResourceAsStream("../images/ShootMathSprite.png"));;
	
	// For animation:
	private final int DELAY_COUNT = 90;
	private int spriteCount = 0;
	private int delay = DELAY_COUNT;	
	
	// For walking SPRITE:
	private Rectangle2D [] frame = new Rectangle2D[12];
	
	// For walking SPRITE with weapon:
	private Rectangle2D [] frameW = new Rectangle2D[12];
	
	// For getting-down:
	private Rectangle2D frameDown;
	
	// For getting-down with weapon:
	private Rectangle2D frameDownW;
	
	// arm for weapon:
	private ImageView arm;
	
	// the weapon itself:
	private Weapon weapon;
	
	

	
/* ***********************************
 * 	        CONSTRUCTORS
 * ***********************************/
	/**
	 * Default Constructor
	 * This constructor initializes and seperates all the sprites into frames
	 */
	public Alien() { 
		initializeSprites();
		buildControls();

		// set SPRITE image to this character
		character.setImage(SPRITE);
		
		// this will display the first frame of the character.
		character.setViewport(frame[0]);
		
		// Add the weapon and the arm to this container
		this.getChildren().addAll(weapon,arm);
		
		
	
	}
	
	
	private void initializeSprites() {
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
				
		// Initialize SPRITE-frame (SPRITE for weapon switch)
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
				
		// Initialize SPRITE-frame - down:
		frameDown = new Rectangle2D(523, 452, 128, 110);
		
		// Initialize SPRITE-frame -  with weapon down:
		frameDownW = new Rectangle2D(523, 648, 128, 110);
		
		// Initialize SPRITE-frame - arm
		arm = new ImageView(SPRITE);
		arm.relocate(23, 90);
		arm.setViewport(new Rectangle2D(577, 336, 43, 29));
		arm.setVisible(false);
		
		weapon = new Weapon(new Rectangle2D(577, 301, 61, 30));
		weapon.setVisible(false);
		
		
	}
	
	/* **************************
	 *        OTHERS
	 * **************************/
	private void buildControls() {
		// If Key pressed
		this.setOnKeyPressed(e-> {
			if(this.getCurrentControls()!=null) {
				Controller controls = getCurrentControls();
				
				// If weapon switch is pressed
				if(e.getCode().equals(controls.getWeaponKey()) && 
				  !e.getCode().equals(controls.getMoveDownKey())) {
					
					if(this.getWeaponOn()) {
						arm.setVisible(true);
						arm.relocate(23, 90);
					}					
				}			
			}
		});
	}
	
	
	
	/* ************************
	 *    OVERRIDE METHODS:
	 * ***********************/	
	
	/**
	 * handleSprites
	 * Here we specify how is this character is going
	 * to change sprites while walking, or getting-down 
	 */
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
				// change SPRITE:
				character.setViewport(frameW[spriteCount]);
			}
			else {
				// change SPRITE:
				character.setViewport(frame[spriteCount]);
			}
			
			
			// set delay back to its original count
			delay = DELAY_COUNT;
		}
		else {
			delay--;
		}	
	}
	
	/**
	 * handleLeftScale
	 * Here we specify what scale the character is going to 
	 * be when the character is moving towards the left
	 */
	@Override
	protected void handleLeftScale() {
		this.setScaleX(-1);
		
	}

	/**
	 * handleRightScale
	 * Here we specify what scale the character is going to 
	 * be when the character is moving towards the right
	 */
	@Override
	protected void handleRightScale() {
		this.setScaleX(1);
	}

	/**
	 * resetSprite
	 * When a key is released from being pressed, the sprite will
	 * reset, the character will go back to standing position
	 */
	@Override
	protected void resetSprite() {
		spriteCount = 0;
		if(this.getWeaponOn()) {
			
			// Set arm & weapon visible:
			arm.setVisible(true);
			weapon.setVisible(true);
			
			if(!getOnTheGround()) {
				character.setViewport(frameW[spriteCount]);				
				
				// relocate arm & weapon:
				arm.relocate(23, 90);			
				weapon.relocate(40, 85);
			}
			else {
				character.setViewport(frameDownW);
				
				// relocate arm & weapon:
				arm.relocate(60, 70);				
				weapon.relocate(80, 65);
			}
			
		}
		else {
			// Make arm & weapon disappear:
			arm.setVisible(false);
			weapon.setVisible(false);
			
			if(!getOnTheGround()) {
				character.setViewport(frame[spriteCount]);				
			}
			else {
				character.setViewport(frameDown);
			}
			
		}
	}

	@Override
	protected void handleDownSprite() {
		if(this.getWeaponOn()) {
			character.setViewport(frameDownW);
			
			// Set arm & weapon visible:
			arm.setVisible(true);
			weapon.setVisible(true);
			
			// relocate arm & weapon:
			arm.relocate(60, 70);			
			weapon.relocate(80, 65);
		}
		else {
			character.setViewport(frameDown);
			
			// Make arm & weapon disappear:
			arm.setVisible(false);
			weapon.setVisible(false);
			
		}
		
		// In order to make the character get down:
		this.setTranslateX(this.getTranslateX()-25);
		this.setTranslateY(this.getTranslateY()+70);
		
	}

}
