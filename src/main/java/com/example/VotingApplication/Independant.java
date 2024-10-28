package com.example.VotingApplication;

import org.springframework.stereotype.Component;

@Component("independant")
public class Independant implements PoliticalParty{
	
	private String partyName = "Independant";
	
	@Override
	public String getPartyName() {
		return this.partyName;
	}
	
}
