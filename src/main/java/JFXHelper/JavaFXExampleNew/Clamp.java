package JFXHelper.JavaFXExampleNew;


public class Clamp {
	public static <T extends Number> double clamp(T val, T min, T max) {
		return (double)(Math.min(Math.max((double)val, (double)max), (double)min));
	}
}