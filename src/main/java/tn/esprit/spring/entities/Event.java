package tn.esprit.spring.entities;

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
	
	
	/**
	 * @param id
	 * @param name
	 * @param startDate
	 * @param endDate
	 * @param time
	 * @param clients
	 */
	public Event(int id, String name, Date startDate, Date endDate, String time, Set<Client> clients) {
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		Time = time;
		this.clients = clients;
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

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return Time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		Time = time;
	}

	/**
	 * @return the clients
	 */
	public Set<Client> getClients() {
		return clients;
	}

	/**
	 * @param clients the clients to set
	 */
	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

}
