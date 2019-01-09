package StrategyDesignPattern;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class RandomSweep implements SearchStrategy {
	
	int x;
	int y;
	int gridDimensions = 25;
	Random rand = new Random();
	Point c;
	Point s;
	int cells = 0;
	
	boolean[][] visited = new boolean[25][25];
	
	ArrayList<Point> C = new ArrayList<Point>();
	ArrayList<Point> S = new ArrayList<Point>();
	
	
	@Override
	public void search(String[][] grid) {
		//searching for carriers and submarines using random number generator 
		
		int count = 5;
		while(count > 0) {
			x = rand.nextInt(gridDimensions);
			y = rand.nextInt(gridDimensions);
			cells++;
			if(grid[x][y] == "Carrier") {
				if(visited[x][y] == false){
					visited[x][y] = true;
					c = new Point(x, y);
					C.add(c);
					count--;
				}
			}
			if(C.size() == 5) break;
		}
		int countSub = 3;
		while(countSub > 0) {
			x = rand.nextInt(gridDimensions);
			y = rand.nextInt(gridDimensions);
			cells++;
			if(grid[x][y] == "Submarine") {
				if(visited[x][y] == false){
					visited[x][y] = true;
					s = new Point(x, y);
					S.add(s);
					countSub--;
				} 
			}
			if (S.size() == 3) break;
		}
	}
	
	//sorting by X coordinates
	public void sortX(ArrayList<Point> arr){
		Collections.sort(arr, new Comparator<Point>() {
			public int compare (Point o1, Point o2) {
				return Integer.compare(o1.x, o2.x);
			}
		});
	}

	//sorting by Y coordinates 
	public void sortY(ArrayList<Point> arr){
		Collections.sort(arr, new Comparator<Point>() {
			public int compare (Point o1, Point o2) {
				return Integer.compare(o1.y, o2.y);
			}
		});
	}
	
	@Override
	public void getCarrier(String[][] ar) {		
		
		if(C.get(0).x == C.get(1).x){
			sortY(C);
		}
		else sortX(C);

		System.out.println("Carrier found: (" +  C.get(0).x+ ", " + C.get(0).y + ") "
				+ "to " + "(" + C.get(C.size()-1).x + ", " + C.get(C.size()-1).y + ")");
		
	}
	@Override
	public void getSubmarine(String[][] ar) {
		if(S.get(0).x == S.get(1).x){
			sortY(S);
		}
		else sortX(S);

		System.out.println("Submarine found: (" +  S.get(0).x+ ", " + S.get(0).y + ") "
				+ "to " + "(" + S.get(S.size()-1).x + ", " + S.get(S.size()-1).y + ")");
	}

	@Override
	public void getCells() {
		System.out.println("Number of cells searched: " + cells);
	}

	@Override
	public void getStrategyName() {
		System.out.println("Strategy: Random Sweep");
	}
}
