public class UnfairCandyDistributor {
	int child1 = 0;
	int child2 = 0;
	int candyCounter = 0;
	public static void main(String[] args) {
		UnfairCandyDistributor mean = new UnfairCandyDistributor();
		mean.nextCandy();
		mean.nextCandy();
		mean.nextCandy();
		mean.nextCandy();
		mean.nextCandy();
		mean.nextCandy();
		mean.nextCandy();
		mean.nextCandy();
	}
	void nextCandy() {
		candyCounter++;
		if(candyCounter % 2 == 1) {
			child1++;
			System.out.println(child1+" for you.");
		}else {
			for(int i = 1; i <= child1; i++) {
				System.out.println(i+" for me.");
			}
			child2 += child1;
		}
	}
}
