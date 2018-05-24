package training.web.resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import training.dao.DaoException;
import training.dao.ProductDao;
import training.entity.Product;
import training.entity.ProductList;

@RestController
@RequestMapping("/products")
public class ProductsResource {

	@Autowired
	ProductDao dao;

	@RequestMapping(method = RequestMethod.GET, produces = "text/plain")
	public String info() {
		return "This is a simple REST service.";
	}

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public List<Product> jsonProductList() throws DaoException {
		return dao.getAll();
	}

	@RequestMapping(method = RequestMethod.GET, produces = "application/xml")
	public ProductList xmlProductList() throws DaoException {
		return new ProductList(dao.getAll());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { "application/xml", "application/json" })
	public Product getOneProduct(@PathVariable("id") Integer id) throws DaoException {
		return dao.get(id);
	}

	@RequestMapping(method = RequestMethod.POST, 
			produces = "application/json", 
			consumes = "application/json")
	public Map<String, Object> create(@RequestBody Product product) throws DaoException {
		Map<String, Object> out = new HashMap<>();
		try {
			dao.create(product);
			out.put("success", true);
			out.put("id", product.getProductId());
		} catch (Exception e) {
			out.put("success", false);
			out.put("reason", e.getMessage());
		}
		return out;
	}
}
