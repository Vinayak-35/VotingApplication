package com.example.VotingApplication;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//@SpringBootApplication
public class VotingApplication {

	public static void main(String[] args) {
//		SpringApplication.run(VotingApplication.class, args);

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				"com.example.VotingApplication");

		AuthorityCounter authorityCounter = (AuthorityCounter) applicationContext.getBean("simpleAuthorityCounter");

		while (true) {
			System.out.println("Welcome user");
			Scanner scanner = new Scanner(System.in);
			System.out.println("Choose from below:\n1. I wanna vote\n2. See all votes(ADMIN)");
			int userInput = scanner.nextInt();
			String beanId = "";

			switch (userInput) {
			case 1: {
				System.out.println("Enter your username:");
				scanner.nextLine();
				String userName = scanner.nextLine();
				User user = (User) applicationContext.getBean("user");
				user.setUserNames(userName);

				System.out
						.println("Choose the party you wants to vote for:\n1. Democratic\n2. Republic\n3. Independant");
				int userPartSelect = scanner.nextInt();
				switch (userPartSelect) {
				case 1: {
					beanId = "democratic";
					break;
				}
				case 2: {
					beanId = "republic";
					break;
				}
				case 3: {
					beanId = "independant";
					break;
				}
				}
				PoliticalParty politicalParty = (PoliticalParty) applicationContext.getBean(beanId);
				user.setPoliticalParty(politicalParty);
				UserList userList = (UserList) applicationContext.getBean("userlist");
				userList.addUser(user);
//				authorityCounter.setUserList(userList);
				System.out.println("Thank you!");
				break;
			}

			case 2: {
				authorityCounter.getUserList().getUserLIst().forEach(item -> System.out
						.println(item.getUserName() + " is voted for " + item.getPoliticalParty().getPartyName()));
				applicationContext.close();
				break;
			}
			}
		}
	}

}
