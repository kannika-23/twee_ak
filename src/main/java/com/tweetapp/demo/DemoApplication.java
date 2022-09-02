package com.tweetapp.demo;

import com.tweetapp.demo.dao.CustomRepo;
import com.tweetapp.demo.dao.UserRepo;
import com.tweetapp.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//@SpringBootApplication
//public class DemoApplication  implements CommandLineRunner {

//@EnableSwagger2
@SpringBootApplication
//@EnableSwagger2
//@Configuration
public class DemoApplication {

	/*@Autowired
	UserRepo userRepo;

	@Autowired
	CustomRepo customRepo;
	List<User> itemList = new ArrayList<User>();*/

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

//	@Bean
//	public Docket productApi() {
//		return new Docket(DocumentationType.SWAGGER_2).select()
//				.apis(RequestHandlerSelectors.basePackage("com.tweetapp.demo")).build();
//	}
//	@Bean
//	public Docket productApi() {
//		return new Docket(DocumentationType.SWAGGER_2).select()
//				.apis(RequestHandlerSelectors.basePackage("com.tweetapp.demo")).build();
//	}

	/*@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}*/

	/*@Override
	public void run(String... args) throws Exception {
		/*userRepo.deleteAll();
		System.out.println("-------------CREATE user-------------------------------\n");
		createUser();
		System.out.println("\n----------------SHOW ALL Users---------------------------\n");
		showAllUsers();
		System.out.println("\n--------------GET ITEM BY NAME-----------------------------------\n");
		getUserByName("kags@gmail.com");
		System.out.println("\n-----------UPDATE password OF A GROCERY ITEM------------------------\n");
		resetUserPassword("kags1@gmail.com", "password1");
		System.out.println("\n------------FINAL COUNT OF user-------------------------\n");
		findCountOfUser();
		System.out.println("\n----------DELETE A GROCERY user----------------------------------\n");
		deleteUser("Kags@gmail.com");*/
	//}


	//CREATE
	/*void createUser() {
		System.out.println("Data creation started...");
		userRepo.save(new User("kags","kags","Female", LocalDate.now(),"123123123","kags@gmail.com","password"));
		userRepo.save(new User("kags1","kags1","Female", LocalDate.now(),"123123123","kags1@gmail.com","password"));
		System.out.println("Data creation complete...");
	}

	// READ
	// 1. Show all the data
	public void showAllUsers() {
		itemList = userRepo.findAll();
		itemList.forEach(item -> System.out.println(getItemDetails(item)));
	}
	// 2. Get item by name
	public void getUserByName(String name) {
		System.out.println("Getting item by name: " + name);
		User item = userRepo.findItemByName(name);
		System.out.println(getItemDetails(item));
	}

	// UPDATE APPROACH 2: Using MongoTemplate
	public void resetUserPassword(String email, String password) {
		System.out.println("Updating quantity for " + email);
		customRepo.updateUserPassword(email, password);
	}

	// 4. Get count of documents in the collection
	public void findCountOfUser() {
		long count = userRepo.count();
		System.out.println("Number of documents in the collection = " + count);
	}

	// DELETE
	public void deleteUser(String email) {
		userRepo.deleteById(email);
		System.out.println("Item with id " + email + " deleted...");
	}

	public String getItemDetails(User item) {
		System.out.println(
				"Item Name: " + item.getFirstName() +
						", \nItem Email"  + item.getEmail() +
						", \nItem Mobile " + item.getMobile()
		);

		return "";
	}*/
}
