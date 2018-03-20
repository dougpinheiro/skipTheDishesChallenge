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
import dougpinheiro.skip.challenge.model.entity.Store;
import dougpinheiro.skip.challenge.repository.StoreRepository;

@RestController
public class StoreController {

	@Autowired
	private StoreRepository storeRepository;
	
	@RequestMapping(value="/api/v1/Store", produces= {"application/json"}, method=RequestMethod.GET)
	public ResponseEntity<List<Store>> getAllStores(){
		List<Store> stores = new ArrayList<Store>(0);
		stores = storeRepository.findAll();
		return new ResponseEntity<List<Store>>(stores, HttpStatus.OK); 
	}

	@RequestMapping(value="/api/v1/Store/search/{searchText}", produces= {"application/json"}, method=RequestMethod.GET)
	public ResponseEntity<List<Store>> search(@PathVariable("searchText") String searchText){
		List<Store> stores = new ArrayList<Store>(0);
		stores = storeRepository.findByNameLikeIgnoreCase(searchText);
		return new ResponseEntity<List<Store>>(stores, HttpStatus.OK); 
	}

	@RequestMapping(value="/api/v1/Store/{storeId}", produces= {"application/json"}, method=RequestMethod.GET)
	public ResponseEntity<Store> findById(@PathVariable("storeId") Integer storeId){
		Store store = storeRepository.findById(storeId).isPresent() ? storeRepository.findById(storeId).get() : new Store();
		return new ResponseEntity<Store>(store, HttpStatus.OK); 
	}

	@RequestMapping(value="/api/v1/Store/{storeId}/products", produces= {"application/json"}, method=RequestMethod.GET)
	public ResponseEntity<List<Product>> findProductsByStoreId(@PathVariable("storeId") Integer storeId){
		List<Product> products = new ArrayList<Product>(0);
		Store s = storeRepository.findById(storeId).isPresent() ? storeRepository.findById(storeId).get() : new Store();
		products = s.getProducts();
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK); 
	}
	
}
