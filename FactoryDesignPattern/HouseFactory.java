package FactoryDesignPattern;
import java.util.ArrayList;
import java.util.List;

public abstract class HouseFactory {
	
	abstract HouseEntity createHouse(String item);
	
	public HouseEntity buildHouse(String type){

		HouseEntity house = createHouse(type);
        return house;
	
     }
 }

