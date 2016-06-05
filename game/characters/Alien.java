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
 * Last Modification: 6/3/2016 8:31 AM
 * 
 * Alien Class
 * Alien is a character class, that contains its own
 * sprites and animation.
 */
public class Alien extends Character {
	// Sprite Image;
	private static final Image SPRITE = 
			new Image(Alien.class.getResourceAsStream("../images/ShootMathSprite.png"));;
	
	// Delay count for SPRITE animation:
	private final int DELAY_COUNT = 90;
	private int spriteCount = 0;
	private int delay = DELAY_COUNT;	
	
	// For walking SPRITE:
	private Rectangle2D [] frame = new Rectangle2D[12];
	
	// For walking SPRITE with weapon:
	private Rectangle2D [] frameW = new Rectangle2D[12];
	
	// For getting down:
	private Rectangle2D frameDown;
	
	// For getting down with weapon:
	private Rectangle2D frameDownW;
	
	// arm for weapon:
	private ImageView arm;
	
	// for weapon
	private Weapon weapon;
	
	
	/**
	 * Default Constructor
	 * This constructor initializes and seperates all the sprites into frames
	 */
	public Alien() { 
		initializeSprites();
		
		
		
		
		

		// set SPRITE image to this images
		character.setImage(SPRITE);
		
		// set the view port of the character to its initial SPRITE:
		character.setViewport(frame[0]);
		this.getChildren().addAll(weapon,arm);
		
		this.setSpeed(11);
		
		this.setOnKeyPressed(e-> {
			if(this.getCurrentControls()!=null) {
				Controller controls = getCurrentControls();
				// If weapon switch is pressed
				if(e.getCode().equals(controls.getWeaponKey()) && !e.getCode().equals(controls.getMoveDownKey())) {
					if(this.getWeaponOn()) {
						arm.setVisible(true);
						arm.relocate(23, 90);
					}
					
				}
				
				
			}
		});
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
	
	
	
	
	/* ************************
	 *    OVERRIDE METHODS:
	 * ***********************/	
	
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
			if(!getOnTheGround()) {
				character.setViewport(frameW[spriteCount]);
				arm.setVisible(true);
				arm.relocate(23, 90);
				
				weapon.setVisible(true);
				weapon.relocate(40, 85);
			}
			else {
				character.setViewport(frameDownW);
				arm.setVisible(true);
				arm.relocate(60, 70);
				
				weapon.setVisible(true);
				weapon.relocate(80, 65);
			}
			
		}
		else {
			if(!getOnTheGround()) {
				character.setViewport(frame[spriteCount]);
				arm.setVisible(false);
				weapon.setVisible(false);
			}
			else {
				character.setViewport(frameDown);
				arm.setVisible(false);
				weapon.setVisible(false);
			}
			
		}
	}

	@Override
	protected void handleDownSprite() {
		if(this.getWeaponOn()) {
			character.setViewport(frameDownW);
			arm.setVisible(true);
			arm.relocate(60, 70);
			
			
			weapon.setVisible(true);
			weapon.relocate(80, 65);
		}
		else {
			character.setViewport(frameDown);
			arm.setVisible(false);
			weapon.setVisible(false);
			
		}
		this.setTranslateX(this.getTranslateX()-25);
		this.setTranslateY(this.getTranslateY()+70);
		
	}

}
