package FactoryDesignPattern;
import java.util.List;

public class HouseAreaFactory extends HouseFactory{

	@Override
HouseEntity createHouse(String item) {
		if (item.equals("House")) {
			return new HouseArea("House");
		}
		if (item.equals("Kitchen")) {
			return new HouseArea("Kitchen");
		} else if (item.equals("Bedroom")) {
			return new HouseArea("Bedroom");
		} else if (item.equals("Bathroom")) {
			return new HouseArea("Bathroom");
		} else if (item.equals("Downstairs")) {	
			return new HouseArea("Downstairs");
		}else if (item.equals("Upstairs")) {
			return new HouseArea("Upstairs");	
		} else return null;
		
	}
}
