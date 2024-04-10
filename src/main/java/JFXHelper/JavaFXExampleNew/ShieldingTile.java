package JFXHelper.JavaFXExampleNew;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;
import javafx.scene.shape.Circle;
//renaming to shielding tile
public class ShieldingTile extends PlanetTile {
	Circle shield;
	private Timeline animation;
	private Timeline op_animation;
	public ShieldingTile(double x1, double y1, Pane scene1,int tx, int ty) {
		super(x1, y1, scene1,tx,ty);
		
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
		
		animation = new Timeline(new KeyFrame(Duration.millis(50), e -> {heal();})); //this code spawns in a bullet, will be useful for spaceship
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.setRate(0.25);
		animation.play();
	}
	public void heal() {
		PlanetTile[] tiles = new PlanetTile[] {(Game.getTile(tileY, tileX-1)),(Game.getTile(tileY, tileX+1)),(Game.getTile(tileY+1, tileX)),(Game.getTile(tileY-1, tileX))};
		for (int i = 0; i < tiles.length; i++) {
			if (tiles[i] != null) {
				
			}
		}
	}
	public void onDestruction() {
		scene.getChildren().remove(shield);
	}

}
