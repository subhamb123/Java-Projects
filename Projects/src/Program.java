import java.util.*;

public class Program {
	public static void main(String[] args) throws Exception {
		ISorter[] sorts = {new BubbleSort(), new SelectionSort(), new InsertionSort(), new MergeSort()};
		
		// RANDOM ORDER
		System.out.println("random");
		for(int i = 1; i <= 4096; i *= 2) {
			int[] set = generateRandom(i);
			for(ISorter sorter : sorts) {
				int[] copy = set.clone();
				ISortStats stats = sorter.sort(copy);
				assert(Check.isInOrder(copy));
				System.out.println(stats);
			}
		}
		System.out.println();
		
		// REVERSE ORDER
		System.out.println("reverse");
		int[] set = generateReverse(4096);
		
		for(ISorter sorter : sorts) {
			int[] copy = set.clone();
			ISortStats stats = sorter.sort(copy);
			assert(Check.isInOrder(copy));
			System.out.println(stats);
		}
		System.out.println();
		
		// ALREADY SORTED
		System.out.println("sorted");
		Arrays.sort(set);
		for(ISorter sorter : sorts) {
			ISortStats stats = sorter.sort(set);
			System.out.println(stats);
		}
		System.out.println();
	}
	

	static int[] generateRandom(int size) {
		int[] ret = new int[size];
		Random rand = new Random(Integer.MAX_VALUE+1);
		
		for(int i = 0; i < size; i++) {
			ret[i] = rand.nextInt();
		}
		
		return ret;
	}
	
	static int[] generateReverse(int size) {
		int[] ret = new int[size];
		int num = Integer.MAX_VALUE;
		Random rand = new Random(size);
		
		// create a reverse array
		for(int i = size - 1; i >= 0; i--) {
			ret[i] = num;
			num -= rand.nextInt() + 1;
		}
		
		return ret;
	}

}
