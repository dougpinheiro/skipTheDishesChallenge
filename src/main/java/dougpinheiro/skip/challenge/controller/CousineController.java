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

import dougpinheiro.skip.challenge.model.entity.Cousine;
import dougpinheiro.skip.challenge.model.entity.Store;
import dougpinheiro.skip.challenge.repository.CousineRepository;

@RestController
public class CousineController {

	@Autowired
	private CousineRepository cousineRepository;
	
	@RequestMapping(value="/api/v1/Cousine", produces= {"application/json"}, method=RequestMethod.GET)
	public ResponseEntity<List<Cousine>> findAll() {
		List<Cousine> cousineList = new ArrayList<Cousine>(0);
		cousineList = (List<Cousine>) cousineRepository.findAll();
		return new ResponseEntity<List<Cousine>>(cousineList, HttpStatus.OK);
	}

	@RequestMapping(value="/api/v1/Cousine/search/{searchText}", produces= {"application/json"}, method=RequestMethod.GET)
	public ResponseEntity<List<Cousine>> search(@PathVariable("searchText") String searchText) {
		List<Cousine> cousineList = new ArrayList<Cousine>(0);
		cousineList = (List<Cousine>) cousineRepository.findByTypeLikeIgnoreCase(searchText);
		return new ResponseEntity<List<Cousine>>(cousineList, HttpStatus.OK);
	}

	@RequestMapping(value="/api/v1/Cousine/{cousineId}/stores", produces= {"application/json"}, method=RequestMethod.GET)
	public ResponseEntity<List<Store>> findAllStoresByCousineId(@PathVariable("cousineId") Integer id) {
		Cousine cousine = cousineRepository.findById(id);
		List<Store> stores = new ArrayList<Store>(0);
		cousine.getStores().stream().forEach((p) -> {
			Store temp = p;
			System.out.println(temp.getName());
			stores.add(temp);
		});
		return new ResponseEntity<List<Store>>(stores, HttpStatus.OK);
	}
	
	
	
}
