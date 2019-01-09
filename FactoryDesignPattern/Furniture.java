package FactoryDesignPattern;
import java.io.Serializable;
import java.util.List;

/**
 * 
 * Composite pattern:  Leaf node
 */
class Furniture implements Serializable, HouseEntity {
	private static final long serialVersionUID = 1L;
	String blockName;
	public Furniture(String blockName){
		this.blockName = blockName;
	}
	
 	@Override
	public void listHouseSpecs(int level) {
		StringBuffer sb = new StringBuffer();
		for(int j = 0; j < level; j++)
			sb.append("   ");			
		System.out.println(sb.toString() + blockName);		
	}

	@Override
	public int countContents() {
		return 1;
	}

	@Override
	public void add(HouseEntity entity) {
		// TODO Auto-generated method stub
	} 
}