package StrategyExample;

public class BubbleSort implements SortStrategy {
	
	long startTime;
	long endTime;
	long totalTime;
	
	public long[] sort(long[] ar) {
		startTime = System.currentTimeMillis();
		for (int i = (ar.length - 1); i >= 0; i--)
		   {
		      for (int j = 1; j <= i; j++)
		      {
		         if (ar[j-1] > ar[j])
		         {
		              long temp = ar[j-1];
		              ar[j-1] = ar[j];
		              ar[j] = temp;
		         } 
		       } 
		    } 
		   endTime = System.currentTimeMillis();
		return ar;
		   
	}

	@Override
	public long getSortTime() {
		 long totalTime = endTime - startTime;
		 return totalTime;

	}

	@Override
	public void totalTime() {
		System.out.println("Bubble sort sorts the population in "+ getSortTime()+ " milliseconds!");
		
	}
}

