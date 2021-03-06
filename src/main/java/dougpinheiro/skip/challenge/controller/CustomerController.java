package dougpinheiro.skip.challenge.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dougpinheiro.skip.challenge.model.data.Authentication;
import dougpinheiro.skip.challenge.model.entity.Customer;
import dougpinheiro.skip.challenge.repository.CustomerRepository;

@RestController
public class CustomerController {

	private boolean logged = false;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@RequestMapping(value="/api/v1/Customer/auth", produces= {"application/json"}, method=RequestMethod.POST)
	public ResponseEntity<Authentication> auth(@RequestParam("email") String email, @RequestParam("password") String password) {
		Authentication auth = new Authentication();
		try {
			auth = new Authentication();
			boolean logged = !customerRepository
					.findByEmailAndPassword(email, new String(Base64.getEncoder().encode(MessageDigest.getInstance("MD5").digest(password.getBytes())))).isEmpty();
			auth.setLogged(logged);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Authentication>(auth, HttpStatus.OK);
	}
	
	@RequestMapping(value="/api/v1/Customer", produces= {"application/json"}, method=RequestMethod.POST)
	public ResponseEntity<Customer> save(@RequestBody Customer customer) {
		Customer c = customerRepository.save(customer);
		return new ResponseEntity<Customer>(c, HttpStatus.OK);
	}
	
	@RequestMapping(value="/api/v1/Customer/{customerId}", produces= {"application/json"}, method=RequestMethod.GET)
	public ResponseEntity<Customer> findCustomerById(@PathVariable("customerId") Integer customerId) {
		Customer c = new Customer();
		c = customerRepository.findById(customerId).isPresent() ? customerRepository.findById(customerId).get() : new Customer();
		return new ResponseEntity<Customer>(c, HttpStatus.OK);
	}
	
	public boolean isLogged() {
		return logged;
	}

	public void setLogged(boolean logged) {
		this.logged = logged;
	}
	
}
