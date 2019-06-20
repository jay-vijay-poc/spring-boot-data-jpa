package com.java.email.api.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.email.api.config.OneTimePasswordConfig;
import com.java.email.api.dto.MailRequest;
import com.java.email.api.dto.MailResponse;
import com.java.email.api.service.EmailService;

@RestController
@RequestMapping("/api")
public class MailController {
	@Autowired
	private EmailService service;

	@PostMapping("/sendingEmail")
	public ResponseEntity<MailResponse> sendEmail(@RequestBody MailRequest request) {
		OneTimePasswordConfig otp = new OneTimePasswordConfig();
		Map<String, Object> model = new HashMap<>();
		String oneTime = otp.getOneTimePassword();
		model.put("name", request.getName().toUpperCase());
		model.put("otp", oneTime);
		service.saveOneTimePassword(oneTime);
		MailResponse res = service.sendEmail(request, model);
		return new ResponseEntity<MailResponse>(res, HttpStatus.OK);
	}

	public ResponseEntity<Map<String, String>> verifyOTP(String otp) {
		Map<String, String> map = null;

		return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
	}
}
