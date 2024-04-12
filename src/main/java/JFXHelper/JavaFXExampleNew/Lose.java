package JFXHelper.JavaFXExampleNew;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Lose {
	Pane pane;
	Rectangle idk = new Rectangle(0,0,2000,2000);
	
	Text text = new Text();
	public Lose(Pane pane1) {
		text.setText("GAME OVER");
		text.setScaleX(100);
		text.setScaleY(100);
		text.setFont(Font.font("Courier New", FontWeight.BOLD, 100));
		text.setX(400);
		text.setFill(new Color(1,0,0,1));
		text.setY(400);
		pane = pane1;
		idk.setViewOrder(-10000000);
		text.setViewOrder(-100000000);
		
		
	}
	public void LoseCondition() {
		pane.getChildren().add(text);
		pane.getChildren().add(idk);
	}
}
