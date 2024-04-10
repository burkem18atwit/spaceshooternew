package JFXHelper.JavaFXExampleNew;

import java.util.Collection;

import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public abstract class PlanetTile { //will be an abstract class
	Rectangle squareItem = null;
	Text textItem = null;
	int health;
	int tileSize;
	int maxHealth;
	Boolean exists = false; //whether the object exists or not
	double x, y; //for position on game map
	int tileX,tileY; //for position on array
	Pane scene;
	public PlanetTile(double x1, double y1,Pane scene1,int tileX1,int tileY1) {
		x = x1;
		y = y1;
		tileX = tileX1;
		tileY = tileY1;
		scene = scene1;
	}
	public void init(int tileSize2) {
		tileSize = tileSize2;
		exists = true;
		squareItem = new Rectangle(x,y,0,0);
		squareItem.setWidth(tileSize);
		squareItem.setHeight(tileSize);
		squareItem.setFill(new Color(0.5,0.5,0.5,1));
		squareItem.setStroke(new Color(1.0, 1.0, 1.0, 0.5));
		textItem = new Text(x,y+tileSize/1.5,Integer.toString(health));
		textItem.setTextAlignment(TextAlignment.CENTER);
		textItem.resize(tileSize, tileSize);
		textItem.setFont(Font.font("Courier New", FontWeight.BOLD, tileSize/2));
		
		scene.getChildren().add(squareItem);
		scene.getChildren().add(textItem);
		initTile();
		
		
		
	}
	public void initTile() {
		
	}
	public void damage(int dmg) {
		health -= dmg;
		if (this.textItem != null) {
			this.textItem.setText(Integer.toString(health));
		}
		if (health <= 0) {
			this.destroy();
		}
		if (health > maxHealth) {
			health = maxHealth;
		}
	}
	public void destroy() {
		exists = false;
		Game.tiles[tileX][tileY] = null;
		scene.getChildren().remove(squareItem);
		scene.getChildren().remove(textItem);
		textItem = null;
		
		squareItem = null;
		onDestruction();
	}
	public void onDestruction() {
		
	}
	
}
