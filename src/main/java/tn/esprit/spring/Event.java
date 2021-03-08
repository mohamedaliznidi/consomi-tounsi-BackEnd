package tn.esprit.spring;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Event {
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

}
