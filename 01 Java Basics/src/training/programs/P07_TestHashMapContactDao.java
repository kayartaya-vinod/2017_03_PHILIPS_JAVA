package training.programs;

import java.util.List;

import training.dao.ContactDao;
import training.dao.DaoException;
import training.dao.DaoFactory;
import training.dao.DaoTypes;
import training.model.Contact;
import training.util.DateUtil;

public class P07_TestHashMapContactDao {

	public static void main(String[] args) throws DaoException {
		
		ContactDao dao;
		// dao = new HashMapContactDao(); // tight coupling
		dao = DaoFactory.getContactDao(DaoTypes.HASHMAP); // loose coupling
		
		Contact c;
		c = new Contact("Vinod", "vinod@vinod.co", 
				"9731424784", "Bangalore", DateUtil.parse("20-01-1974"));
		dao.create(c);
		c = new Contact("John Doe", "john@doe.com", 
				"5557893322", "Dallas", DateUtil.parse("22-05-1967"));
		dao.create(c);
		c = new Contact("Jane Doe", "jane@doe.com", 
				"5459983663", "Chicago", DateUtil.parse("12-09-1999"));
		dao.create(c);

		List<Contact> list = dao.getAll();
		for(Contact x: list){
			System.out.println(x);
		}
	}
}







