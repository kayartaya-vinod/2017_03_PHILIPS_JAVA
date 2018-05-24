package training.programs;

public class P05_Arrays {
	public static void main(String[] args) {

		// String[] names = {"Vinod", "Shyam", "Satya"};
		String[] names;
		int size = 3;
		
		names = new String[size];
		
		names[0] = "Vinod";
		names[1] = "Shyam";
		names[2] = "Satya";
		
		System.out.printf("%s %s %s\n",
				names[0], names[1], names[2]);
		
		names = new String[] { "Vinod", "Shyam", "Satya" };
		
	}
}
