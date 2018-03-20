package dougpinheiro.skip.challenge.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dougpinheiro.skip.challenge.model.data.Authentication;
import dougpinheiro.skip.challenge.model.entity.Customer;
import dougpinheiro.skip.challenge.repository.CustomerRepository;
import dougpinheiro.skip.challenge.repository.LoginRepository;

@RestController
public class CustomerController {

	private boolean logged = false;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private LoginRepository loginRepository;
	
	@RequestMapping(value="/api/v1/Customer/auth", produces= {"application/json"}, method=RequestMethod.POST)
	public ResponseEntity<Authentication> auth(@RequestParam("email") String email, @RequestParam("password") String password) {
		Authentication auth = new Authentication();
		try {
			auth = new Authentication();  
			auth.setLogged(!loginRepository.findByLoginAndPassword(email, new String(Base64.getEncoder().encode(MessageDigest.getInstance("MD5").digest(password.getBytes())))).isEmpty());
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
	
	public boolean isLogged() {
		return logged;
	}

	public void setLogged(boolean logged) {
		this.logged = logged;
	}
	
}
