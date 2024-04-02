package JFXHelper.JavaFXExampleNew;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.shape.Circle;
//renaming to shielding tile
public class ShootingTile extends PlanetTile {
	Circle shield;
	
	public ShootingTile(double x1, double y1, Pane scene1) {
		super(x1, y1, scene1);
		
		this.maxHealth = 200;
		this.health = 200;
	}
	@Override
	public void initTile() {
		shield = new Circle(tileSize*1.5);

	
		shield.setCenterX(x+25);
		shield.setCenterY(y+25);
		this.shield.setFill(new Color(0,1,1,0.2));
		this.shield.setViewOrder(-10000000);
		this.squareItem.setFill(new Color(0.5,0.5,1,1));
		scene.getChildren().add(shield);
	}

}
