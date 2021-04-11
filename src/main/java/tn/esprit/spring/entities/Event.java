/*package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity

public class Event implements Serializable {
	
	
	
	public Event(int id, String name, Date startDate, Date endDate, String time) {
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		Time = time;
	}

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="EVENT_ID")
	private int id; 

	@Column(name="EVENT_NAME")
	private String name;

	@Column(name="EVENT_START_DATE")
	@Temporal (TemporalType.DATE)
	private Date  startDate;

	@Column(name="EVENT_END_DATE")
	@Temporal (TemporalType.DATE)
	private Date  endDate;
	
	@Column(name="EVENT_TIME")
	private String Time;
	
	@ManyToMany(mappedBy="events", cascade = CascadeType.ALL)
	private Set<Client> clients;

	//Getters&Setters
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

	
	public Date getStartDate() {
		return startDate;
	}

	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	
	public Date getEndDate() {
		return endDate;
	}

	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	
	public String getTime() {
		return Time;
	}

	
	public void setTime(String time) {
		Time = time;
	}

	
}
*/