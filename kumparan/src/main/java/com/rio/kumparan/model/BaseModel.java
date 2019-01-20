package com.rio.kumparan.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class BaseModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4072476750036357874L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date creatOn = new Date();
	
	private Date modiOn;
	
	private Boolean isDel;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatOn() {
		return creatOn;
	}

	public void setCreatOn(Date creatOn) {
		this.creatOn = creatOn;
	}

	public Date getModiOn() {
		return modiOn;
	}

	public void setModiOn(Date modiOn) {
		this.modiOn = modiOn;
	}

	public Boolean getIsDel() {
		return isDel;
	}

	public void setIsDel(Boolean isDel) {
		this.isDel = isDel;
	}
	
}
