package JFXHelper.JavaFXExampleNew;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.geometry.Point2D;
//TODO: the javadoc
@SuppressWarnings("unused")
public class Game extends Application {
	static int planetDiameter = 10;
	static int appWidth = 1080;
	static int tileSize = 50;
	static int appHeight = 720;
	final double BULLET_RELOAD = 0.5;
	static PlanetTile[][] tiles = new PlanetTile[planetDiameter][planetDiameter];
	private Timeline animation;
	private Timeline op_animation;
	static Lose LoseScreen;
	
	//TODO: fully works now!! lol just need to add a few things
	public static  PlanetTile getTileFromCoords(double x1,double y1) {
		int tileX = (int)	(x1-((-planetDiameter*tileSize)/2+appWidth/2-tileSize/2))/tileSize;
		int tileY = (int) (y1-((-planetDiameter*tileSize)/2+appHeight/2-tileSize/2) )/tileSize;
		if (((tileX >= 0) && (tileX < planetDiameter)) && ((tileY >= 0) && (tileY < planetDiameter))) {
			return tiles[tileX][tileY];
		}
		else {
			return null;
		}
	}
	public static PlanetTile getTile(int x, int y) {
		return tiles[x][y];
	}
	public static void main(String[] args) {
		launch(args);
		
		;}
	@Override
	
	
	public void start(Stage primaryStage) throws Exception {
		
		Pane pane = new Pane();
		Ship littlebugger = new Ship(100,100,pane);
		LoseScreen = new Lose(pane);
		
		//animation = new Timeline(new KeyFrame(Duration.millis(5), e -> {littlebugger.anim();})); //this code spawns in a bullet, will be useful for spaceship
		//animation.setCycleCount(Timeline.INDEFINITE);
		//animation.setRate(Math.pow(0.1, -1));
		//animation.play();
		Pane s = pane;
		s.setOnMouseMoved(e -> {
            littlebugger.angle(e.getSceneX(), e.getSceneY());
        });

        s.setOnMouseDragged(e -> {
            littlebugger.angle(e.getSceneX(), e.getSceneY());
        });

        s.setOnMousePressed(e -> {
            if (e.isSecondaryButtonDown()) {
                littlebugger.accel(true);
            } else if (e.isPrimaryButtonDown()) {
                littlebugger.accel(false);
            }
        });

        s.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.E) {
                littlebugger.accel(false);
            } else if (e.getCode() == KeyCode.SPACE) {
                littlebugger.accel(true);
            }
        });
        animation = new Timeline(new KeyFrame(Duration.millis(5), e -> {littlebugger.accel(true);})); //this code spawns in a bullet, will be useful for spaceship
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.setRate(Math.pow(BULLET_RELOAD*10, -1));
		animation.play();
		
		String[][] tileTypes = new String[planetDiameter][planetDiameter];
		tileTypes[planetDiameter/2+1][planetDiameter/2] = "s";
		tileTypes[planetDiameter/2-1][planetDiameter/2] = "s";
		tileTypes[planetDiameter/2][planetDiameter/2+1] = "s";
		tileTypes[planetDiameter/2][planetDiameter/2-1] = "s";
		
		
		tileTypes[planetDiameter/2+2][planetDiameter/2+2] = "d";
		tileTypes[planetDiameter/2-2][planetDiameter/2-2] = "d";
		tileTypes[planetDiameter/2+2][planetDiameter/2-2] = "d";
		tileTypes[planetDiameter/2-2][planetDiameter/2+2] = "d";
		tileTypes[planetDiameter/2][planetDiameter/2] = "c";
		
		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles.length; j++) {
				if (Math.pow(Math.pow(i-planetDiameter/2.0,2)+Math.pow(j-planetDiameter/2.0,2),0.5) < (planetDiameter)/2.0) {
					int coordx = i*tileSize-(planetDiameter*tileSize)/2+appWidth/2-tileSize/2;
					int coordy = j*tileSize-(planetDiameter*tileSize)/2+appHeight/2-tileSize/2;
					if (tileTypes[i][j] != null) {
						if (tileTypes[i][j] == "s") {
							tiles[i][j] = new ShieldingTile(coordx,coordy,pane,i,j);
							tiles[i][j].init(tileSize);
						}
						if (tileTypes[i][j] == "d") {
							tiles[i][j] = new DeathTile(coordx,coordy,pane,i,j);
							tiles[i][j].init(tileSize);
						}
						if (tileTypes[i][j] == "c") {
							tiles[i][j] = new CapitalTile(coordx,coordy,pane,i,j);
							tiles[i][j].init(tileSize);
						}
					}
					else {
						tiles[i][j] = new NormalTile(coordx,coordy,pane,i,j);
						tiles[i][j].init(tileSize);
						tiles[i][j].initTile();
					}
				}
			}
		}
		
		primaryStage.setTitle("Space Shooter");
		
		primaryStage.setResizable(false);
		primaryStage.setScene(new Scene(pane, 1080, 720));
		
		primaryStage.show();
		
		
		
		animation = new Timeline(new KeyFrame(Duration.millis(50), e -> {Bullet item = new Bullet(littlebugger.top.getX(),littlebugger.top.getY(),littlebugger.angle*Math.PI/180,pane); item.shoot();})); //this code spawns in a bullet, will be useful for spaceship
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.setRate(Math.pow(BULLET_RELOAD*10, -1));
		animation.play();
	}
}
