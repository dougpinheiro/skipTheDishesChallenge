package dougpinheiro.skip.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dougpinheiro.skip.challenge.model.entity.Login;

public interface LoginRepository extends JpaRepository<Login, Integer> {
	
	List<Login> findByLoginAndPassword(String login, String password);

}
