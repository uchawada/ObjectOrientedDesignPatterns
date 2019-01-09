package StrategyDesignPattern;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StrategySweep implements SearchStrategy{

	boolean[][] visited = new boolean[25][25];
	Point c;
	Point s;
	int cells;
	ArrayList<Point> C = new ArrayList<Point>();
	ArrayList<Point> S = new ArrayList<Point>();
	
	@Override
	public void search(String[][] ar) {
		//For carriers ...
		/*incrementing i by 5, as the length of carrier is 5, so one of 
		 X coordinates should be divisible by 5. */
		for(int i = 0; i < ar.length; i+=5){
			for(int j = 0; j < ar.length; j++){
				cells++;
				if(visited[i][j] == false){
					visited[i][j] = true;
					if (ar[i][j] == "Carrier"){
						c = new Point(i, j);
						C.add(c);
					}
					if (C.size() == 5) break;
				}
			}
		}	
		
		//For Submarines ...
		//incrementing i by 4, as all X coordinates are divisible by 4. 
		for(int i = 0; i < ar.length; i+=4){
			for(int j = 0; j < ar.length; j++){
				cells ++;
				if(visited[i][j] == false){
					visited[i][j] = true;
					if (ar[i][j] == "Submarine"){
						s = new Point(i, j);
						S.add(s);
					}
					if (S.size() == 3) break;
				}
			}
		}
	}

	@Override
	public void getCarrier(String[][] ar) {
		
		if(C.size() == 5){
			System.out.println("Carrier found: (" +  C.get(0).x+ ", " + C.get(0).y + ") "
			+ "to " + "(" + C.get(C.size()-1).x + ", " + C.get(C.size()-1).y + ")");
		}
		else {
			Point a = new Point();
			ArrayList<Point> Carrier = new ArrayList<Point>();
		
			a.setLocation(C.get(0).x, C.get(0).y);
			Carrier.add(a);
			
			/*checking if the carrier is horizontal or vertical, 
			 *  and adding coordinates to the arrayList C accordingly. 
			 *  the coordinates should be in increasing order as we start
			 *  from 00 and go till 25,25 */
			
			if(ar[C.get(0).x + 1][C.get(0).y] == "Carrier"){
				
				a.setLocation(C.get(0).x + 1,C.get(0).y);
				C.add(a);
				a.setLocation(C.get(0).x + 2,C.get(0).y);
				C.add(a);
				a.setLocation(C.get(0).x + 3,C.get(0).y);
				C.add(a);
				a.setLocation(C.get(0).x + 4,C.get(0).y);
				C.add(a);	
				}
				
			else if(ar[C.get(0).x][C.get(0).y+1] == "Carrier"){
				a.setLocation(C.get(0).x ,C.get(0).y+1);
				C.add(a);
				a.setLocation(C.get(0).x ,C.get(0).y+2);
				C.add(a);
				a.setLocation(C.get(0).x ,C.get(0).y+3);
				C.add(a);
				a.setLocation(C.get(0).x ,C.get(0).y+4);
				C.add(a);
			} 
			
			System.out.println("Carrier found: (" +  C.get(0).x+ ", " + C.get(0).y + ") "
					+ "to " + "(" + C.get(C.size()-1).x + ", " + C.get(C.size()-1).y + ")");;
		}
	}
	@Override
	public void getSubmarine(String[][] ar) {
		if(S.size() == 3){
			System.out.println("Submarine found: (" +  S.get(0).x+ ", " + S.get(0).y + ") "
			+ "to " + "(" + S.get(S.size()-1).x + ", " + S.get(S.size()-1).y + ")");;
		}
		else {
			Point a = new Point();
			ArrayList<Point> Submarine = new ArrayList<Point>();
			a.setLocation(S.get(0).x, S.get(0).y);
			
			if(ar[C.get(0).x + 1][C.get(0).y] == "Submarine"){	
				a.setLocation(C.get(0).x + 1,C.get(0).y);
				C.add(a);
				a.setLocation(C.get(0).x + 2,C.get(0).y);
				C.add(a);
				}
				
			else if(ar[C.get(0).x][C.get(0).y+1] == "Submarine"){
				a.setLocation(C.get(0).x ,C.get(0).y+1);
				C.add(a);
				a.setLocation(C.get(0).x ,C.get(0).y+2);
				C.add(a);
			} 
		}
	}
	@Override
	public void getCells() {
		System.out.println("Number of cells searched: " + cells);
		
	}
	@Override
	public void getStrategyName() {
		System.out.println("Strategy: Strategy Sweep");
	}
}
