package example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ClassList {
	
	List<String> classList = new LinkedList<String>();
	
	public ClassList(){
		classList.add("Bob");
		classList.add("Mary");
		classList.add("Sarah");
		classList.add("Philip");
		classList.add("Greg");
	}
	
	public void printClassList(){
		Iterator<String> iterator = classList.iterator();
		while(iterator.hasNext()){
			String name = iterator.next();
			System.out.println(name);
		}
	}
	
	public void printClassList2(){
		for(String name: classList)
			System.out.println(name);
	}
	public static void main(String[] args){
		ClassList myClassList = new ClassList();
		myClassList.printClassList();
	}
}
