package training.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import training.entity.Product;

@Transactional(readOnly = true, rollbackFor = { DaoException.class })
public interface ProductDao {

	// CRUD OPERATIONS

	@Transactional(readOnly = false)
	public void create(Product product) throws DaoException;

	public Product get(Integer productId) throws DaoException;

	@Transactional(readOnly = false)
	public void update(Product product) throws DaoException;

	@Transactional(readOnly = false)
	public void delete(Integer productId) throws DaoException;

	// QUERIES

	public List<Product> getAll() throws DaoException;

	public List<Product> getByPrice(Double min, Double max) throws DaoException;

	public int getProductCount() throws DaoException;

}
