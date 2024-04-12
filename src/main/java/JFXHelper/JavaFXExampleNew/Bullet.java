package JFXHelper.JavaFXExampleNew;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
public class Bullet {
	private Timeline animation;
	private Timeline op_animation;
	double ball_x = 0, ball_y = 0, ball_dx = 0, ball_dy = 0; //ball dx, dy = rotation values for that lol
	Circle ball = new Circle(0, 0, 0);
	Pane pane = null;
	int bullet_speed = 2;
	PlanetTile tileHit = null;
	public Bullet(double x, double y,double r,Pane pane1) {
		ball_x = x;
		ball_y = y;
		ball.setCenterX(x);
		ball.setCenterY(x);
		ball.setRadius(10);
		ball_dx = Math.cos(r)*bullet_speed;
		ball_dy = Math.sin(r)*bullet_speed;
		ball.setFill(new Color(0,0,0,1));
		pane = pane1;
		pane.getChildren().add(ball);
		
	}
	public void shoot() {
		animation = new Timeline(new KeyFrame(Duration.millis(50), e -> this.moveBullet()));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.setRate(20.0);
		animation.play();
	}
	public void moveBullet() {
		tileHit = Game.getTileFromCoords(ball_x, ball_y);
		if ((tileHit != null)) {
			tileHit = Game.getTileFromCoords(ball_x+ball_dx*2, ball_y+ball_dy*2);
			tileHit.damage(10);
			System.out.println("tile damaged");
			pane.getChildren().remove(ball);
			animation.stop();
			ball = null;
			
		}
		if (ball != null) {
			ball_x += ball_dx;
			ball_y += ball_dy;
			ball.setCenterX(ball_x + ball_dx);
			ball.setCenterY(ball_y + ball_dy);
			
		}
	}
}
