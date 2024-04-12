package JFXHelper.JavaFXExampleNew;

public class Coordinate {
	int x,y;
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public Coordinate(int tileX, int tileY) {
		int x = tileX;
		int y = tileY;
	}
	
	public boolean equals(Object o) {
		if (this.getClass() == o.getClass()) {
			return(((Coordinate) o).getX() == this.getX() && ((Coordinate) o).getY() == this.getY());
		}
		else {
			return false;
		}
	}
	public int hashCode() {
		return x+y+y*y+x*x;
	}
}
