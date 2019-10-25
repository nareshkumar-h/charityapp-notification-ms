package com.revature.charityappnotificationms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.revature.charityappnotificationms.domain.Email;
import com.revature.charityappnotificationms.domain.User;
import com.revature.charityappnotificationms.message.Message;
import com.revature.charityappnotificationms.service.EmailService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("mail")
public class MailController {

	@Autowired
	private EmailService notificationService;
	
	@PostMapping("/send")
	@ApiOperation(value = "sendEmail API")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Email sent successfully", response = User.class),
	        @ApiResponse(code = 400, message = "Email not sent", response = Message.class) })
	public ResponseEntity<Object> mailSender(@RequestBody Email email) {
		String errorMessage = null;
		System.out.println(email);
		try {
			notificationService.sendMail(email);
			System.out.println(email);
			return new ResponseEntity<Object>( HttpStatus.OK);
		} catch (MailException mailException) {
			mailException.printStackTrace();
			Message message = new Message(errorMessage);
			return new ResponseEntity<Object>(message, HttpStatus.BAD_REQUEST);
		}

	}
	@PostMapping("/registeruser")
	@ApiOperation(value = "sendEmail API")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Email sent successfully", response = User.class),
	        @ApiResponse(code = 400, message = "Email not sent", response = Message.class) })
	public ResponseEntity<Object> registerMail(@RequestBody User user) {
		String errorMessage = null;
		System.out.println(user);
		try {
			notificationService.sendRegistrationMail(user);
			return new ResponseEntity<Object>( HttpStatus.OK);
		} catch (MailException mailException) {
			mailException.printStackTrace();
			Message message = new Message(errorMessage);
			return new ResponseEntity<Object>(message, HttpStatus.BAD_REQUEST);
		}

}}