import java.util.*;

public class sortProgram {
	static int z = 0;
	static int[] numbers;
	public static void main(String[] args) throws Exception {
		ISorter[] sorts = {new BubbleSort(), new SelectionSort(), new InsertionSort(), new MergeSort()};
		Scanner scanner = new Scanner(System.in);
		Scanner console = new Scanner(System.in);
		System.out.println("How many numbers do you want to sort?");
		while(!console.hasNextInt()) {
			System.out.println("Enter a valid input!");
			console.nextLine();
		}
		z = console.nextInt();
		numbers = new int[z];
		System.out.println("Type in numbers one by one in random order to get sorted.");
		int j = 0;
		int f = 0;
		while(f<z) {
			while(!scanner.hasNextInt()) {
				System.out.println("Enter a valid input!");
				scanner.nextLine();
			}
			int x = scanner.nextInt();
			numbers[j] = x;
			f++;
			j++;
		}
		System.out.println("Statistics\n==========");
		for(int i = 1; i <= 1; i *= 2) {
			for(ISorter sorter : sorts) {
				int[] copy = numbers.clone();
				ISortStats stats = sorter.sort(copy);
				assert(Check.isInOrder(copy));
				System.out.println(stats);
			}
		}
		System.out.println();
		BS.sort(numbers);
	}
		
}