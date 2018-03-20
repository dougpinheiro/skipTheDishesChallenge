package dougpinheiro.skip.challenge.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dougpinheiro.skip.challenge.model.entity.Customer;
import dougpinheiro.skip.challenge.model.entity.Order;
import dougpinheiro.skip.challenge.repository.OrderRepository;

@RestController
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;
	
	@RequestMapping(value="/api/v1/Order/{orderId}", produces= {"application/json"}, method=RequestMethod.GET)
	public ResponseEntity<Order> findOrderById(@PathVariable("orderId") Integer orderId) {
		Order o = orderRepository.findById(orderId).isPresent() ? orderRepository.findById(orderId).get() : new Order();
		return new ResponseEntity<Order>(o, HttpStatus.OK);
	}

	@RequestMapping(value="/api/v1/Order/{orderId}", produces= {"application/json"}, method=RequestMethod.DELETE)
	public ResponseEntity<Order> cancelOrder(@PathVariable("orderId") Integer orderId) {
		Order o = orderRepository.findById(orderId).isPresent() ? orderRepository.findById(orderId).get() : new Order();
		o.setStatus("CANCELED");
		return new ResponseEntity<Order>(o, HttpStatus.OK);
	}

	@RequestMapping(value="/api/v1/Order", produces= {"application/json"}, method=RequestMethod.POST)
	public ResponseEntity<Order> save(@RequestBody Order order) {
		Order o = new Order();
		o = orderRepository.save(order);
		return new ResponseEntity<Order>(o, HttpStatus.OK);
	}

	@RequestMapping(value="/api/v1/Order/customer", produces= {"application/json"}, method=RequestMethod.GET)
	public ResponseEntity<List<Customer>> findCustomers() {
		List<Customer> customers = new ArrayList<Customer>(0);
		orderRepository.findAll().stream().forEach((p)->{
			customers.add(p.getCustomer());
		});
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}
	
}
