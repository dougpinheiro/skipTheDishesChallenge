package dougpinheiro.skip.challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dougpinheiro.skip.challenge.model.entity.Product;
import dougpinheiro.skip.challenge.repository.ProductRepository;

@Controller
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	@RequestMapping(value="/insertproduct", method=RequestMethod.POST)
	public void insertProduct(@RequestBody Product product) {
		productRepository.save(product);
	}
	
	public List<Product> getAllProducts(){
		return (List<Product>) productRepository.findAll();
	}
	
	public Product findById(Long id) {
		return productRepository.findById(id).get();
	}	
	
}
