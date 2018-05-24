package training.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import training.dao.DaoException;
import training.dao.ProductDao;
import training.entity.Product;

@SuppressWarnings("unchecked")
public class HibernateTemplateProductDao implements ProductDao {

	@Autowired
	private HibernateTemplate template;

	@Override
	public void create(Product product) throws DaoException {
		template.save(product);
	}

	@Override
	public Product get(Integer productId) throws DaoException {
		return template.get(Product.class, productId);
	}

	@Override
	public void update(Product product) throws DaoException {
		if(product.getUnitsInStock()<0){
			throw new DaoException("Units in stock can't be < 0");
		}
		template.merge(product);
	}

	@Override
	public void delete(Integer productId) throws DaoException {
		Product p = this.get(productId);
		if (p != null) {
			template.delete(p);
		}
	}

	@Override
	public List<Product> getAll() throws DaoException {
		return (List<Product>) template.find("from Product");
	}

	@Override
	public List<Product> getByPrice(Double min, Double max) throws DaoException {
		// return (List<Product>) template.find("from Product where unitPrice
		// between ? and ?", min, max);
		DetachedCriteria cr = DetachedCriteria.forClass(Product.class);
		cr.add(Restrictions.between("unitPrice", min, max));
		return (List<Product>) template.findByCriteria(cr);
	}

	@Override
	public int getProductCount() throws DaoException {
		return ((Long) template.find("select count(p) from Product p").get(0)).intValue();
	}

}
