package training.model;

public class Person implements Comparable<Person>{
	// fields
	private String name;
	private String email;
	private String city;

	public Person() {
	}

	public Person(String name, String email, String city) {
		super();
		this.name = name;
		this.email = email;
		this.city = city;
	}

	// properties
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Person)) {
			return false;
		}
		Person other = (Person) obj;
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", email=" + email + ", city=" + city + "]";
	}

	@Override
	public int compareTo(Person other) {
		// defines the natural ordering of Person's
		// let's say natural ordering is by name
		return name.compareTo(other.name);
	}

}
