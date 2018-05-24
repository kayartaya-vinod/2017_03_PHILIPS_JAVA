package training.dao;

import java.util.List;

import training.model.Contact;

public interface ContactDao {
	// CRUD OPERATIONS
	public void create(Contact contact) throws DaoException;

	public Contact get(Integer id) throws DaoException;

	public void update(Contact contact) throws DaoException;

	public void delete(Integer id) throws DaoException;

	// QUERIES

	public Contact getByEmail(String email) throws DaoException;

	public List<Contact> getAll() throws DaoException;

	public List<Contact> getByCity(String city) throws DaoException;
}
