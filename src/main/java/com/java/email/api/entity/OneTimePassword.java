package com.java.email.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.java.email.api.base.MasterBaseEntity;

import lombok.Data;

@Entity
@Table(name = "TB_OTP")
@Data
public class OneTimePassword extends MasterBaseEntity {

	@Column(name = "ONE_TIME_PWD", nullable = false)
	private String oneTimePwd;

}
