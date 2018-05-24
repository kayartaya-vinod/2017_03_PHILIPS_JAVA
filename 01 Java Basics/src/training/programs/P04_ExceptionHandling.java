package training.programs;

public class P04_ExceptionHandling {

	public static void main(String[] args) {

		try {
			int n1 = Integer.parseInt(args[0]);
			int n2 = Integer.parseInt(args[1]);
			int n3 = n1 / n2;
			System.out.println("Quotient = " + n3);
		} 
		catch (Exception e) {
			System.out.println("There was an error of type: " + e.getClass());
		}
		finally {
			
		}
		
		System.out.println("End of program!");
	}
}
