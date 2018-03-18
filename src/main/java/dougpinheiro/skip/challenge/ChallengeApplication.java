package dougpinheiro.skip.challenge;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import dougpinheiro.skip.challenge.controller.AuthenticationController;
import dougpinheiro.skip.challenge.controller.ClientOrderController;
import dougpinheiro.skip.challenge.controller.ClientOrdersController;
import dougpinheiro.skip.challenge.controller.ProductController;
import dougpinheiro.skip.challenge.model.entity.ClientOrder;
import dougpinheiro.skip.challenge.model.entity.ClientOrders;
import dougpinheiro.skip.challenge.model.entity.Login;
import dougpinheiro.skip.challenge.model.entity.Product;

@SpringBootApplication
public class ChallengeApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(ChallengeApplication.class, args);
		AuthenticationController ac = (AuthenticationController) ctx.getBean("authenticationController");
		
		
		System.out.println("#################################################################");
		System.out.println("Testing the login method...");
		if(ac.login(new Login("douglas", "pinheiro"))) {
			System.out.println("User logged!");			
		}else {
			System.out.println("User not logged!");						
		}
		System.out.println("#################################################################\n\n\n");
		System.out.println("#################################################################");
		System.out.println("Inserting products...");
		
		ProductController pc = (ProductController) ctx.getBean("productController");
		
		Stream<Integer> ids = Stream.iterate(1, n  ->  n  + 1).limit(15);
		
		DecimalFormat df = new DecimalFormat("$#.##");
		
		ids.forEach((n)->{
			pc.insertProduct(new Product("Product Example No "+n, Math.random()*30));
		});
		
		System.out.println("Listing products inserted...");
		
		pc.getAllProducts().stream().forEach((p)->{
			System.out.println(p.toString());
		});
		
		System.out.println("Products inserted!");
		System.out.println("#################################################################\n\n\n");
		
		
		System.out.println("#################################################################");
		System.out.println("Creating an order...");
		
		ClientOrder myOrder = new ClientOrder();
		Set<ClientOrders> registration = new HashSet<ClientOrders>();

		ClientOrderController clientOrderController = (ClientOrderController) ctx.getBean("clientOrderController");
		clientOrderController.createOrder(myOrder);
		
		//get a sort of products
		//register all the products to the order
		
		Stream<Integer> qtdProducts = Stream.iterate(1, (x) -> x+1).limit(Math.round(Math.random()*10));
		
		qtdProducts.forEach((c)->{
			if(Math.round(Math.random()*pc.getAllProducts().size()) > 0) {
				ClientOrders co = new ClientOrders(pc.findById(Math.round(Math.random()*pc.getAllProducts().size())), myOrder);
				ClientOrdersController coc = (ClientOrdersController) ctx.getBean("clientOrdersController");
				coc.save(co);
				registration.add(co);
			}
		});
		
		myOrder.setClientOrders(registration);
		
		System.out.println("Order created!");
		System.out.println("#################################################################\n\n\n");
		System.out.println("#################################################################");
		
		System.out.println("Showing order...");
		
		System.out.println("ORDER : "+myOrder.getIdClientOrder());
		System.out.println("ORDER_TIME : "+myOrder.getOrderTime().toString());
		System.out.println("STATUS : "+myOrder.getStatus());
		System.out.println("PRODUCTS: ------------------------------------------------------");
		
		//list all products from the order
		myOrder.getClientOrders().stream().forEach((c) -> {
			System.out.println(c.getProduct().getDescription());
		});
		
		System.out.println("#################################################################\n\n\n");
		System.out.println("#################################################################");
		
		System.out.println("Canceling the order...");
		clientOrderController.cancelOrder(myOrder);
		System.out.println("Order Canceled");
		System.out.println("#################################################################\n\n\n");
		
		System.out.println("#################################################################");
		System.out.println("Checking order status...");
		System.out.println("Order "+myOrder.getIdClientOrder()+" - "+myOrder.getStatus());
		System.out.println("#################################################################");
		
		
	}
}
