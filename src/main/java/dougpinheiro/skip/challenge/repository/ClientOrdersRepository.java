package dougpinheiro.skip.challenge.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import dougpinheiro.skip.challenge.model.entity.ClientOrders;

public interface ClientOrdersRepository
		extends
			PagingAndSortingRepository<ClientOrders, Long> {
}