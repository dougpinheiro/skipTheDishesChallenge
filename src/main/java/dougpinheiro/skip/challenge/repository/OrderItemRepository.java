package dougpinheiro.skip.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dougpinheiro.skip.challenge.model.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
}