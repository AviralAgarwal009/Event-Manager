package com.springboot.EventManager.entity;

import java.sql.Blob;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "participants")
public class Participants {
	@Id
	@Column(name = "reg_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "full_name")
	private String name;

	@Column(name = "mobile_number")
	private Long contact;

	@Column(name = "email_id")
	private String email;

	@Column(name = "id_card")
	private Blob identity;

	@Column(name = "reg_type")
	private String regType;

	@Column(name = "tickets_qty")
	private Integer ticketsQty;

	@Column(name = "date_time")
	private Date dateTime;
	


	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Long getContact() {
		return contact;
	}



	public void setContact(Long contact) {
		this.contact = contact;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public Blob getIdentity() {
		return identity;
	}



	public void setIdentity(Blob identity) {
		this.identity = identity;
	}



	public String getRegType() {
		return regType;
	}



	public void setRegType(String regType) {
		this.regType = regType;
	}



	public Integer getTicketsQty() {
		return ticketsQty;
	}



	public void setTicketsQty(Integer ticketsQty) {
		this.ticketsQty = ticketsQty;
	}



	public Date getDateTime() {
		return dateTime;
	}



	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}



	@Override
	public String toString() {
		return "Participants [id=" + id + ", name=" + name + ", contact=" + contact + ", email=" + email + ", identity="
				+ identity + ", regType=" + regType + ", ticketsQty=" + ticketsQty + ", dateTime=" + dateTime + "]";
	}

}
