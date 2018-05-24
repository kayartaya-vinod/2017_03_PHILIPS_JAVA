package training.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import training.dao.ContactDao;
import training.dao.DaoException;
import training.model.Contact;
import training.util.HibernateUtil;

@SuppressWarnings("unchecked")
public class HibernateContactDao implements ContactDao {

	@Override
	public void create(Contact contact) throws DaoException {
		try {
			Session session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			try {
				session.save(contact);
				tx.commit();
			} catch (HibernateException e) {
				tx.rollback();
			} finally {
				session.close();
			}
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public Contact get(Integer id) throws DaoException {
		try {
			Session session = HibernateUtil.getSession();
			Contact c = (Contact) session.get(Contact.class, id);
			session.close();
			return c;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public void update(Contact contact) throws DaoException {
		try {
			Session session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			try {
				session.update(contact);
				tx.commit();
			} catch (HibernateException e) {
				tx.rollback();
			} finally {
				session.close();
			}
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public void delete(Integer id) throws DaoException {
		try {
			Session session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			try {
				Contact contact = get(id);
				if (contact != null) {
					session.delete(contact);
					tx.commit();
				}
			} catch (HibernateException e) {
				tx.rollback();
			} finally {
				session.close();
			}
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public Contact getByEmail(String email) throws DaoException {
		try {
			Session session = HibernateUtil.getSession();
			String hql = "FROM training.model.Contact WHERE email = ?";
			Query qry = session.createQuery(hql);
			qry.setString(0, email);
			Contact c = (Contact) qry.uniqueResult();
			session.close();
			return c;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public List<Contact> getAll() throws DaoException {
		try {
			Session session = HibernateUtil.getSession();
			String hql = "select c from Contact c";
			Query qry = session.createQuery(hql);
			List<Contact> list = qry.list();
			session.close();
			return list;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public List<Contact> getByCity(String city) throws DaoException {
		try {
			Session session = HibernateUtil.getSession();
			String hql = "FROM training.model.Contact WHERE city = :CITY";
			Query qry = session.createQuery(hql);
			qry.setString("CITY", city);
			List<Contact> list = qry.list();
			session.close();
			return list;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

}
