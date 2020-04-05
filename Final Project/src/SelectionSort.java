import java.util.Arrays;

/*
Subham Behera
Mr. Peterson
AP Computer Science, Period 5
April 5, 2018
 */
public class SelectionSort implements ISorter{
	public SelectionSort() {
		
	}
	public ISortStats sort(int[] arr) {
		int comparisons = 0;
		int moves = 0;
		long start = System.nanoTime();
		for (int i = 0; i < arr.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
				comparisons++;
			}
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
			moves += 3;
		}
		long finish = System.nanoTime();
		return new SortStats("SelectionSort", sortProgram.z, comparisons, moves, finish - start);
	}
}
