package game.maps;

import java.util.ArrayList;

import game.tools.RectangleCollision;
import game.characters.Character;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
/**
 * 
 * @author Leibniz H. Berihuete
 * Date Started: 6/6/2016 10:30 PM
 * Last Modification: 6/7/2016 5:51 PM
 *
 */
public class Map extends Pane {
	// Image views:
	private ImageView background;
	private ImageView mapStage;	
	
	// Physics:
	private double gravity;
	
	// Lists:
	private ArrayList<RectangleCollision> collObjList;
	private ArrayList<Node> nodeList;
	
	// Animation:
	private Timeline timeline;
	
	// Character:
	private game.characters.Character player;

	
/* **********************
 * 	   CONSTRUCTOR
 * **********************/
	public Map(Character player) {
		// Initialize:
		collObjList = new ArrayList<>();
		nodeList = new ArrayList<>();
		setPlayer(player);
		
		
		
		buildAnimation();
	}
	
/* **********************
 * 	    MUTATORS
 * **********************/
	// Player Setter:
	public void setPlayer(Character player) {
		this.player = player;
	}
	
	
/* **********************
 * 	    ACCESSORS
 * **********************/
	// Player Getter:
	public Character getPlayer() {
		return this.player;
	}
	
	// Timeline Getter:
	public Timeline getTimeline() {
		return timeline;
	}
	
	
	
/* **********************
 * 	   OTHERS
 * **********************/
	/**
	 * buildAnimation
	 * This method builds the animation of the map--when the player is interacting with it
	 */
	private void buildAnimation() {
		double endOfMap = mapStage.getImage().getWidth();
		
		// build frame:
		KeyFrame keyframe = new KeyFrame(Duration.millis(1), e->{
			String key = player.getMoveKey();
			double playerX = player.localToScene(player.getBoundsInLocal()).getMinX();
			double mapStageX = mapStage.localToScene(mapStage.getBoundsInLocal()).getMinX();
			
			// When player is near the end of the window and pressing RIGHT:
			if(key.equals("RIGHT") && playerX > 650 && mapStageX < -(endOfMap)) {
				// Move everything to the left:
				player.setTranslateX(player.getTranslateX()-player.getSpeed()/player.getFPS());
				mapStage.setTranslateX(mapStage.getTranslateX()-player.getSpeed()/player.getFPS());
				background.setTranslateX(background.getTranslateX()-(player.getSpeed()/player.getFPS())*0.5);
				moveCollObjs("LEFT");
				moveObjs("LEFT");
			}
			
			// When player is near the beginning of the window and pressing LEFT:
			else if(key.equals("LEFT") && playerX < 250 && mapStageX >= 0) {
				// Move everything to the right:
				player.setTranslateX(player.getTranslateX()+player.getSpeed()/player.getFPS());
				mapStage.setTranslateX(mapStage.getTranslateX()+player.getSpeed()/player.getFPS());
				background.setTranslateX(background.getTranslateX()+(player.getSpeed()/player.getFPS())*0.5);
				moveCollObjs("RIGHT");
				moveObjs("RIGHT");
			}			
		});	
		
		// build timeline
		timeline = new Timeline(keyframe);
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
	}
	
	
	/**
	 * moveCollObjs
	 * @param direction holds the direction in which the 
	 * collision objects would move
	 */
	private void moveCollObjs(String direction) {
		switch(direction) {
		case "LEFT":
			for(int i = 0; i < collObjList.size(); i++) {
				RectangleCollision obj = collObjList.get(i);
				obj.setTranslateX(obj.getTranslateX()-(player.getSpeed()/player.getFPS()));
			}
			break;
			
		case "RIGHT":
			for(int i = 0; i < collObjList.size(); i++) {
				RectangleCollision obj = collObjList.get(i);
				obj.setTranslateX(obj.getTranslateX()+(player.getSpeed()/player.getFPS()));
			}
			break;
		}
	}
	
	/**
	 * moveObjs
	 * @param direction holds the direction in which the regular
	 * objects would move.
	 */
	private void moveObjs(String direction) {
		switch(direction) {
		case "LEFT":
			for(int i = 0; i < nodeList.size(); i++) {
				Node obj = nodeList.get(i);
				obj.setTranslateX(obj.getTranslateX()-(player.getSpeed()/player.getFPS()));
			}
			break;
			
		case "RIGHT":
			for(int i = 0; i < nodeList.size(); i++) {
				Node obj = nodeList.get(i);
				obj.setTranslateX(obj.getTranslateX()+(player.getSpeed()/player.getFPS()));
			}
			break;
		}
	}
	
}
