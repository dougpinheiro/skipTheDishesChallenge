package dougpinheiro.skip.challenge.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dougpinheiro.skip.challenge.model.entity.Login;

@RestController
public class AuthenticationController {

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public boolean login(@RequestBody Login login) {
		if(login.getLogin().equals("douglas") && login.getPassword().equals("pinheiro")) {
			return true;
		} else {
			return false;
		}
	} 
}
