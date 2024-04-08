package JFXHelper.JavaFXExampleNew;

import javafx.scene.layout.Pane;

public class NormalTile extends PlanetTile {
	
	public NormalTile(double x1, double y1, Pane scene1, int tx, int ty) {
		
		super(x1, y1, scene1,tx,ty);
		this.health = 100;
		this.maxHealth = 100;
		
	}
	
}
