package dougpinheiro.skip.challenge.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dougpinheiro.skip.challenge.model.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	List<Product> findByDescriptionLikeIgnoreCase(String searchText);
	Optional<Product> findById(Integer id);
	
}