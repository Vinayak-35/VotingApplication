package com.example.VotingApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component("simpleAuthorityCounter")
public class SimpleAuthorityCounter implements AuthorityCounter{
	
	@PostConstruct
	public void init() {
		System.out.println("DB Connection Successfull");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("VOTING HAS BEEN CLOSED!!");
		System.out.println();
	}

	@Autowired
	private UserList userList;
	

	@Override
	public UserList getUserList() {
		return this.userList;
	}
	
	

}
