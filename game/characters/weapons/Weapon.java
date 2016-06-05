package game.characters.weapons;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Weapon extends Pane{
	private Image sprite;
	private ImageView weapon;
	public Weapon(Rectangle2D frame) {
		sprite = new Image(Weapon.class.getResourceAsStream("../../images/ShootMathSprite.png"));
		weapon = new ImageView(sprite);
		weapon.setViewport(frame);
		
		this.getChildren().add(weapon);
	}
	
}
