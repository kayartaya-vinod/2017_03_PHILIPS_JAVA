package training.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import training.dao.DaoException;
import training.dao.ProductDao;
import training.entity.Product;

public class ProductService {

	@Autowired
	ProductDao dao;

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { ServiceException.class })
	public void addToCart(Integer... productIds) throws ServiceException {
		// add the proudcts to the LINE_ITEMS table
		// add the order to the ORDERS table
		// update the stocks
		updateStock(productIds);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { ServiceException.class })
	private void updateStock(Integer... productsIds) throws ServiceException {
		try {
			for (Integer id : productsIds) {
				Product p = dao.get(id);
				p.setUnitsInStock(p.getUnitsInStock() - 1);
				dao.update(p);
			}
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}
}
