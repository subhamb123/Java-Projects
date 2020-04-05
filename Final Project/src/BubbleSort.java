import java.util.Arrays;

/*
Subham Behera
Mr. Peterson
AP Computer Science, Period 5
April 5, 2018
 */
public class BubbleSort implements ISorter{
	public BubbleSort() {
		
	}
	public ISortStats sort(int[] arr) {
		int comparisons = 0;
		int move = 0;
		long nanosec = System.nanoTime();
		for(int i = 0; i < arr.length; i++) {
			for(int j = i+1; j < arr.length; j++) {
				comparisons++;
				if(arr[i]>arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}	
		nanosec = System.nanoTime() - nanosec;
		return new SortStats(this.getClass().getName(), sortProgram.z, comparisons, move, nanosec);
	}
}
