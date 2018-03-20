package dougpinheiro.skip.challenge.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
		List<Store> stores = storeRepository.findAll();
		return new ResponseEntity<List<Store>>(stores, HttpStatus.OK); 
	}

	@RequestMapping(value="/api/v1/Store/search/{searchText}", produces= {"application/json"}, method=RequestMethod.GET)
	public ResponseEntity<List<Store>> search(@PathParam("searchText") String searchText){
		List<Store> stores = storeRepository.findByNameLikeIgnoreCase(searchText);
		return new ResponseEntity<List<Store>>(stores, HttpStatus.OK); 
	}

	@RequestMapping(value="/api/v1/Store/{storeId}", produces= {"application/json"}, method=RequestMethod.GET)
	public ResponseEntity<Store> findById(@PathParam("storeId") Integer storeId){
		Store store = storeRepository.findById(storeId).get();
		return new ResponseEntity<Store>(store, HttpStatus.OK); 
	}

	@RequestMapping(value="/api/v1/Store/{storeId}/products", produces= {"application/json"}, method=RequestMethod.GET)
	public ResponseEntity<List<Product>> findProductsByStoreId(@PathParam("storeId") Integer storeId){
		List<Product> products = storeRepository.findById(storeId).get().getProducts();
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK); 
	}
	
}
