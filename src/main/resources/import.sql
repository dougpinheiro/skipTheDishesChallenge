INSERT INTO `skip`.`cousine` (`id`,`type`) VALUES (1, "Indian");
INSERT INTO `skip`.`cousine` (`id`,`type`) VALUES (2, "Brazilian");
INSERT INTO `skip`.`cousine` (`id`,`type`) VALUES (3, "Italian");
INSERT INTO `skip`.`cousine` (`id`,`type`) VALUES (4, "Japanese");


INSERT INTO `skip`.`store`(`id`,`name`) VALUES (1,"Store 1");
INSERT INTO `skip`.`store`(`id`,`name`) VALUES (2,"tore 2");
INSERT INTO `skip`.`store`(`id`,`name`) VALUES (3,"Store 3");
INSERT INTO `skip`.`store`(`id`,`name`) VALUES (4,"Store 4");
INSERT INTO `skip`.`store`(`id`,`name`) VALUES (5,"Store 5");
INSERT INTO `skip`.`store`(`id`,`name`) VALUES (6,"Store 6");
INSERT INTO `skip`.`store`(`id`,`name`) VALUES (7,"Store 7");
INSERT INTO `skip`.`store`(`id`,`name`) VALUES (8,"Store 8");
INSERT INTO `skip`.`store`(`id`,`name`) VALUES (9,"Store 9");
INSERT INTO `skip`.`store`(`id`,`name`) VALUES (10,"Store 10");
INSERT INTO `skip`.`store`(`id`,`name`) VALUES (11,"Store 11");
INSERT INTO `skip`.`store`(`id`,`name`) VALUES (12,"Store 12");

INSERT INTO `skip`.`storecousine`(`id`,`cousine_id`,`store_id`) VALUES (1,1,1);
INSERT INTO `skip`.`storecousine`(`id`,`cousine_id`,`store_id`) VALUES (2,2,2);
INSERT INTO `skip`.`storecousine`(`id`,`cousine_id`,`store_id`) VALUES (3,3,3);
INSERT INTO `skip`.`storecousine`(`id`,`cousine_id`,`store_id`) VALUES (4,4,4);
INSERT INTO `skip`.`storecousine`(`id`,`cousine_id`,`store_id`) VALUES (5,1,5);
INSERT INTO `skip`.`storecousine`(`id`,`cousine_id`,`store_id`) VALUES (6,2,6);
INSERT INTO `skip`.`storecousine`(`id`,`cousine_id`,`store_id`) VALUES (7,3,7);
INSERT INTO `skip`.`storecousine`(`id`,`cousine_id`,`store_id`) VALUES (8,4,8);
INSERT INTO `skip`.`storecousine`(`id`,`cousine_id`,`store_id`) VALUES (9,5,9);

INSERT INTO `skip`.`customer`(`id`, `address`,`creation`,`email`,`name`, `password`) VALUES (1, "Address Test number 1","2018-03-19T23:33:28.580Z","test@test.com","Test User", "gnzLDuqKcGxMNKFokfhOew==");

INSERT INTO `skip`.`clientorder`(`id`, `contact`,`date`,`deliveryaddress`,`lastupdate`,`status`,`total`,`customer_id`,`store_id`) VALUES (1, "Contact test","2018-03-19T23:33:28.580Z","Test Avenue 1","2018-03-19T23:33:28.580Z","NEW", 10.3, 1, 6);

INSERT INTO `skip`.`product` (`id`,`description`,`name`,`price`,`store_id`) VALUES (1,"Big Mac Combo","Big Mac",5.00,6);
INSERT INTO `skip`.`product` (`id`,`description`,`name`,`price`,`store_id`) VALUES (2,"Spaghetti Al Freddo","Spaghetti",5.00,2);
INSERT INTO `skip`.`product` (`id`,`description`,`name`,`price`,`store_id`) VALUES (3,"Big Mac","Big Mac",3.50,4);
INSERT INTO `skip`.`product` (`id`,`description`,`name`,`price`,`store_id`) VALUES (4,"Big Fish","Big Mac",4.14,5);
INSERT INTO `skip`.`product` (`id`,`description`,`name`,`price`,`store_id`) VALUES (5,"Quarter Pounder","Big Mac",6.01,5);
INSERT INTO `skip`.`product` (`id`,`description`,`name`,`price`,`store_id`) VALUES (6,"Harumaki","Sushi",14.99,8);

INSERT INTO `skip`.`orderitem`(`id`,`price`,`quantity`,`total`,`order_id`,`product_id`) VALUES (1,6.01,10,60.10,1,5);








