package dougpinheiro.skip.challenge.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.repository.Repository;

import dougpinheiro.skip.challenge.model.entity.Store;

public interface StoreRepository extends Repository<Store, Integer> {
	
	List<Store> findAll();
	
	default List<Store> findByNameLikeIgnoreCase(String searchText){
		List<Store> stores = new ArrayList<Store>(0);
		stores = this.findAll().stream().filter((Store p1) -> {
			return (p1.getName().toUpperCase().contains(searchText.toUpperCase()));
		}).collect(Collectors.toList());
		return stores;
	}
	
	Optional<Store> findById(Integer id);
	
	
}