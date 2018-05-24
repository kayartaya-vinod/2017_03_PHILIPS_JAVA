package training.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import training.dao.ContactDao;
import training.dao.DaoException;
import training.model.Contact;
import training.util.DbUtil;

public class JdbcContactDao implements ContactDao {

	@Override
	public void create(Contact contact) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public Contact get(Integer id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Contact c) throws DaoException {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DbUtil.getConnection();
			conn.setAutoCommit(false);
			String sql = "update contacts set name=?, email=?, city=?, phone=?, birth_date=? where id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, c.getName());
			stmt.setString(2, c.getEmail());
			stmt.setString(3, c.getCity());
			stmt.setString(4, c.getPhone());
			stmt.setDate(5, new java.sql.Date(c.getBirthDate().getTime()));
			stmt.setInt(6, c.getId());
			stmt.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			DbUtil.close(conn, stmt);
		}
	}

	@Override
	public void delete(Integer id) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public Contact getByEmail(String email) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contact> getAll() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contact> getByCity(String city) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
