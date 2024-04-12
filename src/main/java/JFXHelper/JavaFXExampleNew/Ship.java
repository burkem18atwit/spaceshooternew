package JFXHelper.JavaFXExampleNew;

import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.KeyCode;
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
	public int angle = 0;
	Point2D vel2D = new Point2D(0, 0);
	public double vMax = 5;
	Rectangle top;
	Pane s;

	public Ship(int x, int y, Pane pane) {
		this.x = x;
		this.y = y;
		
		top = new Rectangle(x, y, 30, 30);
		top.setStroke(Color.RED);
		top.setFill(Color.RED);
		pane.getChildren().add(top);
		s = pane;
	}
	
	public void angle(double mx, double my) {
		this.angle = (int)(180*(1/Math.PI)*Math.atan((top.getY()-my)/(top.getX()-mx)));
		if (mx < top.getX()+5) {
			this.angle -= 180;
		}
		System.out.println(angle);
		
		top.setRotate(angle);
		
	}
	
	public void accel(boolean slowdown) {
		vel2D = vel2D.add(Math.cos(Math.PI/180*angle), Math.sin(Math.PI/180*angle));
	
		double vel = vel2D.magnitude();
		double velDir = angle;
		if (vel > 3) {
			vel2D = new Point2D(Clamp.clamp(vel2D.getX(), -vMax*Math.cos((Math.PI/180)*velDir), -vMax*Math.cos((Math.PI/180)*velDir)), Clamp.clamp(vel2D.getY(), -vMax*Math.sin(Math.PI/180*velDir), -vMax*Math.sin(Math.PI/180*velDir)));
		}
		
		top.setX(top.getX()-vel2D.getX());
		top.setY(top.getY()-vel2D.getY());
		if (Game.getTileFromCoords(top.getX(),top.getY()) != null) {
			Game.LoseScreen.LoseCondition();
		}
	}
}