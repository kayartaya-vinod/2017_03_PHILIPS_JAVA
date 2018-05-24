package training.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import training.dao.DaoException;
import training.dao.ProductDao;
import training.entity.Product;

@Component("jt-dao")
public class JdbcTemplateProductDao implements ProductDao {

	@Autowired
	private JdbcTemplate template;
	
	// for following good practices
	public JdbcTemplateProductDao() {
	}

	@Override
	public void create(Product product) throws DaoException {
		String sql = "insert into products values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		template.update(sql, product.getProductId(), product.getProductName(), product.getSupplierId(),
				product.getCategoryId(), product.getQuantityPerUnit(), product.getUnitPrice(),
				product.getUnitsInStock(), product.getUnitsOnOrder(), product.getReorderLevel(),
				product.getDiscontinued());
	}

	@Override
	public Product get(Integer productId) throws DaoException {
		String sql = "select * from products where product_id=?";
		ProductRowMapper rowMapper = new ProductRowMapper();
		return template.queryForObject(sql, rowMapper, productId);
	}

	@Override
	public void update(Product product) throws DaoException {
		String sql = "update products set product_name=?, " + "supplier_id=?, category_id=?, unit_price=?, "
				+ "quantity_per_unit=?, unit_price=?, units_in_stock=?, "
				+ "units_on_order=?, reorder_level=?, discontinued=? " + "where product_id=?";
		template.update(sql, product.getProductName(), product.getSupplierId(), product.getCategoryId(),
				product.getQuantityPerUnit(), product.getUnitPrice(), product.getUnitsInStock(),
				product.getUnitsOnOrder(), product.getReorderLevel(), product.getDiscontinued(),
				product.getProductId());
	}

	@Override
	public void delete(Integer productId) throws DaoException {
		template.update("delete from products where product_id=?", productId);
	}

	@Override
	public List<Product> getAll() throws DaoException {
		String sql = "select * from products";
		ProductRowMapper rowMapper = new ProductRowMapper();
		return template.query(sql, rowMapper);
	}

	@Override
	public List<Product> getByPrice(Double min, Double max) throws DaoException {
		String sql = "select * from products where unit_price between ? and ?";
		ProductRowMapper rowMapper = new ProductRowMapper();
		return template.query(sql, rowMapper, min, max);
	}

	@Override
	public int getProductCount() throws DaoException {
		return template.queryForObject("Select count(*) from products", Integer.class);
	}

	class ProductRowMapper implements RowMapper<Product> {

		@Override
		public Product mapRow(ResultSet rs, int index) throws SQLException {
			Product product = new Product();
			product.setProductId(rs.getInt("product_id"));
			product.setProductName(rs.getString("product_name"));
			product.setSupplierId(rs.getInt("supplier_id"));
			product.setCategoryId(rs.getInt("category_id"));
			product.setQuantityPerUnit(rs.getString("quantity_per_unit"));
			product.setUnitPrice(rs.getDouble("unit_price"));
			product.setUnitsInStock(rs.getInt("units_in_stock"));
			product.setUnitsOnOrder(rs.getInt("units_on_order"));
			product.setReorderLevel(rs.getInt("reorder_level"));
			product.setDiscontinued(rs.getInt("discontinued"));
			return product;
		}

	}
}
