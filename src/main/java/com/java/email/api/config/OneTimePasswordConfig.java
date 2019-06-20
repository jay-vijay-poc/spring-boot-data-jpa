package com.java.email.api.config;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class OneTimePasswordConfig {

	public String getOneTimePassword() {
		System.out.println("#### in OneTimePasswordConfig Class, getOneTimePassword method..");
		final String OTP = UUID.randomUUID().toString().substring(0, 6);
		return OTP;

	}
}
