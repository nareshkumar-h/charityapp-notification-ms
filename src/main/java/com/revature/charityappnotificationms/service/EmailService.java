package com.revature.charityappnotificationms.service;



import com.revature.charityappnotificationms.domain.Email;
import com.revature.charityappnotificationms.domain.User;


public interface EmailService {

	Email sendMail(Email email);
	
	void sendRegistrationMail(User user);
	
	
	
	

}
