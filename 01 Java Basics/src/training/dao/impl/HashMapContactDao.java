package training.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import training.dao.ContactDao;
import training.dao.DaoException;
import training.model.Contact;
import training.util.DateUtil;

public class HashMapContactDao implements ContactDao {

	private Map<Integer, Contact> store;
	private static int counter;

	public HashMapContactDao() {
		store = new HashMap<>();
		Contact c;
		c = new Contact("Vinod", "vinod@vinod.co", "9731424784", "Bangalore", DateUtil.parse("20-01-1974"));
		c.setId(1);
		store.put(1, c);
		c = new Contact("John Doe", "john@doe.com", "5557893322", "Dallas", DateUtil.parse("22-05-1967"));
		c.setId(2);
		store.put(2, c);
		c = new Contact("Jane Doe", "jane@doe.com", "5459983663", "Chicago", DateUtil.parse("12-09-1999"));
		c.setId(3);
		store.put(3, c);
	}

	@Override
	public void create(Contact contact) throws DaoException {
		contact.setId(++counter);
		store.put(contact.getId(), contact);
	}

	@Override
	public Contact get(Integer id) throws DaoException {
		return store.get(id);
	}

	@Override
	public void update(Contact contact) throws DaoException {
		if (store.containsKey(contact.getId())) {
			store.put(contact.getId(), contact);
		} else {
			throw new DaoException("Invalid id for update");
		}
	}

	@Override
	public void delete(Integer id) throws DaoException {
		if (store.containsKey(id)) {
			store.remove(id);
		} else {
			throw new DaoException("Invalid id for deletion");
		}
	}

	@Override
	public Contact getByEmail(String email) throws DaoException {
		return store.values().stream().filter(c -> c.getEmail().equals(email)).findAny().orElse(null);
	}

	@Override
	public List<Contact> getAll() throws DaoException {
		List<Contact> list = new ArrayList<Contact>();
		list.addAll(store.values());
		return list;
	}

	@Override
	public List<Contact> getByCity(String city) throws DaoException {
		return store.values().stream().filter(c -> c.getCity().equals(city)).collect(Collectors.toList());
	}

}
