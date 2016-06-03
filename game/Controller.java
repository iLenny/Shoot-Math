package game;

import javafx.scene.input.KeyCode;
/**
 * 
 * @author Leibniz H. Berihuete
 * Date Started: 6/2/2016 7:05 PM
 * Last Modification: 6/2/2016 7:35 PM
 * 
 * Controller class
 * This class contains the controls for the game play. The purpose of this
 * class is to give the ability to change control keys in case the users would
 * like to change the controls through settings
 */
public class Controller {
	// Default controls:
	private static final KeyCode DEFAULT_RIGHT_KEY = KeyCode.RIGHT;
	private static final KeyCode DEFAULT_LEFT_KEY = KeyCode.LEFT;
	private static final KeyCode DEFAULT_JUMP_KEY = KeyCode.SPACE;
	private static final KeyCode DEFAULT_WEAPON_KEY = KeyCode.W;
	private static final KeyCode DEFAULT_SHOOT_KEY = KeyCode.S;
	
	// Keys:
	private KeyCode moveRightKey;
	private KeyCode moveLeftKey;
	private KeyCode jumpKey;
	private KeyCode weaponKey;
	private KeyCode shootKey;
	
	/**
	 * Constructor
	 * Initializes the keys with default values:
	 * moveRightKey: RIGHT ARROW KEY
	 * moveLeftKey: LEFT ARROW KEY
	 * jumpKey: SPACE KEY
	 * weaponKey: W KEY
	 * shootKey: S KEY
	 */
	public Controller() {
		setMoveRightKey(DEFAULT_RIGHT_KEY);
		setMoveLeftKey(DEFAULT_LEFT_KEY);
		setJumpKey(DEFAULT_JUMP_KEY);
		setWeaponKey(DEFAULT_WEAPON_KEY);
		setShootKey(DEFAULT_SHOOT_KEY);
	}
	
/* ******************
 *     MUTATORS
 * ******************/
	
	/**
	 * moveRightKey Setter:
	 * @param key holds the key that moves the player
	 * to the right
	 */
	public void setMoveRightKey(KeyCode key) {
		this.moveRightKey = key;
	}
	
	/**
	 * moveLeftKey Setter:
	 * @param key holds the key that moves the player
	 * to the left
	 */
	public void setMoveLeftKey(KeyCode key) {
		this.moveLeftKey = key;
	}
	
	/**
	 * jumpKey Setter:
	 * @param key holds the key that makes the player jump
	 */
	public void setJumpKey(KeyCode key) {
		this.jumpKey = key;
	}
	
	/**
	 * weaponKey Setter
	 * @param key holds the key that makes the player switch weapons
	 */
	public void setWeaponKey(KeyCode key) {
		this.weaponKey = key;
	}
	
	/**
	 * shootKey Setter:
	 * @param key holds the key that makes the player shoot
	 */
	public void setShootKey(KeyCode key) {
		this.shootKey = key;
	}
	
/* *******************
 * 	   ACCESSORS
 * *******************/
	
	/**
	 * moveRightKey Getter:
	 * @return the key that moves the player to the right
	 */
	public KeyCode getMoveRightKey() {
		return moveRightKey;
	}
	
	/**
	 * moveLeftKey Getter:
	 * @return the key that moves the player to the left
	 */
	public KeyCode getMoveLeftKey() {
		return moveLeftKey;
	}
	
	/**
	 * jumpKey Getter:
	 * @return the key that makes the player to jump
	 */
	public KeyCode getJumpKey() {
		return jumpKey;
	}
	
	/**
	 * weaponKey Getter:
	 * @return the key that makes the player to switch weapons
	 */
	public KeyCode getWeaponKey() {
		return weaponKey;
	}
	
	/**
	 * shootKey Getter
	 * @return the key that makes the player to shoot
	 */
	public KeyCode getShootKey() {
		return shootKey;
	}
}
