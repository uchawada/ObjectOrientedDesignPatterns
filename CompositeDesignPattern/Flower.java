package CompositeDesignPattern;

import java.awt.Point;
import java.util.Random;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Flower implements GardenInterface{
	Point2D point;
	Color color;
	Circle circle;
	Point2D currentLocation;
	boolean inDragMode;
	GardenInterface currentShape;
	Random rand = new Random();
	
	/*
	 * sets the color, center, radius, location for the flower. 
	 */
	public Flower(Point2D point, Color color, boolean inDragMode){
		this.point = point;
		this.color = Color.RED;
		this.inDragMode = inDragMode;
		circle = new Circle();
		circle.setCenterX(point.getX());
		circle.setCenterY(point.getY());
		circle.setRadius(15);
		circle.setFill(color);
		circle.setStroke(Color.BLACK);
		circle.setStrokeWidth(1);
		currentLocation = point;
	}
	
	public Circle getCircle(){
		return circle;
	}
	/*
	 * Independently moves the flower 
	 */
	@Override
	public void move(double dx, double dy) {
		// TODO Auto-generated method stub
		circle.setCenterX(circle.getCenterX()+ dx);
		circle.setCenterY(circle.getCenterY()+ dy);
		currentLocation = new Point2D (circle.getCenterX(), circle.getCenterY());
	}
	//getters for the location and color.  
	public Point2D getCurrentLocation(){
		return currentLocation;
	}
	
	public Color getColor(){
		return color;
	}
	
	public void setColor(String color){
		circle.setFill(Color.web(color));
	}
	
	//checks if a point is contained inside a circle. 
	@Override
	public boolean contains(Point2D point) {
		return circle.contains(point);
		
	}

}
