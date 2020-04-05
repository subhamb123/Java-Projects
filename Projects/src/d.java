public class d extends Throwable{
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) throws d {
		try {
			throw new d();
		}
		catch(d x) {
			 
		}
		finally {
			
		}
		IllegalArgumentException x = new IllegalArgumentException();
		x.printStackTrace();
	}
}
