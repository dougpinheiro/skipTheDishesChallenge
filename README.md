# SkipTheDishes Java Challenge

# Build an API to:
	
		
*   Allow Authentication
*   Query Products
*	Receive Orders
*	Cancel an Order
*	Get Order Status
*	Store data in a database of his/her choice
	
# Database configuration

**	Database: MySQL **
*	spring.datasource.url = jdbc:mysql://localhost:3306/skip?useSSL=false
*	spring.datasource.username = skip
*	spring.datasource.password = skip
*	spring.datasource.testWhileIdle = true
*	spring.datasource.validationQuery = SELECT 1
*	spring.jpa.show-sql = true
*	spring.jpa.hibernate.ddl-auto = create-drop
*	spring.jpa.hibernate.naming-strategy = org.hibernate.cfg.ImprovedNamingStrategy
*	spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5Dialect

	
# JUnit Tests

**Authentication Test:**
	
		@Test
		public void authenticationTest() {
			ResponseEntity<Authentication> auth = customerController.auth("test@test.com", "12345");
			assertEquals("Authentication failed", auth.getStatusCode(), HttpStatus.OK);
		}
	
**Quering Products Test:**
	
		@Test
		public void queryProducts() {
			ResponseEntity<Product> productQuery = productController.findProductById(1);
			Store s = new Store(6, "Store 6");
			Product product_3 = new Product(1, "Big Mac", "Big Mac Combo", 5.00, s);
			assertEquals("Quering product 3 failed!", new ResponseEntity<Product>(product_3, HttpStatus.OK).getStatusCode(), 		productQuery.getStatusCode());
		}

**Receiving Order and saving to database:**
	
		@Test
		public void receiveOrderAndSaveToDatabase() throws NoSuchAlgorithmException {
			Customer c = customerController.findCustomerById(1).getBody();
			Store s = new Store(1, "Store 100");
			List<OrderItem> items = new ArrayList<OrderItem>(0);
			items.add(new OrderItem(1, productController.findProductById(3).getBody(), 5.00, 10.00, 2));
			Order o = new Order("2018-03-19T23:33:28.580Z", c, "Address 2", "Contact Teste 2", s, 25.00, "NEW", "2018-03-19T23:33:28.580Z",items);
			ResponseEntity<Order> productQuery = orderController.save(o);
			assertEquals("Order reciver failed!", new ResponseEntity<Order>(o, HttpStatus.OK).getStatusCode(), productQuery.getStatusCode());
		}
	
**Canceling Order and getting order status:**
	
		@Test
		public void cancelOrderAndGetOrderStatus() {
			Order o = orderController.cancelOrder(1).getBody();
			assertEquals("Canceling order failed!", o.getStatus(), "CANCELED");
		}

