package br.edu.univas.si5.bd2.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Flights {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "regSeqGen")
	@SequenceGenerator(name = "regSeqGen", sequenceName = "SEQ_FLIGHTS", allocationSize = 1)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="id_fk")
	private Airplane id_airplane;
	
	@Column(name="time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date time;
	
	@Column(name="pilot")
	private String pilot;
	
	public Flights() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Date getTime() {
		return time;
	}
	
	public void setTime(Date time) {
		this.time = time;
	}

	public String getPilot() {
		return pilot;
	}

	public void setPilot(String pilot) {
		this.pilot = pilot;
	}

	public Airplane getId_airplane() {
		return id_airplane;
	}

	public void setId_airplane(Airplane id_airplane) {
		this.id_airplane = id_airplane;
	}

}
