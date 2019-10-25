package com.revature.charityappnotificationms;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.charityappnotificationms.domain.Email;
import com.revature.charityappnotificationms.service.EmailService;

@SpringBootTest
class CharityappNotificationMsApplicationTests {

	@Autowired
	private EmailService emailService;
	
	
	@Test
	void testMail() {
		Email email = new Email();
		email.setTo("jayakrishnakrish1998@gmail.com");
		email.setSubject("Test1");
		email.setText("Text1");
		emailService.sendMail(email);
	}

}
