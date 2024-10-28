package com.example.VotingApplication;

public interface User {
	
	void setUserNames(String userName);
	String getUserName();
	void setPoliticalParty(PoliticalParty politicalParty);
	PoliticalParty getPoliticalParty();

}
