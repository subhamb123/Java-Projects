import java.util.Arrays;

public class f {
	public static void main(String[] args) {
		int [][] mat = new int [3][4];
		for (int row = 0; row < mat.length; row++)
		{
		   for (int col = 0; col < mat[0].length; col++)
		   {
		      if (row < col)
		         mat[row][col] = 3;
		      else if (row == col)
		         mat[row][col] = 2;
		      else
		         mat[row][col] = 1;
		   }
		}
		System.out.println(Arrays.deepToString(mat));
	}
	public static void m1 ()
	{
		for (int i  = 1; i <= 5; i++) {
			   for (int j = i; j > 0; j--) {
			      System.out.print(i);
			   }
			   System.out.println();
			}


	}
}
