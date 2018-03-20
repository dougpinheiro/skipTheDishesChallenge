package dougpinheiro.skip.challenge.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dougpinheiro.skip.challenge.model.entity.Product;
import dougpinheiro.skip.challenge.repository.ProductRepository;

@RestController
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	@RequestMapping(value="/api/v1/Product", produces= {"application/json"}, method=RequestMethod.GET)
	public ResponseEntity<List<Product>> findAllProducts(){
		List<Product> products = new ArrayList<Product>(0);
		products = productRepository.findAll();
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

	@RequestMapping(value="/api/v1/Product/search/{searchText}", produces= {"application/json"}, method=RequestMethod.GET)
	public ResponseEntity<List<Product>> search(@PathVariable("searchText") String searchText){
		List<Product> products = new ArrayList<Product>(0); 
		products = productRepository.findByDescriptionLikeIgnoreCase(searchText);
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

	@RequestMapping(value="/api/v1/Product/{productId}", produces= {"application/json"}, method=RequestMethod.GET)
	public ResponseEntity<Product> findProductById(@PathVariable("productId") Integer id){
		Product product = productRepository.findById(id).isPresent() ? productRepository.findById(id).get() : new Product();
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
}
