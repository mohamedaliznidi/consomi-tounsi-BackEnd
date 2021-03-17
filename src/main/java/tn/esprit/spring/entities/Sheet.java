package tn.esprit.spring.entities;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity 
@Getter
@Setter
@RequiredArgsConstructor
public class Sheet implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="SHEET_ID")
	private int id ;
	@NonNull
	private boolean Student;

	@NonNull
	private boolean Job;
	@Enumerated(EnumType.STRING)
	private MonthlyIncome Monthlyincome;
	@Enumerated(EnumType.STRING)
	private CivilStatus CivilStatus;

	@NonNull
	private boolean Kids;
	@NonNull
	private boolean OldPerson;
	@NonNull
	private boolean OldPHealthP;
	@NonNull
	private int KidsN;
	@NonNull
	private boolean WorkCapacity;
	@NonNull
	private boolean MonoParent;
	@NonNull
	private boolean Handicap;
	@Enumerated(EnumType.STRING)
	private HandicapType HandicapType;
	@NonNull
	private boolean Pregnant;
	@NonNull
	private String Category1;
	@NonNull
	private String Category2;
	@NonNull
	private String Category3;
	
	
	
	
	
	
	
	
	
	

}
