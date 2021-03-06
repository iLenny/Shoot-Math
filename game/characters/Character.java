package game.characters;
import game.Controller;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * 
 * @author Leibniz H. Berihuete
 * Date Started: 6/2/2016 6:35 PM
 * Last Modification: 6/5/2016 9:00 PM
 * 
 * Character class
 *  The purpose of this class is to build all the fundamental features of
 *  a character. This class must be inherited by another class in order to create 
 *  a specific character and yet still have all the fundamentals.
 */
public abstract class Character extends Pane {
	// Default Values:
	private static final String DEFAULT_NAME = "Player";
	private static final double DEFAULT_SPEED = 5.0;
	private static final double DEFAULT_HP = 100.0;
	private static final double DEFAULT_FPS = 1000/30; // 30 frames per second
	
	// For character:
	protected ImageView character;
	private String name;
	private double speed;
	private double hp;
	
	// For character control
	private boolean weaponOn = false;
	private boolean allowToMove = true;
	private String moveKey = "";
	private boolean allowToPressDown = true;
	private boolean onTheGround = false;
	
	// For character animation:
	private KeyFrame keyFrame;
	private Timeline timeline;
	private double FPS;
	
	// In order to save the character's position
	private double currentYPos = 0;
	private double currentXPos = 0;	
	
	// The controls that move the character:
	private Controller currentControls;
	
	// Body parts of the character:
	protected Rectangle head;
	protected Rectangle body;
	protected Rectangle feet;
	
	
	
	
/* ******************
 * 	  CONSTRUCTORS
 * ******************/
	/**
	 * Default Constructor
	 * Initializes the character with no image.
	 * It also initializes the name, speed , and hp,
	 * with default values:
	 * name: "Player"
	 * speed: 5.0
	 * hp: 100.0 
	 * 
	 * it also builds the players animation & functionalities
	 */
	public Character() {
		// Initialize:
		character = new ImageView();
		character.setFocusTraversable(true);
		setName(DEFAULT_NAME);
		setSpeed(DEFAULT_SPEED);
		setHP(DEFAULT_HP);
		setFPS(DEFAULT_FPS);
		
		head= new Rectangle(30, 30);
		head.setFill(Color.AQUA);
		
		
		body = new Rectangle(30, 30);
		body.setFill(Color.CHARTREUSE);
		body.setTranslateY(40);
		
		feet = new Rectangle(30, 30);
		feet.setTranslateY(80);
		feet.setFill(Color.RED);
		
		
		
		
		// builds player's animation
		buildAnimation();

		// Add to this pane:
		this.getChildren().addAll(character, body, head, feet);
	}
	
/* ********************
 * 	    MUTATORS
 * ********************/
	/**
	 * character Setter:
	 * @param character holds the ImageView of the character
	 */
	public void setCharacter(ImageView character) {
		this.character = character;
	}
	
	/**
	 * name Setter:
	 * @param name holds the name of the character
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * speed Setter:
	 * @param speed holds the speed of the character's movements
	 */
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	/**
	 * hp Setter:
	 * @param hp holds the HP of the character
	 */
	public void setHP(double hp) {
		this.hp = hp;
	}
	
	/**
	 * FPS Setter:
	 * @param FPS holds the frame per second of the 
	 * character's animation
	 */
	public void setFPS(double FPS) {
		this.FPS = FPS;
	}
	
	/**
	 * weaponOn Setter:
	 * @param weaponOn holds the boolean value of whether the player has
	 * a weapon on his/her hand or not.
	 */
	public void setWeaponOn(boolean weaponOn) {
		this.weaponOn = weaponOn;
	}
	
/* *********************
 * 	    ACCESSORS
 * *********************/
	/**
	 * character Getter:
	 * @return the character's imageView.
	 */
	public ImageView getCharacter() {
		return character;
	}
	
	/**
	 * name Getter:
	 * @return the name of the character
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * speed Getter:
	 * @return the speed of the character's movements
	 */
	public double getSpeed() {
		return speed;
	}
	
	/**
	 * hp Getter:
	 * @return the hp of the character
	 */
	public double getHP() {
		return hp;
	}
	
	/**
	 * FPS Getter:
	 * @return the frames per second of the character's animation
	 */
	public double getFPS() {
		return FPS;
	}
	
	/**
	 * timeline Getter:
	 * @return the timeline of the character's animation.
	 */
	public Timeline getTimeline() {
		return timeline;
	}
	
	/**
	 * weaponOn Getter
	 * @return whether the player has a weapon on his hand or not.
	 */
	public boolean getWeaponOn() {
		return weaponOn;
	}
	
	
	/**
	 * onTheGround Getter
	 * @return whether the character is on the ground or not
	 */
	public boolean getOnTheGround() {
		return onTheGround;
	}
	
	/**
	 * currentControls Getter;
	 * @return the controls of this character which contains the key settings
	 */
	public  Controller getCurrentControls() {
		return currentControls;
	}
	
	/**
	 * moveKey Getter:
	 * @return the key that moves the character either left, right or down
	 */
	public String getMoveKey() {
		return moveKey;
	}
	
	/**
	 * head Getter
	 * @return the rectangle that represents the head of the character
	 */
	public Rectangle getHead() {
		return head;
	}
	
	/**
	 * body Getter
	 * @return the rectangle that represents the body of the character
	 */
	public Rectangle getBody() {
		return body;
	}
	
	/**
	 * feet Getter
	 * @return the rectangle that represents the feet of the character
	 */
	public Rectangle getFeet() {
		return feet;
	}
	
	
	
	
	
/* ********************
 * 	     OTHERS
 * ********************/
	/**
	 * buildControls Method.
	 * This method builds the functionality of the controls for the
	 * character
	 * @param controller holds the controls that may have or 
	 * may not have been changed by the users.
	 */
	public void buildControls(Controller controller) {
		currentControls = controller;
		KeyCode RIGHT = controller.getMoveRightKey();
		KeyCode LEFT = controller.getMoveLeftKey();
		KeyCode DOWN = controller.getMoveDownKey();
		KeyCode JUMP = controller.getJumpKey();
		KeyCode WEAPON = controller.getWeaponKey();
		KeyCode SHOOT = controller.getShootKey();
		
		// PRESSED Key functionalities
		this.setOnKeyPressed(e-> {
			// RIGHT
			if(e.getCode().equals(RIGHT) && allowToPressDown) {
				moveKey = "RIGHT";
				allowToMove = true;
				handleRightScale();
				timeline.play();
			}
			
			// LEFT
			else if(e.getCode().equals(LEFT) && allowToPressDown) {
				moveKey = "LEFT";
				allowToMove = true;
				handleLeftScale();
				timeline.play();
			}
			
			// DOWN
			else if(e.getCode().equals(DOWN)) {				
				if(allowToPressDown) {
					moveKey ="DOWN";
					currentXPos = this.getTranslateX();
					currentYPos = this.getTranslateY();
					allowToPressDown = false;
					handleDownSprite();
					onTheGround = true;
					
				}
				timeline.pause();
			}
			
			// JUMP
			if(e.getCode().equals(JUMP)) {
				//TODO jump method
			}
			
			// WEAPON
			if(e.getCode().equals(WEAPON)) {
				if(weaponOn)
					weaponOn = false;
				else 
					weaponOn = true;
				
				timeline.play();
			}
			
			// SHOOT
			if(e.getCode().equals(SHOOT)) {
				//TODO shoot method
			}			
		});
		
		// RELEASED Key functionalities
		this.setOnKeyReleased(e->{
			// RIGHT
			if(e.getCode().equals(RIGHT) && allowToPressDown) {
				moveKey = "";
				allowToMove = false;
				resetSprite();
				timeline.pause();
				
			}
			
			// LEFT
			else if(e.getCode().equals(LEFT) && allowToPressDown) {
				moveKey = "";
				allowToMove = false;
				resetSprite();
				timeline.pause();
			}
			
			// DOWN
			else if(e.getCode().equals(DOWN)) {
				moveKey = "";
				this.setTranslateY(currentYPos);
				this.setTranslateX(currentXPos);				
				timeline.pause();
				allowToPressDown = true;
				onTheGround = false;
				resetSprite();
			}
			
			// JUMP
			if(e.getCode().equals(JUMP)) {
				
				timeline.pause();
			}
			
			// WEAPON
			if(e.getCode().equals(WEAPON) && !e.getCode().equals(DOWN)) {
				if(!e.getCode().equals(RIGHT)|| !e.getCode().equals(LEFT))
					resetSprite();
				
				timeline.pause();
			}
			
			// SHOOT
			if(e.getCode().equals(SHOOT)) {
				timeline.pause();
			}
			
		});		
	}
	
	/**
	 * buildAnimation Method
	 * this handles the character's animation such as sprites animation,
	 * and translational motion
	 */
	private void buildAnimation() {
		keyFrame = new KeyFrame(Duration.millis(1), e-> {
			if(moveKey.equals("RIGHT") && allowToMove) {
				this.setTranslateX(this.getTranslateX()+(speed/FPS));
				handleSprites();
			}
			else if(moveKey.equals("LEFT") && allowToMove) {
				this.setTranslateX(this.getTranslateX()-(speed/FPS));
				handleSprites();
			}
		});
		
		timeline = new Timeline(keyFrame);
		timeline.setCycleCount(Timeline.INDEFINITE);
	}
	
/* **********************
 * 	  abstract Methods
 * **********************/
	
	/**
	 * Since the sprite of a character can come in different ways
	 * one must handle the sprite based on the character that one is creating.
	 */
	protected abstract void handleSprites();	  
	
	/**
	 * handles down sprite
	 */
	protected abstract void handleDownSprite();
	
	
	/**
	 * handleLeftScale Method:
	 * Sprites may come with 1 direction scale only, therefore you can handle
	 * the left scale here. 
	 */
	protected abstract void handleLeftScale();
	
	/**
	 * handleRightScale Method:
	 * Sprites may come with 1 direction scale only, therefore you can handle
	 * the right scale here. 
	 */
	protected abstract void handleRightScale();
	
	
	
	/**
	 * resetSprite
	 * This resets the character to its standing position
	 */
	protected abstract void resetSprite();
	
}
