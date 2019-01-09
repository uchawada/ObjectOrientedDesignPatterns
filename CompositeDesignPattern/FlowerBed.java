package CompositeDesignPattern;
//every geometric shape in java has contains method
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class FlowerBed implements GardenInterface{
	
	Color color;
	Rectangle rect = new Rectangle();
	int h;
	int w;
	GardenInterface currentShape;
	Point2D currentLocation;
	Random rand = new Random();
	double r; 
	double b;
	double g;
	double o;
	

	List<GardenInterface> myShapes = new ArrayList<GardenInterface>();

	
	/*
	 * sets the position, color, height, width, for the flowerBed. 
	 */
	public FlowerBed(Point2D point, int h, int w){
		this.h = h;
		this.w = w;
		r = rand.nextDouble();
		b = rand.nextDouble();
		g = rand.nextDouble();
		o = rand.nextDouble();
		
		rect.setX(point.getX());
		rect.setY(point.getY());
		rect.setWidth(w);
		rect.setHeight(h);
		rect.setFill(null);
		currentLocation = point;
		color = new Color(r,b,g,o);
		rect.setStroke(color);
		rect.setStrokeWidth(5);
		
	}
	//getters for rectangle and color. 
	public Rectangle getRect(){
		return rect;
	}

	public Color getColor(){
		return color;
		
	}
	//adding, removing and getting children.  
	public void addChild(GardenInterface shape){
		myShapes.add(shape);
	}
	public void removeChild(GardenInterface shape){
		if(myShapes.contains(shape)){
			myShapes.remove(shape);
		}
	}
	public GardenInterface getChild(int i){
		return myShapes.get(i);
	}
	//checks if a point is in the flowerBed. 
	public boolean contains(Point2D point){
		return rect.contains(point);
	}
	public Point2D getCurrentLocation(){
		return currentLocation;
	}
	/*
	 * Moves the flowerBed, with its children if any. 
	 */
	@Override
	public void move(double dx, double dy) {
		rect.setX(rect.getX() + dx);
		rect.setY(rect.getY() + dy);
		for(GardenInterface child: myShapes){
			System.out.println("Moving shapes...");
			child.move(dx, dy);
		}
		
		
		
	}
}
