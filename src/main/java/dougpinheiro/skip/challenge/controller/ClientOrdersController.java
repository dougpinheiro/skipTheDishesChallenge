package dougpinheiro.skip.challenge.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import dougpinheiro.skip.challenge.model.entity.ClientOrders;
import dougpinheiro.skip.challenge.repository.ClientOrdersRepository;
import dougpinheiro.skip.challenge.repository.ProductRepository;

@Controller
public class ClientOrdersController {

	@Autowired
	private ClientOrdersRepository clientOrdersRepositories;
		
	public void save(ClientOrders clientOrders) {
		clientOrdersRepositories.save(clientOrders);
	}
	
	public List<ClientOrders> getAllClientOrders(){
		return (List<ClientOrders>) clientOrdersRepositories.findAll();
	}
	
	public List<ClientOrders> getClientOrdersByOrderId(Long id){
		return getAllClientOrders().stream().filter((p)->{
			if(id == p.getId_order()) {
				return true;
			}else {
				return false;
			}
		}).collect(Collectors.toList());
		
	}
	
}
