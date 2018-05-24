package training.dao;

import training.dao.impl.HashMapContactDao;
import training.dao.impl.HibernateContactDao;
import training.dao.impl.JdbcContactDao;

public final class DaoFactory {

	private DaoFactory() {
	}
	
	// factory method; virtual constructor of object
	public static ContactDao getContactDao(DaoTypes dt) throws DaoException {
		if (dt == DaoTypes.HASHMAP) {
			return new HashMapContactDao();
		}
		else if(dt==DaoTypes.JDBC){
			return new JdbcContactDao();
		}
		else if(dt==DaoTypes.HIBERNATE){
			return new HibernateContactDao();
		}

		String msg = String.format("The %s implementation is currently not available", dt);
		throw new DaoException(msg);
	}

}
