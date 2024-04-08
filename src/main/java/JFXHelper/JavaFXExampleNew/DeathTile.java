package JFXHelper.JavaFXExampleNew;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class DeathTile extends PlanetTile {
	public DeathTile(double x1, double y1, Pane scene1,int tx, int ty) {
		super(x1, y1, scene1, tx, ty);
		this.health = 1;
		this.maxHealth = 1;
		// TODO Auto-generated constructor stub
	}

	//when this tile dies the player loses a lot of health haha
	@Override
	public void initTile() {
		this.squareItem.setFill(new Color(1,0.5,0.5,1));
	}
	@Override
	public void onDestruction() {
		//thing that reduces player health goes here
	}
}
