public class CandyDistributor{
	int counter = 2;
	public static void main(String[] args) {
		CandyDistributor nice = new CandyDistributor();
		nice.nextCandy();
		nice.nextCandy();
		nice.nextCandy();
		nice.nextCandy();
		nice.nextCandy();
		nice.nextCandy();
		nice.nextCandy();
		nice.nextCandy();
	}
	void nextCandy() {
		if(counter%2 == 0)
		{
			System.out.println(counter/2 + " for you.");
		} else
		{
			System.out.println(counter/2 + " for me.");
		}
		counter++;
	}
}