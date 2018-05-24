package training.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import training.dao.DaoException;
import training.dao.ProductDao;

@Controller
public class ProductController {
	
	@Autowired
	private ProductDao dao;

	@RequestMapping(value = "/get-products")
	public ModelAndView getAllProducts() throws DaoException {
		return new ModelAndView("products", "data", dao.getAll());
	}
}
