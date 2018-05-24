package training.programs;

import training.dao.ContactDao;
import training.dao.DaoException;
import training.dao.DaoFactory;
import training.dao.DaoTypes;
import training.model.Contact;

public class P09_TestJdbcContactDao {

	public static void main(String[] args) throws DaoException {
		ContactDao dao;
		
		dao = DaoFactory.getContactDao(DaoTypes.HASHMAP);
		Contact c = dao.get(1);
		
		dao = DaoFactory.getContactDao(DaoTypes.JDBC);
		dao.update(c);
		
	}
}
