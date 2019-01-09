package StrategyExample;

public class SelectionSort implements SortStrategy {
	
	long startTime;
	long endTime;
	long totalTime;
		
	@Override
	public long[] sort(long[] numbers) {
		startTime = System.currentTimeMillis();
		 for (int i = 0; i < numbers.length-1; i++)
		   {
		      int min = i;
		      for (int j = i+1; j < numbers.length; j++)
		            if (numbers[j] < numbers[min]) min = j;
		      long temp = numbers[i];
		      numbers[i] = numbers[min];
		      numbers[min] = temp;
		   } 
		 endTime = System.currentTimeMillis();
		 return numbers;
		
	}

	@Override
	public long getSortTime() {
		totalTime = endTime - startTime;
		return totalTime;
	}

	public void totalTime() {
		System.out.println("Selection sort sorts the population in "+ getSortTime()+ " milliseconds!");
		
	}

}
