import java.util.Arrays;

/*
Subham Behera
Mr. Peterson
AP Computer Science, Period 5
April 5, 2018
 */
public class InsertionSort implements ISorter{
		public InsertionSort() {
			
		}
		public ISortStats sort(int[] arr) {
			long nanosecond1 = System.nanoTime();
			int numComparisons = 0;
			int numMoves = 0;
			for (int i = 1; i < arr.length; i++) {
				int j = i;
				while (j > 0 && arr[j - 1] > arr[j]) {
					numComparisons++;
					int temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
					numMoves += 3;
					j--;
				}
			}
			long nanosecond2 = System.nanoTime();
			return new SortStats("InsertionSort", sortProgram.z, numComparisons, numMoves, nanosecond2 - nanosecond1);
		}
}
