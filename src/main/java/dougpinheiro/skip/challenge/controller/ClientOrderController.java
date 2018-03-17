package dougpinheiro.skip.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dougpinheiro.skip.challenge.model.data.Status;
import dougpinheiro.skip.challenge.model.entity.ClientOrder;
import dougpinheiro.skip.challenge.repository.ClientOrderRepository;

@Controller
public class ClientOrderController {

	@Autowired
	private ClientOrderRepository clientOrderRepository;
	
	public void save(ClientOrder clientOrder) {
		clientOrderRepository.save(clientOrder);
	}
	
	public ClientOrder getOrderById(Long id) {
		return clientOrderRepository.findById(id).get();
	}
	
	@RequestMapping(value="/createorder", method=RequestMethod.POST)
	public void createOrder(@RequestBody ClientOrder order) {
		clientOrderRepository.save(order);
	}
	
	@RequestMapping(value="/cancelorder", method=RequestMethod.POST)
	public void cancelOrder(@RequestBody ClientOrder clientOrder) {
		clientOrder.setStatus(Status.CANCELED);
		clientOrderRepository.save(clientOrder);
	}
	
}
