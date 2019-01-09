package CompositeDesignPattern;

import java.util.List;
import java.util.ArrayList;
// write a general case or for s 
//check if in rect or in flower
//using contains - change it to that shape
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GardenLayout extends Application {
	AnchorPane root;
	Scene scene;
	Flower flower;
	FlowerBed flowerBed;
	Point2D lastPosition = null;
	Point2D clickPoint;
	GardenInterface currentShape;
	boolean inDragMode;
	List<GardenInterface> myComponents = new ArrayList<GardenInterface>();
		
	//launches the GUI 
	public static void main(String[] args){
		launch(args);
	}	
		
	/*sets the root, scene, flower, flowerBed, also sets the 
	Event handlers that handles the movements and the drags.*/ 
	public void start(Stage gardenStage) throws Exception{
		root = new AnchorPane();
		scene = new Scene(root, 500, 500);
		scene.setFill(null);
		
		gardenStage.setScene(scene);
		gardenStage.setTitle("Garden Layout");
		
		//default flowers and flowerBed. 
        flowerBed = new FlowerBed(new Point2D(200,350), 200, 150);
		flower = new Flower(new Point2D(10,10), Color.BLACK,true);
		currentShape = flower;
		gardenStage.show();
		inDragMode = false;
		
		EventHandler<MouseEvent> mouseHandler = new EventHandler<MouseEvent>(){
			
			@Override
			public void handle(MouseEvent mouseEvent) {
				Point2D clickPoint = new Point2D(mouseEvent.getX(), mouseEvent.getY());
				//System.out.println(clickPoint.getX() + " " + clickPoint.getY());
				String eventName = mouseEvent.getEventType().getName();
				
				//currentShape = getCurrentShape();
				if(!inDragMode){
					currentShape = getCurrentShape();
				}
				System.out.println("mouse event:" + eventName);
				
				switch(eventName){
				
				/*
				 * if the mouse is dragged, it sets the deltas by subtracting lastPosition from clickPoint 
				 */
				case("MOUSE_DRAGGED"):
					inDragMode = true;
					if(lastPosition != null){
						System.out.println("Dragging...");
						double deltaX = clickPoint.getX() - lastPosition.getX();
						double deltaY = clickPoint.getY() - lastPosition.getY();
						System.out.println("Flower location = "+ flower.getCurrentLocation());
						
						//for all shapes in the interface ArrayList, it moves them. 
						for(GardenInterface shape: myComponents){
							if(shape.contains(lastPosition)){
								shape.move(deltaX, deltaY);
							}
						}
						break;
					}
				case("MOUSE_RELEASED"):
					inDragMode = false;					
					if(currentShape == null){
						
						clickPoint = new Point2D(mouseEvent.getX(), mouseEvent.getY());
						/*
						 * if the mouse if left clicked, it creates a flower(circle), adds the created flower to 
						 * the ArrayList, and places that on the scene. 
						 */
						if(mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
					           //do nothing
					           flower = new Flower(new Point2D(mouseEvent.getScreenX(),mouseEvent.getScreenY()), Color.BLACK,true);
						       myComponents.add(flower);
						       //currentShape = flower;
						       root.getChildren().add(((Flower) flower).getCircle());
					         }
						/*
						 * if the mouse is right clicked, it creates a flowerBed(rect), adds the created flowerBed
						 * to the ArrayList, and places that on the scene.
						 */
						else if(mouseEvent.getButton().equals(MouseButton.SECONDARY)) {
			     		    flowerBed = new FlowerBed(new Point2D(mouseEvent.getScreenX(),mouseEvent.getScreenY()), 125, 100);
				       		myComponents.add(flowerBed);
				       		//currentShape = flowerBed;
				       		root.getChildren().add(((FlowerBed) flowerBed).getRect());
						 }
						 
					}
		         	/*
		         	 * checks the shape and if it's not null, performs the operations. 
		         	 */
					if(currentShape != null && currentShape instanceof Flower){
						for(GardenInterface flowerBed: myComponents){
							/*
							 * if flower is dragged in the flowerBed, the child is added to the flowerBed, 
							 * and its color is changed to the flowerBed's color. 
							 */
							if(flowerBed instanceof FlowerBed && flowerBed.contains(clickPoint)==true){
								((Flower) getCurrentShape()).setColor(flowerBed.getColor().toString());
								((FlowerBed) flowerBed).addChild(getCurrentShape());
							}
							/*
							 * if flower is dragged out of flowerBed, the child is removed and the color 
							 * is changed to default. 
							 */
							else if(flowerBed instanceof FlowerBed && flowerBed.contains(clickPoint) == false){
								((FlowerBed) flowerBed).removeChild(getCurrentShape());
								((Flower) getCurrentShape()).setColor(Color.BLACK.toString());
							}
						}
					}
			
					break;
				}	
				lastPosition = clickPoint;
			}
		};
		
		/*
		 * sets all the mouseHandlers on the scene. 
		 */
		scene.setOnMouseDragged(mouseHandler);
		scene.setOnMouseReleased(mouseHandler);
		scene.setOnMouseClicked(mouseHandler);
		scene.setOnMousePressed(mouseHandler);
		scene.setOnMouseDragOver(mouseHandler);
	}

	/*
	 * gets the currentShape of the shape clicked on. 
	 */
	public GardenInterface getCurrentShape() {
		currentShape = null;
		for(GardenInterface shape: myComponents){
			if(shape.contains(lastPosition)){
				currentShape = shape;
				break;
			}
		}
		return currentShape;
	}
}