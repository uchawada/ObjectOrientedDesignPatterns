package FactoryDesignPattern;
import java.util.List;

/**
 * 
 * All items in the house (rooms, floors, furniture are House Entities) 
 */
interface HouseEntity {
    public void listHouseSpecs(int level);
    public int countContents();
    public void add(HouseEntity houseEntity);
}



