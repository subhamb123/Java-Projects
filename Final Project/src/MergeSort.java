/*
Subham Behera
Mr. Peterson
AP Computer Science, Period 5
April 5, 2018
 */
import java.util.*;
public class MergeSort implements ISorter{
	int numComparisons;
	int numMoves;
	long numNanoSeconds;
	public void mergeSort(int[] x) {
		if(x.length > 1) {
			int[] left = Arrays.copyOfRange(x,  0,  x.length / 2);
			int[] right = Arrays.copyOfRange(x,  x.length / 2, x.length);
			
			mergeSort(left);
			numMoves++;
			mergeSort(right);
			numMoves++;
			merge(x, left, right);
		}
	}
	
	public void merge(int[] result, int[] left, int[] right) {
		int i1 = 0;
		int i2 = 0;
		
		for(int i = 0; i<result.length; i++) {
			if(i2 >= right.length || (i1 < left.length && left[i1] <= right[i2])) {
				result[i] = left[i1];
				i1++;
				numMoves++;
				numComparisons++;
			}
			else {
				result[i] = right[i2];
				i2++;
				numMoves++;
				numComparisons++;
			}
		}
	}

	@Override
	public ISortStats sort(int[] a) {
		long first = System.nanoTime();
		mergeSort(a);
		long last = System.nanoTime();
		numNanoSeconds = last - first;
		SortStats x = new SortStats("MergeSort", sortProgram.z, numComparisons, numMoves, numNanoSeconds);
		return x;
	}
}
