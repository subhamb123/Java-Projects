public class Check {
	public static boolean isInOrder(int[] x) {
		int count = -1;
		while (count != 0) {
			count = 0;
			for (int i = 0; i < x.length - 1; i++) {
				if (x[i] > x[i + 1]) {
					return false;
				}
			}
		}
		return true;
	}
}
