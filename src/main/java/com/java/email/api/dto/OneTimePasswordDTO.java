package com.java.email.api.dto;

import org.dozer.DozerBeanMapper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.java.email.api.entity.OneTimePassword;

public class OneTimePasswordDTO {

	@org.dozer.Mapping("id")
	private String oneTimePwdId;

	private String oneTimePwd;

	@JsonIgnore
	private DozerBeanMapper mapper = new DozerBeanMapper();

	@JsonIgnore
	public OneTimePassword getEntity(OneTimePassword entity) {
		if (entity == null) {
			entity = mapper.map(this, OneTimePassword.class);
		} else {
			mapper.map(this, entity);
		}

		return entity;
	}

	@JsonIgnore
	public OneTimePasswordDTO getDTO(OneTimePassword entity) {
		mapper.map(entity, this);
		return this;
	}
}
