package com.java.email.api.base;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@MappedSuperclass
public class MasterBaseEntity implements Serializable {
	private static final long serialVersionUID = 7442096420121476686L;
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	@Column(name = "ID", updatable = false, length = 200)
	private String id;

}
