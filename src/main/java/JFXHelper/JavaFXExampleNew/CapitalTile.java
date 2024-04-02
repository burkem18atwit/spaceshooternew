package JFXHelper.JavaFXExampleNew;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class CapitalTile extends PlanetTile {

	public CapitalTile(double x1, double y1, Pane scene1) {
		super(x1, y1, scene1);
		this.health = 500;
		this.maxHealth = 500;
	}
	@Override
	public void initTile() {
		this.squareItem.setFill(new Color(0.5,1,0.5,1));
		
	}
	@Override
	public void onDestruction() {
		//Win condition goes here
	}
	

}
