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
	private ArrayList<RectangleCollision> collisionObjList;
	private ArrayList<Node> nodeList;
	
	// Animation:
	private Timeline timeline;
	
	// Character:
	private game.characters.Character player;

	
/* **********************
 * 	   CONSTRUCTOR
 * **********************/
	public Map(Character player) {
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
	
	
	
/* **********************
 * 	   OTHERS
 * **********************/
	private void buildAnimation() {
		double endOfMap = mapStage.getImage().getWidth();
		
		KeyFrame keyframe = new KeyFrame(Duration.millis(1), e->{
			String key = player.getMoveKey();
			double playerX = player.localToScene(player.getBoundsInLocal()).getMinX();
			double mapStageX = mapStage.localToScene(mapStage.getBoundsInLocal()).getMinX();
						
			if(key.equals("RIGHT") && playerX > 650 && mapStageX < -(endOfMap)) {
				player.setTranslateX(player.getTranslateX()-player.getSpeed()/player.getFPS());
				mapStage.setTranslateX(mapStage.getTranslateX()-player.getSpeed()/player.getFPS());
				background.setTranslateX(background.getTranslateX()-(player.getSpeed()/player.getFPS())*0.5);
			}
			
			else if(key.equals("LEFT") && playerX < 250 && mapStageX >= 0) {
				player.setTranslateX(player.getTranslateX()+player.getSpeed()/player.getFPS());
				mapStage.setTranslateX(mapStage.getTranslateX()+player.getSpeed()/player.getFPS());
				background.setTranslateX(background.getTranslateX()+(player.getSpeed()/player.getFPS())*0.5);
			}			
		});
		
	}
	
}
