package JFXHelper.JavaFXExampleNew;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class pong extends Application {
private static int player_score = 0;
private static int opponent_score = 0;
final static Text pl_score_text = new Text(170, 120,
Integer.toString(player_score));
final static Text op_score_text = new Text(400, 120,
Integer.toString(opponent_score));
private static double ball_x = 282;
private static double ball_y = 282;
private static double ball_width = 25;
private static double ball_height = 25;
private static double ball_dx = 0.5;
private static double ball_dy = 1;
private static double player_x = 10;
private static double player_y = 10;
private static double player_width = 10;
private static double player_height = 140;
private static double opponent_x = 570;
private static double opponent_y = 10;
private static double opponent_width = 10;
private static double opponent_height = 140;
final static Rectangle ball = new Rectangle(ball_x,ball_y,ball_width,ball_height);
final static Rectangle player = new
Rectangle(player_x,player_y,player_width,player_height);
final static Rectangle opponent = new
Rectangle(opponent_x,opponent_y,opponent_width,opponent_height);
private Timeline animation;
private Timeline op_animation;
public static void main(String[] args) {launch(args);}
private static void moveBall() {
if (ball_y < 0 || ball_y+ball_height > 600) ball_dy *= -1;
if (ball_x - (player_x + player_width) < 0.1) {
if (ball_y < player.getY() + player_height &&
ball_y + ball_height > player.getY())
ball_dx *= -1;
}
if (ball_x + ball_width < 0) {
ball_x = 282;
ball_y = 282;
op_score_text.setText(Integer.toString(++opponent_score));
}
if (opponent_x - (ball_x + ball_width) < 0.1) {
if (ball_y < opponent.getY() + opponent_height &&
ball_y + ball_height > opponent.getY()) {
ball_dx *= -1;
}
}
if (ball_x > 600) {
ball_x = 282;
ball_y = 282;
pl_score_text.setText(Integer.toString(++player_score));
}
ball_x += ball_dx;
ball_y += ball_dy;
ball.setX(ball_x);
ball.setY(ball_y);
}
private static void moveOpponent() {
double paddle_center_y = opponent_y + (opponent_height*0.5);
double ball_center_y = ball_y + (ball_height*0.5);
//if (opponent.getY() > 20 && opponent.getY() < 440) {
if (ball_center_y > paddle_center_y) ++opponent_y;
if (ball_center_y < paddle_center_y) --opponent_y;
//}
opponent.setY(opponent_y);
}
@Override
public void start(Stage primaryStage) throws Exception {
Pane pane = new Pane();
pane.setStyle("-fx-background-color: black;");
player.setFill(Color.WHITE);
player.setOnKeyPressed(e -> {
switch (e.getCode()) {
case UP:
if (player.getY() > 20) {
player.setY(player.getY() - 10);
}
break;
case DOWN:
if (player.getY() < 440) {
player.setY(player.getY() + 10);
}
break;
default:
break;
}
});
opponent.setFill(Color.WHITE);
ball.setFill(Color.GREEN);
pl_score_text.setFont(Font.font("Courier New", FontWeight.BOLD, 50));
pl_score_text.setFill(Color.WHITE);
pl_score_text.setStroke(Color.GREEN);
op_score_text.setFont(Font.font("Courier New", FontWeight.BOLD, 50));
op_score_text.setFill(Color.WHITE);
op_score_text.setStroke(Color.GREEN);
animation = new Timeline(new KeyFrame(Duration.millis(50), e -> moveBall()));
animation.setCycleCount(Timeline.INDEFINITE);
animation.setRate(20.0);
animation.play();
op_animation = new Timeline(
new KeyFrame(Duration.millis(50), e -> moveOpponent()));
op_animation.setCycleCount(Timeline.INDEFINITE);
op_animation.setRate(10.0);
op_animation.play();
final Line net = new Line(300,0,300,600);
net.setStrokeWidth(3);
net.setStroke(new Color(1.0, 1.0, 1.0, 0.5));
pane.getChildren().add(player);
pane.getChildren().add(ball);
pane.getChildren().add(opponent);
pane.getChildren().add(pl_score_text);
pane.getChildren().add(op_score_text);
pane.getChildren().add(net);
primaryStage.setTitle("PONG");
primaryStage.setResizable(false);
primaryStage.setScene(new Scene(pane, 600, 600));
primaryStage.show();
player.requestFocus();
}
}