package dougpinheiro.skip.challenge.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import dougpinheiro.skip.challenge.model.entity.Store;

public interface StoreRepository extends Repository<Store, Integer> {
	
	List<Store> findAll();
	List<Store> findByNameLikeIgnoreCase(String searchText);
	Optional<Store> findById(Integer id);
	
	
}