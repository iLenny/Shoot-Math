package game.tools;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Bounds;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import game.characters.Character;
/**
 * 
 * @author Leibniz H. Berihuete
 * Date Started: 6/4/2016 5:31 PM
 * Last Modification: 6/5/2016 11:30 AM
 * 
 * RectangleCollision class
 * A rectangle that can push the character left, right, up, or down, when collide
 * with each other.
 */
public class RectangleCollision extends Rectangle {
	// Default values:
	private static final double DEFAULT_WIDTH = 50;
	private static final double DEFAULT_HEIGHT = 50;
	
	// pushing values:
	public static final int PUSH_LEFT = 0;
	public static final int PUSH_RIGHT = 1;
	public static final int PUSH_UP = 2;
	public static final int PUSH_DOWN = 3;
	
	private int pushingDirection;
	
	
/* **************************
 *       CONSTRUCTORS
 * **************************/
	// Default constructor
	public RectangleCollision() {
		super(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setPushingDirection(PUSH_LEFT);
	}
	
	// Constructor for size
	public RectangleCollision(double width, double height) {
		super(width, height);
		setPushingDirection(PUSH_RIGHT);
	}
	
	// Constructor for pushing
	public RectangleCollision(int direction) {
		super(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setPushingDirection(direction);
	}
	
	// Constructor for pushing and size;
	public RectangleCollision(int direction, double width, double height) {
		super(width, height);
		setPushingDirection(direction);
	}
	
/* *****************************
 *         MUTATORS
 * *****************************/
	public void setPushingDirection(int pushingDirection) {
		this.pushingDirection = pushingDirection;
	}
	
/* *****************************
 *          ACCESSORS
 * *****************************/
	public int getPushingDirection() {
		return pushingDirection;
	}
	
	
	
/* *****************************
 *           OTHERS
 * *****************************/
	public void buildCollisionWith(Character node) {
		Rectangle head = node.getHead();
		Rectangle body = node.getBody();
		Rectangle feet = node.getFeet();
		
		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1), e-> {
			Bounds thisBounds = this.localToScene(this.getBoundsInLocal());
			Bounds nodeBounds;
			
			
			if(pushingDirection == PUSH_LEFT || pushingDirection == PUSH_RIGHT) {
				nodeBounds = body.localToScene(body.getBoundsInLocal());
			}
			else if(pushingDirection == PUSH_DOWN) {
				nodeBounds = head.localToScene(head.getBoundsInLocal());
			}
			else {
				nodeBounds = feet.localToScene(feet.getBoundsInLocal());
			}	
			
			if(thisBounds.intersects(nodeBounds)) {
				push(pushingDirection, node);
			}
		}));
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();		
	}
	
	private void push(int pushingDirection, Character node ) {
		switch(pushingDirection) {
		case PUSH_LEFT:
			node.setTranslateX(node.getTranslateX()-node.getSpeed()/node.getFPS());
			break;
			
		case PUSH_RIGHT:
			node.setTranslateX(node.getTranslateX()+node.getSpeed()/node.getFPS());
			break;
			
		case PUSH_UP:
			node.setTranslateY(node.getTranslateY()-node.getSpeed()/node.getFPS());
			break;
			
		case PUSH_DOWN:
			node.setTranslateY(node.getTranslateY()+node.getSpeed()/node.getFPS());
			break;
			
		default:
			break;
		}
	}
	
	
	
	
	
}
