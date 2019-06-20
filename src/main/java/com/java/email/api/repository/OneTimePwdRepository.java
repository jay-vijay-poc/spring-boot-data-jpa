package com.java.email.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.email.api.entity.OneTimePassword;

public interface OneTimePwdRepository extends JpaRepository<OneTimePassword, String> {

}
