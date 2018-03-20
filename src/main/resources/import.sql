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

INSERT INTO `skip`.`customer`(`id`,`address`,`creation`,`email`,`name`) VALUES (1,"Address Test number 1","2018-03-19T23:33:28.580Z","test@test.com","Test User");

INSERT INTO `skip`.`login`(`id`,`login`,`password`,`customer_id`) VALUES (1,"teste@teste.com","gnzLDuqKcGxMNKFokfhOew==",1);




