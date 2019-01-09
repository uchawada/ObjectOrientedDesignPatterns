package maze;
import java.awt.Point;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Seeker {
	
	Circle circle;
	int xCell;
	int yCell;
	int unitSize; //scaling factor
	Maze maze;
	
	
	public Seeker(int x, int y, int unitSize, Maze maze) {
		
		xCell = x;
	    yCell = y;
	    circle = new Circle(unitSize/2);
	    circle.setCenterX(x*unitSize+unitSize/2);
	    circle.setCenterY(y*unitSize+unitSize/2);
	    this.unitSize = unitSize;
	    this.maze = maze;
		
	}
	
	
	public void setColor(Color color) {
		
		circle.setFill(color);
		
	}
	private void setCircleX(int cx) {
			
			circle.setCenterX(computeDisplayPosition(cx));
	}
	
	private void setCircleY(int cy) {
		
		circle.setCenterY(computeDisplayPosition(cy));
	}
	
	private int computeDisplayPosition(int gridCoordinate) {
		
		return(gridCoordinate*unitSize+unitSize/2);
	}
	
	public void moveRight() {
		
		if(maze.east[xCell][yCell] == false)
			xCell++;
			setCircleX(xCell);	
	}
	public void moveLeft() {
		
		if(maze.west[xCell][yCell] == false)
			xCell--;
			setCircleX(xCell);	
	}
	public void moveUp() {
		
		if(maze.south[xCell][yCell] == false)
			yCell--;
			setCircleY(yCell);	
	}
	public void moveDown() {
			
			if(maze.north[xCell][yCell] == false)
				yCell++;
				setCircleY(yCell);	
	}
	public Circle getCircle() {
		return circle;
	}
	public Point getCurrentLocation() {
		return new Point(xCell,yCell);
	}
}
