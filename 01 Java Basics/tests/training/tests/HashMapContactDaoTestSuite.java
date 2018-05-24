package training.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import training.dao.ContactDao;
import training.dao.DaoException;
import training.dao.DaoFactory;
import training.dao.DaoTypes;
import training.model.Contact;
import training.util.DateUtil;

public class HashMapContactDaoTestSuite {
	
	private ContactDao dao;

	@Before
	public void setup() throws DaoException{
		dao = DaoFactory.getContactDao(DaoTypes.HASHMAP);
	}
	
	@Test
	public void UTC_01_createContact(){
		try {
			Contact c;
			c = new Contact("Vinod", "vinod@vinod.co", 
					"9731424784", "Bangalore", DateUtil.parse("20-01-1974"));
			
			assertNull(c.getId());
			dao.create(c);
			assertNotNull(c.getId());
			
		} catch (DaoException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void UTC_02_getById(){
		try {
			Contact c = dao.get(1);
			assertNotNull(c);
			assertEquals("Vinod", c.getName());
			assertEquals("vinod@vinod.co", c.getEmail());
		} catch (DaoException e) {
			fail(e.getMessage());
		}
	}
	
}












