package CompositeDesignPattern;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

public interface GardenInterface {
	public void move(double dx, double dy);
	public boolean contains(Point2D point);
	public Color getColor();
	
}
