package dougpinheiro.skip.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dougpinheiro.skip.challenge.model.entity.Customer;

public interface CustomerRepository extends	JpaRepository<Customer, Integer> {
	List<Customer> findByEmailAndPassword(String email, String password);
}