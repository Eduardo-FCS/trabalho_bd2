package br.edu.univas.si5.bd2.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="DETAIL")
public class AirplaneDetail {
	
	@Id
	@Column(name="record")
	private String record;
	
	@OneToOne(mappedBy="record_detail")
	private Airplane airplane;
	
	@Column(name="manufacterer")
	private String manufacturer;
	
	@Column(name="model")
	private String model;
	
	@Column(name="capacity")
	private Integer capacity;
	
	public AirplaneDetail() {}

	public String getRecord() {
		return record;
	}

	public void setRecord(String record) {
		this.record = record;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Airplane getAirplane() {
		return airplane;
	}

	public void setAirplane(Airplane airplane) {
		this.airplane = airplane;
	}
	
	
}
