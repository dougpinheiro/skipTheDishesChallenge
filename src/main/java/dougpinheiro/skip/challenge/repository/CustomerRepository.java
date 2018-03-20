package dougpinheiro.skip.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dougpinheiro.skip.challenge.model.entity.Customer;
import dougpinheiro.skip.challenge.model.entity.Login;

public interface CustomerRepository extends	JpaRepository<Customer, Long> {
	
}