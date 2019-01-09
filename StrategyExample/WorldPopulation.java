package StrategyExample;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.util.StringTokenizer;

public class WorldPopulation {

	SortStrategy sortStrategy;
	long[] population = new long[13484]; // Cheating because we know number of records!!
		
	// Lab Exercise:  After creating some strategy classes -- set the default strategy here.
	public WorldPopulation(){
		sortStrategy = new SelectionSort(); // Set the default strategy here.	
	}
	
	public void readInputFile(){
		population = readPopulationFile("src\\lab1\\WorldPopulation.csv");
	}
	
	public void setStrategy(SortStrategy strategy){
		sortStrategy = strategy;
	}
	
	// Lab Exercise:  Read in the WorldPopulation.csv
	// Extract ONLY the numbers and store them into population[]
	public long[] readPopulationFile(String fileName){
		
		int count = 0;
		try{
			FileReader input = new FileReader(fileName);
			BufferedReader read = new BufferedReader(input);
			String line;
			
			while((line = read.readLine()) != null){
				
				StringTokenizer tokenizer = new StringTokenizer(line, ",");
				tokenizer.nextToken();
				tokenizer.nextToken();
				population[count++] = Long.parseLong(tokenizer.nextToken());
				//System.out.println(population[count]);
				
			}	
			read.close();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return population;
	}
	
	// Lab Exercise.  Complete this method.
	// Delegate sorting to the strategy object
	public void sortPopulation(){	
		sortStrategy.sort(population);
		sortStrategy.totalTime();
	}
	
	public void computeTotalPopulation(){
		System.out.println("dd");
	}
	
	// Experiment with various strategies.
	// Create 3 strategies -- Bubble, insertion, and selection sort.
	public static void main(String[] args) {
		WorldPopulation worldPopulation = new WorldPopulation();
		
		worldPopulation.readInputFile();
		worldPopulation.setStrategy(new SelectionSort()); //  Currently no strategies.
		worldPopulation.sortPopulation();	
		
		worldPopulation.readInputFile();
		worldPopulation.setStrategy(new InsertionSort()); //  Currently no strategies.
		worldPopulation.sortPopulation();	
		
		worldPopulation.readInputFile();
		worldPopulation.setStrategy(new BubbleSort()); //  Currently no strategies.
		worldPopulation.sortPopulation();	
	}

}
