package com.revature.charityappnotificationms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.revature.charityappnotificationms.domain.User;
import com.revature.charityappnotificationms.message.Message;
import com.revature.charityappnotificationms.service.EmailService;

@RestController
@RequestMapping("mail")
public class MailController {

	@Autowired
	private EmailService notificationService;

	@PostMapping("send")
	public ResponseEntity<Object> mailSender(@RequestBody User user) {
		String errorMessage = null;
		System.out.println(user);
		try {
			//notificationService.sendMail(user);

			return new ResponseEntity<Object>( HttpStatus.OK);
		} catch (MailException mailException) {
			Message message = new Message(errorMessage);
			return new ResponseEntity<Object>(message, HttpStatus.BAD_REQUEST);
		}

	}

}