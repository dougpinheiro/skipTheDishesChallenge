package dougpinheiro.skip.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dougpinheiro.skip.challenge.model.entity.Cousine;

public interface CousineRepository extends JpaRepository<Cousine, Long> {
	
	List<Cousine> findAll();
	
	List<Cousine> findByTypeLikeIgnoreCase(String searchText);
	
	Cousine findById(Integer id);
	
}