package StrategyDesignPattern;

import java.awt.Point;
import java.util.ArrayList;

public class HorizontalSweep implements SearchStrategy {
	
	ArrayList<Point> C = new ArrayList<Point>();
	Point c = new Point();
	ArrayList<Point> S = new ArrayList<Point>();
	Point s = new Point();
	int cells = 0;
	
	@Override
	public void search(String[][] grid) {
	//searching for carriers 
		for(int i = 0; i < 25; i++){
			for(int j = 0; j < 25; j++){
				cells++;
				if (grid[i][j] == "Carrier"){
					c = new Point(i,j);
					C.add(c);
				}
				if(C.size() == 5) break;
			}
		}
		//searching for submarines
		for(int i = 0; i < 25; i++){
			for(int j = 0; j < 25; j++){				
				cells++;
				if (grid[i][j] == "Submarine"){
					s = new Point(i,j);
					S.add(s);
				}
				if(S.size() == 3) break;
			}
		}
	}
	
	//printing carriers and submarines
	@Override
	public void getCarrier(String[][] ar){
		System.out.println("Carrier found: (" +  C.get(0).x+ ", " + C.get(0).y + ") "
				+ "to " + "(" + C.get(C.size()-1).x + ", " + C.get(C.size()-1).y + ")");
	}

	@Override
	public void getSubmarine(String[][] ar) {
		System.out.println("Submarine found: (" +  S.get(0).x+ ", " + S.get(0).y + ") "
				+ "to " + "(" + S.get(S.size()-1).x + ", " + S.get(S.size()-1).y + ")");		
	}

	@Override
	public void getCells() {
		System.out.println("Number of cells searched: " + cells);
	}

	@Override
	public void getStrategyName() {
		System.out.println("Strategy: Horizontal Sweep");
	}

	
}
