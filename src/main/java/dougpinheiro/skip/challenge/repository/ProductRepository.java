package dougpinheiro.skip.challenge.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import dougpinheiro.skip.challenge.model.entity.Product;

public interface ProductRepository
		extends
			PagingAndSortingRepository<Product, Long> {
}