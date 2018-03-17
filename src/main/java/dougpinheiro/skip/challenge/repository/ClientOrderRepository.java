package dougpinheiro.skip.challenge.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import dougpinheiro.skip.challenge.model.entity.ClientOrder;

public interface ClientOrderRepository
		extends
			PagingAndSortingRepository<ClientOrder, Long> {
}