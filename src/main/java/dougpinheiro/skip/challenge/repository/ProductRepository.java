package dougpinheiro.skip.challenge.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;

import dougpinheiro.skip.challenge.model.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	default List<Product> findByDescriptionLikeIgnoreCase(String searchText){
		List<Product> products = new ArrayList<Product>(0);
		products = this.findAll().stream().filter((Product p1) -> {
			return (p1.getDescription().toUpperCase().contains(searchText.toUpperCase()));
		}).collect(Collectors.toList());
		return products;
	};
	
	Optional<Product> findById(Integer id);
	
}