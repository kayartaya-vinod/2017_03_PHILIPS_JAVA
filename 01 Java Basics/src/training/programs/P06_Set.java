package training.programs;

import java.util.Set;
import java.util.TreeSet;

import training.model.Person;

public class P06_Set {

	public static void main(String[] args) {
		
		Set<Integer> nums;
		nums = new TreeSet<>();
		
		nums.add(12);
		nums.add(12);
		nums.add(24);
		nums.add(12);
		nums.add(89);
		nums.add(89);
		nums.add(4);
		
		System.out.println("The no.of elements in nums = " + nums.size());
		System.out.println("nums = " + nums);
		for(int x: nums){
			System.out.println(x);
		}
		
		
		Set<String> names = new TreeSet<>();
		names.add("Vinod");
		names.add("Vinod");
		names.add("Ramesh");
		names.add("Vinod");
		names.add("Anil");
		names.add("Vinod");
		names.add("Arun");
		names.add("Ramesh");
		names.add("Ramesh");
		names.add("Vinod");
		
		System.out.println(names);
		
		Set<Person> people = new TreeSet<>();
		people.add(new Person("Vinod", "vinod@gmail.com", "Chennai"));
		people.add(new Person("Arun", "arun@mail.com", "Bangalore"));
		people.add(new Person("Zahir", "vinod@vinod.co", "Bangalore"));
		people.add(new Person("Vinod", "vinod@vinod.co", "Shimoga"));
		people.add(new Person("Ramesh", "vinod@vinod.co", "Bangalore"));
		people.add(new Person("Vikram", "vinod@vinod.co", "Bangalore"));
		
		for(Person p: people){
			System.out.println(p);
		}
	}
}












