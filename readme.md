# Database Table DDL scripts
1. user_details:


CREATE TABLE `user_details` (
	`user_id`	VARCHAR(50) NOT NULL,
	`first_name`	VARCHAR(100) NOT NULL,
	`last_name`	VARCHAR(100),
	`email`	VARCHAR(150) NOT NULL UNIQUE,
	`phone`	INT,
	FOREIGN KEY(`user_id`) REFERENCES user_authentication(user_id) ON DELETE CASCADE ON UPDATE CASCADE
);

2. user_authentication: 

CREATE TABLE `user_authentication` (
	`user_id`	VARCHAR(50) NOT NULL UNIQUE,
	`user_name`	VARCHAR(100) NOT NULL UNIQUE,
	`password`	VARCHAR(100) NOT NULL UNIQUE,
	PRIMARY KEY(`user_id`)
);



http://javabeat.net/spring-data-jpa/

https://github.com/pfac/demo-spring-data-jpa-hibernate-h2/blob/master/src/main/java/com/iampfac/demo/data/jpa/JpaProxyUserRepository.java

https://hellokoding.com/jpa-one-to-one-foreignkey-relationship-example-with-spring-boot-maven-and-mysql/

https://spring.io/guides/gs/actuator-service/

https://dzone.com/articles/crud-using-spring-data-rest

http://jasonwatmore.com/post/2015/03/10/angularjs-user-registration-and-login-example-tutorial