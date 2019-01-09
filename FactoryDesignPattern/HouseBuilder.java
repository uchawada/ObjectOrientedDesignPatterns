package FactoryDesignPattern;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
/**
 * 
 * This is the main application.  Note that while it is a JavaFX application it doesn't
 * actually "show" the main scene.  We just need the application for the fileChooser.
 */
public class HouseBuilder extends Application{
	
	
	HouseEntity house, block, structure, level;
	//List<HouseEntity> structures = new ArrayList<HouseEntity>();
	/**
	 * Manually construct a house
	 */
	public void buildHouse(){
		HouseFactory areaFactory = new HouseAreaFactory();
		HouseFactory furnitureFactory = new FurnitureFactory();
		
		house = areaFactory.buildHouse("House");
		level = areaFactory.buildHouse("Downstairs");
		structure = areaFactory.buildHouse("Kitchen");
		
		block = furnitureFactory.buildHouse("Sink");
		structure.add(block);
		block = furnitureFactory.buildHouse("Counter");
		structure.add(block);
		
		
		level.add(structure);
		
		
		house.add(level);
		
		//Upstairs
		level = areaFactory.buildHouse("Upstairs");
		structure = areaFactory.buildHouse("Bedroom");
		block = furnitureFactory.buildHouse("Bed");
		structure.add(block);
		block = furnitureFactory.buildHouse("Dresser");
		structure.add(block);
		level.add(structure);
		
		structure = areaFactory.buildHouse("Bathroom");
		block = furnitureFactory.buildHouse("Bathtub");
		structure.add(block);
		
		level.add(structure);
		
		house.add(level);
	}
	
	/**
	 * Save using serialization
	 * @param fileName
	 */
	public void save(String fileName){
		ObjectOutputStream oos;
		try {
	
			oos = new ObjectOutputStream( new FileOutputStream(fileName));
			oos.writeObject(house);  //serializing house
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	 }
	
	public void countHouseContents(){
		System.out.println("House includes: " + house.countContents() + " areas and/or furniture items.");
	}
	
	public void printHouseSpecs(){
		house.listHouseSpecs(0);
	}
	
	public HouseEntity getHouse(){
		return house;
	}
	
	
	/**
	 * Restore from serialized form
	 * @param fileName
	 */
	public void restore(String fileName){
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream( new FileInputStream(fileName));
			house = (HouseArea) ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
	}
	
	public String getFileName(Stage primaryStage){
		 FileChooser fileChooser = new FileChooser();
		 fileChooser.setInitialDirectory(new File("C:\\temp"));  // This is optional
		 fileChooser.setTitle("Serialization File");
		 File file = fileChooser.showOpenDialog(primaryStage);
		 return file.getAbsolutePath();
	}
	
	 public static void main(String[] args) {
		 launch(args);      
	 }

	@Override
	public void start(Stage primaryStage) throws Exception {
		  
		
		
		HouseBuilder houseBuilder = new HouseBuilder();
	    houseBuilder.buildHouse();
	    houseBuilder.save("C:\\temp\\myHouse.ser");
	    String filename = houseBuilder.getFileName(primaryStage);
	    houseBuilder.restore(filename);
	    houseBuilder.printHouseSpecs();
	    houseBuilder.countHouseContents();
	      
	}      	       
}

