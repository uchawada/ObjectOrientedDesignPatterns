package StrategyDesignPattern;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.StringTokenizer;

public class BattleShipSearch {
	
	static int x; static int y;
	static String grid[][] = new String[25][25];
	static int carrier;
	static int submarine;
	
	SearchStrategy searchStrategy;
	
	public BattleShipSearch() {
		searchStrategy = new HorizontalSweep();
	}
	public void setStrategy(SearchStrategy strategy){
		searchStrategy = strategy;
	}

	public static void readFile(String fileName, int lineNumber){
		//read from the file and populate the array. 
		grid = new String[25][25];
		carrier = 0;
		submarine = 0;
		try{
			FileReader input = new FileReader(fileName);
			BufferedReader read = new BufferedReader(input);
			//checking for the line number,
			//line1 = game1, line2 = game, ...
			String line = read.readLine();
			if(lineNumber ==2) {
				line = read.readLine();
			}
			if(lineNumber == 3) {
				line = read.readLine();
				line = read.readLine();
			}

			System.out.println(line);
			StringTokenizer tokenizer = new StringTokenizer(line, "()");
			//reading the file. 
			while(tokenizer.hasMoreTokens()){
				String one = tokenizer.nextToken();
				if(one.trim().length() > 0){
					StringTokenizer tokenizer2 = new StringTokenizer(one, ",");
					String first = tokenizer2.nextToken();
					String second = tokenizer2.nextToken();
					
					x = Integer.parseInt(first);
					y = Integer.parseInt(second);	
				}
				
				carrier++;
				submarine++;
				
				//placing the carriers and submarines 
				if(carrier == 0 ||  carrier <= 5){
					grid[x][y] = "Carrier";	
				}
				else if(submarine == 6 ||  submarine == 7 || submarine == 8){
					grid[x][y] = "Submarine";
				}
			}
			read.close();
			
		}catch(Exception e) {
			e.printStackTrace();		
		}
	}
	
	public void getShips(){
		searchStrategy.search(grid);
		searchStrategy.getStrategyName();
		searchStrategy.getCells();
		searchStrategy.getCarrier(grid);
		searchStrategy.getSubmarine(grid);
	}
	
	public static void printFile(int lineNumber){
		//printing the searched carriers and submarines. 
		System.out.println("..........GAME "+ lineNumber + "..........");
		readFile("src\\assign1\\input.txt", lineNumber);
		System.out.println();
		
		BattleShipSearch battleShipSearch = new BattleShipSearch();
		
		battleShipSearch.setStrategy(new HorizontalSweep());
		battleShipSearch.getShips();
		System.out.println();
		battleShipSearch.setStrategy(new RandomSweep());
		battleShipSearch.getShips();
		System.out.println();
		battleShipSearch.setStrategy(new StrategySweep());
		battleShipSearch.getShips();	
	}
	public static void main(String[] args) throws FileNotFoundException{
		
		printFile(1);
		printFile(2);
		printFile(3);		
	}
}