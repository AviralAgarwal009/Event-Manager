package com.springboot.EventManager.entity;

import java.sql.Blob;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "participants")
public class Participants {
	@Id
	@Column(name = "reg_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "full_name")
	@Getter
	@Setter
	private String name;

	@Column(name = "mobile_number")
	@Getter
	@Setter
	private int contact;

	@Column(name = "id_card")
	@Getter
	@Setter
	private Blob identity;

	@Column(name = "reg._type")
	@Getter
	@Setter
	private String regType;

	@Column(name = "tickets_qty")
	@Getter
	@Setter
	private int ticketsQty;

	@Column(name = "date_time")
	private Date dateTime;

	@Override
	public String toString() {
		return "Participants [id=" + id + ", name=" + name + ", contact=" + contact + ", identity=" + identity
				+ ", regType=" + regType + ", ticketsQty=" + ticketsQty + ", dateTime=" + dateTime + "]";
	}

}
