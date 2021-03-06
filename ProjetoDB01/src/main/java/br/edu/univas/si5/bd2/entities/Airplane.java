package br.edu.univas.si5.bd2.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="AIRPLANE")
public class Airplane {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "regSeqGen_1")
	@SequenceGenerator(name = "regSeqGen_1", sequenceName = "SEQ_AIRPLANE", allocationSize = 1)
	private int id;
	
	@OneToMany(mappedBy="id_airplane")
	private Set<Flights> flys;
	
	@OneToOne
	@JoinColumn(name="record_fk")
	private AirplaneDetail record_detail;
	
	@Column(name="maintenance")
	@Temporal(TemporalType.TIMESTAMP)
	private Date maintenance;
	
	public Airplane() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getMaintenance() {
		return maintenance;
	}

	public void setMaintenance(Date maintenance) {
		this.maintenance = maintenance;
	}

	public AirplaneDetail getRecord_detail() {
		return record_detail;
	}

	public void setRecord_detail(AirplaneDetail record_detail) {
		this.record_detail = record_detail;
	}

	public Set<Flights> getFlys() {
		return flys;
	}

	public void setFlys(Set<Flights> flys) {
		this.flys = flys;
	}

}
