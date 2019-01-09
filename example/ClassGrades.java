package example;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


public class ClassGrades {
	Map<String,String> classList = new HashMap<String,String>();

	public ClassGrades(){
		classList.put("Bob", "A");
		classList.put("Mary", "C");
		classList.put("Sarah", "B");
		classList.put("Philip", "A");
		classList.put("Greg", "F");
	}

	public void printClassList(){
		Iterator<Entry<String,String>> entries = classList.entrySet().iterator();
		while(entries.hasNext()){
			Entry<String,String> entry = entries.next();
			System.out.println("Key = "+ entry.getKey() + ", Value = " + entry.getValue());
		}
	}
	
	public void printClassList2(){
		for(Map.Entry<String, String> entry : classList.entrySet()){
			System.out.println("Key = "+ entry.getKey() + ", Value = " + entry.getValue());
		}
		
		//iterating over the keys only 
		for(String key : classList.keySet())
			System.out.println("Key = " + key);
		
		//iterating over the values only 
		for(String value : classList.values())
			System.out.println("Key = " + value);
	}
	
	public static void main(String[] args){
		ClassGrades myClassList = new ClassGrades();
		myClassList.printClassList();
		myClassList.printClassList2();
	}
}
