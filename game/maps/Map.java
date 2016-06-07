package game.maps;

import java.util.ArrayList;

import game.tools.RectangleCollision;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Map extends Pane {
	private ImageView background;
	private ImageView mapStage;
	private double gravity;
	private ArrayList<RectangleCollision> collisionObjList;
	private ArrayList<Node> nodeList;
	
	
	public Map() {
		
	}
	
}
