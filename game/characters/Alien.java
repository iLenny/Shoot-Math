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
	
	
	/* -------------- ARM --------------- */
	// ARM POSITION: RIGHT
	final int ARM_RIGHT_X = 23;
	final int ARM_RIGHT_Y = 90;
	
	// ARM POSITION: LEFT
	final int ARM_LEFT_X = 10;
	final int ARM_LEFT_Y = 90;
	
	// ARM POSITION: DOWN-RIGHT
	final int ARM_DOWN_RIGHT_X = 60;
	final int ARM_DOWN_RIGHT_Y = 70;
	
	// ARM POSITION: DOWN-LEFT
	final int ARM_DOWN_LEFT_X = 25;
	final int ARM_DOWN_LEFT_Y = 70;
	
	
	/* -------------- WEAPON --------------- */	
	// WEAPON POSITION: RIGHT
	final int WEAPON_RIGHT_X = 40;
	final int WEAPON_RIGHT_Y = 85;
	
	// WEAPON POSITION: LEFT
	final int WEAPON_LEFT_X = -25;
	final int WEAPON_LEFT_Y = 85;
	
	// WEAPON POSITION: DOWN-RIGHT
	final int WEAPON_DOWN_RIGHT_X = 80;
	final int WEAPON_DOWN_RIGHT_Y = 65;
	
	// WEAPON POSITION: DOWN-LEFT
	final int WEAPON_DOWN_LEFT_X = -10;
	final int WEAPON_DOWN_LEFT_Y = 65;
	
	
	/* -------------- HEAD --------------- */	
	// HEAD POSITION: RIGHT
	final int HEAD_RIGHT_X = 30;
	final int HEAD_RIGHT_Y = 35;
	
	// HEAD POSITION: LEFT
	final int HEAD_LEFT_X = 30;
	final int HEAD_LEFT_Y = 50;
	
	// HEAD POSITION: DOWN-RIGHT
	final int HEAD_DOWN_RIGHT_X = 75;
	final int HEAD_DOWN_RIGHT_Y = 40;
	
	// HEAD POSITION: DOWN-LEFT
	final int HEAD_DOWN_LEFT_X = 20;
	final int HEAD_DOWN_LEFT_Y = 45;
	
	
	
	/* -------------- BODY --------------- */	
	// BODY POSITION: RIGHT
	final int BODY_RIGHT_X = 15;
	final int BODY_RIGHT_Y = 42;
	
	// BODY POSITION: LEFT
	final int BODY_LEFT_X = 15;
	final int BODY_LEFT_Y = 42;
	
	// BODY POSITION: DOWN-RIGHT
	final int BODY_DOWN_RIGHT_X = 45;
	final int BODY_DOWN_RIGHT_Y = 25;
	
	// BODY POSITION: DOWN-LEFT
	final int BODY_DOWN_LEFT_X = 25;
	final int BODY_DOWN_LEFT_Y = 25;
	
	
	
	/* -------------- FEET --------------- */	
	// FEET POSITION: RIGHT
	final int FEET_RIGHT_X = 25;
	final int FEET_RIGHT_Y = 55;
	
	// FEET POSITION: LEFT
	final int FEET_LEFT_X = 25;
	final int FEET_LEFT_Y = 55;
	
	// FEET POSITION: DOWN-RIGHT
	final int FEET_DOWN_RIGHT_X = 5;
	final int FEET_DOWN_RIGHT_Y = 0;
	
	// FEET POSITION: DOWN-LEFT
	final int FEET_DOWN_LEFT_X = 45;
	final int FEET_DOWN_LEFT_Y = 0;
	
	private double headWidth, headHeight;
	private double bodyWidth, bodyHeight;
	private double feetWidth, feetHeight;
	

	
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
		fixBodyParts();

		

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
	
	private void spriteHandler(int count) {
		String moveKey = this.getMoveKey();
		boolean weaponOn = this.getWeaponOn();
		
		// If user press WEAPON key, make arm & weapon visible:
		if(weaponOn) {
			arm.setVisible(true);
			weapon.setVisible(true);
		}
		else {
			arm.setVisible(false);
			weapon.setVisible(false);
		}
		
		
		switch(moveKey) {
		case "RIGHT":
			// display the character standing up with a weapon (if the weapon is on).
			character.setViewport(weaponOn ? frameW[count]:frame[count]);   
			arm.relocate(ARM_RIGHT_X, ARM_RIGHT_Y);
			weapon.relocate(WEAPON_RIGHT_X, WEAPON_RIGHT_Y);
			// relocate body parts:
			head.relocate(HEAD_RIGHT_X, HEAD_RIGHT_Y);		
			body.relocate(BODY_RIGHT_X, BODY_RIGHT_Y);
			feet.relocate(FEET_RIGHT_X, FEET_RIGHT_Y);
			
			break;
			
			
		case "LEFT":
			// display the character standing up with a weapon (if the weapon is on).
			character.setViewport(weaponOn ? frameW[count]:frame[count]);   
			arm.relocate(ARM_LEFT_X,  ARM_LEFT_Y);
			weapon.relocate(WEAPON_LEFT_X, WEAPON_LEFT_Y);
			// relocate body parts:
			head.relocate(HEAD_LEFT_X, HEAD_LEFT_Y);		
			body.relocate(BODY_LEFT_X, BODY_LEFT_Y);
			feet.relocate(FEET_LEFT_X, FEET_LEFT_Y);
			break;
			
			
		case "DOWN":
			// display the character getting down with a weapon (if the weapon is on).
			character.setViewport(weaponOn ? frameDownW:frameDown);
			if(character.getScaleX() == 1) {
				arm.relocate(ARM_DOWN_RIGHT_X,  ARM_DOWN_RIGHT_Y);
				weapon.relocate(WEAPON_DOWN_RIGHT_X, WEAPON_DOWN_RIGHT_Y);
				// relocate body parts:
				head.relocate(HEAD_DOWN_RIGHT_X, HEAD_DOWN_RIGHT_Y);		
				body.relocate(BODY_DOWN_RIGHT_X, BODY_DOWN_RIGHT_Y);
				feet.relocate(FEET_DOWN_RIGHT_X, FEET_DOWN_RIGHT_Y);
			}
			else {
				arm.relocate(ARM_DOWN_LEFT_X,  ARM_DOWN_LEFT_Y);
				weapon.relocate(WEAPON_DOWN_LEFT_X, WEAPON_DOWN_LEFT_Y);
				// relocate body parts:
				head.relocate(HEAD_DOWN_LEFT_X, HEAD_DOWN_LEFT_Y);		
				body.relocate(BODY_DOWN_LEFT_X, BODY_DOWN_LEFT_Y);
				feet.relocate(FEET_DOWN_LEFT_X, FEET_DOWN_LEFT_Y);
			}
			
			head.setWidth(headWidth);
			head.setHeight(headHeight);
			body.setWidth(50);
			body.setHeight(15);
			feet.setWidth(feetWidth+50);
			feet.setHeight(feetHeight-10);
			break;
			
			
		default:
			// display the character standing up with a weapon (if the weapon is on)
			character.setViewport(weaponOn ? frameW[count]:frame[count]); 
			
			if(character.getScaleX() == 1) {
				arm.relocate(ARM_RIGHT_X,  ARM_RIGHT_Y);
				weapon.relocate(WEAPON_RIGHT_X, WEAPON_RIGHT_Y);
				// relocate body parts:
				head.relocate(HEAD_RIGHT_X, HEAD_RIGHT_Y);		
				body.relocate(BODY_RIGHT_X, BODY_RIGHT_Y);
				feet.relocate(FEET_RIGHT_X, FEET_RIGHT_Y);
				
				
			}
			else {
				arm.relocate(ARM_LEFT_X,  ARM_LEFT_Y);
				weapon.relocate(WEAPON_LEFT_X, WEAPON_LEFT_Y);
				
				// relocate body parts:
				head.relocate(HEAD_LEFT_X, HEAD_LEFT_Y);		
				body.relocate(BODY_LEFT_X, BODY_LEFT_Y);
				feet.relocate(FEET_LEFT_X, FEET_LEFT_Y);
			}
			
			head.setWidth(headWidth);
			head.setHeight(headHeight);
			body.setWidth(bodyWidth);
			body.setHeight(bodyHeight);
			feet.setWidth(feetWidth);
			feet.setHeight(feetHeight);
			
			break;
		}
		
			
	}
	
	private void fixBodyParts() {
		body.setWidth(body.getWidth()+5);
		body.setHeight(body.getHeight()+10);
		
		headWidth = head.getWidth();
		headHeight = head.getHeight();
		
		bodyWidth = body.getWidth();
		bodyHeight = body.getHeight();
		
		feetWidth = feet.getWidth();
		feetHeight = feet.getHeight();
		
		// relocate body parts:
		head.relocate(HEAD_RIGHT_X, HEAD_RIGHT_Y);		
		body.relocate(BODY_RIGHT_X, BODY_RIGHT_Y);
		feet.relocate(FEET_RIGHT_X, FEET_RIGHT_Y);
		
		head.setVisible(false);
		body.setVisible(false);
		feet.setVisible(false);
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
			spriteHandler(spriteCount);		
			
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
		character.setScaleX(-1);
		arm.setScaleX(-1);
		weapon.setScaleX(-1);
		
	}

	/**
	 * handleRightScale
	 * Here we specify what scale the character is going to 
	 * be when the character is moving towards the right
	 */
	@Override
	protected void handleRightScale() {
		character.setScaleX(1);
		arm.setScaleX(1);
		weapon.setScaleX(1);
	}

	/**
	 * resetSprite
	 * When a key is released from being pressed, the sprite will
	 * reset, the character will go back to standing position
	 */
	@Override
	protected void resetSprite() {
		spriteCount = 0;
		spriteHandler(spriteCount);
	}

	@Override
	protected void handleDownSprite() {
		spriteHandler(0);
		
		// In order to make the character get down:
		this.setTranslateX(this.getTranslateX()-25);
		this.setTranslateY(this.getTranslateY()+70);
		
	}

}
