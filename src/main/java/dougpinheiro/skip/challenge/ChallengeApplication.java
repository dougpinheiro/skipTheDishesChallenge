package dougpinheiro.skip.challenge;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import dougpinheiro.skip.challenge.controller.AuthenticationController;
import dougpinheiro.skip.challenge.controller.ClientOrderController;
import dougpinheiro.skip.challenge.controller.ClientOrdersController;
import dougpinheiro.skip.challenge.controller.ProductController;
import dougpinheiro.skip.challenge.model.data.Status;
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
		
		Stream<Integer> ids = Stream.iterate(1, n  ->  n  + 1).limit(100);
		
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
		
		ClientOrder myOrder = new ClientOrder(new Date(), Status.NEW);
		
		ClientOrderController corderc = (ClientOrderController) ctx.getBean("clientOrderController");
		corderc.save(myOrder);
		
		Stream<Integer> productsPerOrder = Stream.iterate(1, n  ->  n  + 1).limit(Math.round(Math.random()*5));
		
		ClientOrdersController coc = (ClientOrdersController) ctx.getBean("clientOrdersController");
		
		productsPerOrder.forEach((p)->{
			Integer i = (int) (Math.random() * pc.getAllProducts().size());
			Product pTemp = pc.getAllProducts().get(i);
			ClientOrders co = new ClientOrders(pTemp.getId(), myOrder.getId());
			coc.save(co);
			
		});
		
		corderc.createOrder(myOrder);
		System.out.println("Order created!");
		System.out.println("#################################################################\n\n\n");
		System.out.println("#################################################################");
		
		System.out.println("Showing order...");
		
		System.out.println("ORDER : "+myOrder.getId());
		System.out.println("ORDER_TIME : "+myOrder.getOrderTime().toGMTString());
		System.out.println("STATUS : "+myOrder.getStatus());
		System.out.println("PRODUCTS: ------------------------");
		
		List<Product> prods_order = new ArrayList<Product>();
		coc.getAllClientOrders().stream().filter((p)->{
			if(p.getId_order() == myOrder.getId()) {
				return true;
			}else {
				return false;
			}
		}).forEach((p2)->{
			if(p2.getId_product() != null) {
				System.out.println(pc.findById(p2.getId_product()).getDescription());
			}
		});
		
		System.out.println("#################################################################\n\n\n");
		System.out.println("#################################################################");
		
		System.out.println("Canceling the order...");
		corderc.cancelOrder(myOrder);
		System.out.println("Order Canceled");
		System.out.println("#################################################################\n\n\n");
		
		System.out.println("#################################################################");
		System.out.println("Checking order status...");
		System.out.println("Order "+myOrder.getId()+" - "+myOrder.getStatus());
		System.out.println("#################################################################");
		
		
	}
}
