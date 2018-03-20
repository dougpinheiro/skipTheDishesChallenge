package dougpinheiro.skip.challenge;

import static org.junit.Assert.assertEquals;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import dougpinheiro.skip.challenge.controller.CustomerController;
import dougpinheiro.skip.challenge.controller.OrderController;
import dougpinheiro.skip.challenge.controller.ProductController;
import dougpinheiro.skip.challenge.model.data.Authentication;
import dougpinheiro.skip.challenge.model.entity.Customer;
import dougpinheiro.skip.challenge.model.entity.Order;
import dougpinheiro.skip.challenge.model.entity.OrderItem;
import dougpinheiro.skip.challenge.model.entity.Product;
import dougpinheiro.skip.challenge.model.entity.Store;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChallengeApplicationTests {

	@Autowired
	CustomerController customerController;
	
	@Autowired
	ProductController productController;

	@Autowired
	OrderController orderController;
	
	@Test
	public void authenticationTest() {
		ResponseEntity<Authentication> auth = customerController.auth("test@test.com", "12345");
		assertEquals("Authentication failed", auth.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void queryProducts() {
		ResponseEntity<Product> productQuery = productController.findProductById(1);
		Store s = new Store(6, "Store 6");
		Product product_3 = new Product(1, "Big Mac", "Big Mac Combo", 5.00, s);
		assertEquals("Quering product 3 failed!", new ResponseEntity<Product>(product_3, HttpStatus.OK).getStatusCode(), productQuery.getStatusCode());
	}

	@Test
	public void receiveOrderAndSaveToDatabase() throws NoSuchAlgorithmException {
		Customer c = customerController.findCustomerById(1).getBody();
		Store s = new Store(1, "Store 100");
		List<OrderItem> items = new ArrayList<OrderItem>(0);
		items.add(new OrderItem(1, productController.findProductById(3).getBody(), 5.00, 10.00, 2));
		Order o = new Order("2018-03-19T23:33:28.580Z", c, "Address 2", "Contact Teste 2", s, 25.00, "NEW", "2018-03-19T23:33:28.580Z", items);
		ResponseEntity<Order> productQuery = orderController.save(o);
		assertEquals("Order reciver failed!", new ResponseEntity<Order>(o, HttpStatus.OK).getStatusCode(), productQuery.getStatusCode());
	}
	
	@Test
	public void cancelOrderAndGetOrderStatus() {
		Order o = orderController.cancelOrder(1).getBody();
		assertEquals("Canceling order failed!", o.getStatus(), "CANCELED");
	}

	

}
