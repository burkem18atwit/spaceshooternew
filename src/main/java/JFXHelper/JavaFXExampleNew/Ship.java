package JFXHelper.JavaFXExampleNew;

import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ship {
	public int x;
	public int y;
	public double v = 0;
	public int angle = 0;

	public Ship(int x, int y) {
		this.x = x;
		this.y = y;

		Rectangle top = new Rectangle(500, 500, 100, 100);
	}

	public void angle(double mx, double my) {
		this.angle = (int)(180*(1/Math.PI)*Math.atan((this.y-my)/(this.x-mx)));
	}
	
	public void accel() {
		
	}
}