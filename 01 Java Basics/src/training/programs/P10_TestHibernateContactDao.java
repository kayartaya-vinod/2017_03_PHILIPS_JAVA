package training.programs;

import java.util.List;

import training.dao.ContactDao;
import training.dao.DaoException;
import training.dao.DaoFactory;
import training.dao.DaoTypes;
import training.model.Contact;

public class P10_TestHibernateContactDao {

	public static void main(String[] args) throws DaoException {
		
		ContactDao dao = DaoFactory.getContactDao(DaoTypes.HIBERNATE);
		
		Contact c = dao.get(1);
		System.out.println(c);
		c.setEmail("vinod@knowledgeworksindia.com");
		
		dao.update(c);
		
		c = dao.getByEmail("ehayes2@cnet.com");
		System.out.println(c);
		
		System.out.println("----------------------------------------");
		
		List<Contact> list = dao.getAll();
		for(Contact c1: list){
			System.out.println(c1);
		}
		
	}
}
