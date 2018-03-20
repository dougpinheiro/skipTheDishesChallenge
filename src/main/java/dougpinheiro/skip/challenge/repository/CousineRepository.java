package dougpinheiro.skip.challenge.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;

import dougpinheiro.skip.challenge.model.entity.Cousine;

public interface CousineRepository extends JpaRepository<Cousine, Long> {
	
	List<Cousine> findAll();
	
	default List<Cousine> findByTypeLikeIgnoreCase(String searchText){
		List<Cousine> cousines = new ArrayList<Cousine>(0);
		cousines = this.findAll().stream().filter((Cousine p1) -> {
			return (p1.getType().toUpperCase().contains(searchText.toUpperCase()));
		}).collect(Collectors.toList());
		return cousines;
	};
	
	Cousine findById(Integer id);
	
}