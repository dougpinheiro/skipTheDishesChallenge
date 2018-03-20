package dougpinheiro.skip.challenge.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dougpinheiro.skip.challenge.model.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
	Optional<Order> findById(Integer id);
}