package tn.esprit.spring.entities;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;



@Entity 

public class Sheet implements Serializable {
	
	
	//add requested_donation de type donation_type et response (binary)
	
	/**
	 * @param id
	 * @param student
	 * @param job
	 * @param monthlyincome
	 * @param civilStatus
	 * @param kids
	 * @param oldPerson
	 * @param oldPHealthP
	 * @param kidsN
	 * @param workCapacity
	 * @param monoParent
	 * @param handicap
	 * @param handicapType
	 * @param pregnant
	 * @param category1
	 * @param category2
	 * @param category3
	 */
	public Sheet(int id, boolean student, boolean job, MonthlyIncome monthlyincome,
			tn.esprit.spring.entities.CivilStatus civilStatus, boolean kids, boolean oldPerson, boolean oldPHealthP,
			int kidsN, boolean workCapacity, boolean monoParent, boolean handicap,
			tn.esprit.spring.entities.HandicapType handicapType, boolean pregnant, String category1, String category2,
			String category3) {
		this.id = id;
		Student = student;
		Job = job;
		Monthlyincome = monthlyincome;
		CivilStatus = civilStatus;
		Kids = kids;
		OldPerson = oldPerson;
		OldPHealthP = oldPHealthP;
		KidsN = kidsN;
		WorkCapacity = workCapacity;
		MonoParent = monoParent;
		Handicap = handicap;
		HandicapType = handicapType;
		Pregnant = pregnant;
		Category1 = category1;
		Category2 = category2;
		Category3 = category3;
	}

	public ClientPlus getClientplus() {
		return clientplus;
	}


	public void setClientplus(ClientPlus clientplus) {
		this.clientplus = clientplus;
	}

	
	@OneToOne
	private ClientPlus clientplus;
	
	@ManyToOne( cascade = CascadeType.ALL)
	Donation donation;
	
	public Donation getDonation() {
		return donation;
	}

	public void setDonation(Donation donation) {
		this.donation = donation;
	}

	public Sheet(ClientPlus clientplus, Donation donation, int id, boolean student, boolean job,
			MonthlyIncome monthlyincome, tn.esprit.spring.entities.CivilStatus civilStatus, boolean kids,
			boolean oldPerson, boolean oldPHealthP, int kidsN, boolean workCapacity, boolean monoParent,
			boolean handicap, tn.esprit.spring.entities.HandicapType handicapType, boolean pregnant, String category1,
			String category2, String category3) {
		super();
		this.clientplus = clientplus;
		this.donation = donation;
		this.id = id;
		Student = student;
		Job = job;
		Monthlyincome = monthlyincome;
		CivilStatus = civilStatus;
		Kids = kids;
		OldPerson = oldPerson;
		OldPHealthP = oldPHealthP;
		KidsN = kidsN;
		WorkCapacity = workCapacity;
		MonoParent = monoParent;
		Handicap = handicap;
		HandicapType = handicapType;
		Pregnant = pregnant;
		Category1 = category1;
		Category2 = category2;
		Category3 = category3;
	}


	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="SHEET_ID")
	private int id ;
	
	private boolean Student;

	
	private boolean Job;
	@Enumerated(EnumType.STRING)
	private MonthlyIncome Monthlyincome;
	@Enumerated(EnumType.STRING)
	private CivilStatus CivilStatus;


	private boolean Kids;
	
	private boolean OldPerson;
	
	private boolean OldPHealthP;
	
	private int KidsN;
	
	private boolean WorkCapacity;

	private boolean MonoParent;

	private boolean Handicap;
	@Enumerated(EnumType.STRING)
	private HandicapType HandicapType;
	
	private boolean Pregnant;
	
	private String Category1;
	
	private String Category2;
	
	private String Category3;
	
	
	
	
	
	
	//Getters&Setters
	
	public int getId() {
		return id;
	}

	
	public void setId(int id) {
		this.id = id;
	}

	
	public boolean isStudent() {
		return Student;
	}

	
	public void setStudent(boolean student) {
		Student = student;
	}


	public boolean isJob() {
		return Job;
	}

	
	
	public void setJob(boolean job) {
		Job = job;
	}



	public MonthlyIncome getMonthlyincome() {
		return Monthlyincome;
	}



	public void setMonthlyincome(MonthlyIncome monthlyincome) {
		Monthlyincome = monthlyincome;
	}



	public CivilStatus getCivilStatus() {
		return CivilStatus;
	}



	public void setCivilStatus(CivilStatus civilStatus) {
		CivilStatus = civilStatus;
	}



	public boolean isKids() {
		return Kids;
	}


	public void setKids(boolean kids) {
		Kids = kids;
	}



	public boolean isOldPerson() {
		return OldPerson;
	}



	public void setOldPerson(boolean oldPerson) {
		OldPerson = oldPerson;
	}



	public boolean isOldPHealthP() {
		return OldPHealthP;
	}



	public void setOldPHealthP(boolean oldPHealthP) {
		OldPHealthP = oldPHealthP;
	}



	public int getKidsN() {
		return KidsN;
	}



	public void setKidsN(int kidsN) {
		KidsN = kidsN;
	}



	public boolean isWorkCapacity() {
		return WorkCapacity;
	}



	public void setWorkCapacity(boolean workCapacity) {
		WorkCapacity = workCapacity;
	}



	public boolean isMonoParent() {
		return MonoParent;
	}



	public void setMonoParent(boolean monoParent) {
		MonoParent = monoParent;
	}



	public boolean isHandicap() {
		return Handicap;
	}



	public void setHandicap(boolean handicap) {
		Handicap = handicap;
	}



	public HandicapType getHandicapType() {
		return HandicapType;
	}



	public void setHandicapType(HandicapType handicapType) {
		HandicapType = handicapType;
	}



	public boolean isPregnant() {
		return Pregnant;
	}



	public void setPregnant(boolean pregnant) {
		Pregnant = pregnant;
	}



	public String getCategory1() {
		return Category1;
	}


	public void setCategory1(String category1) {
		Category1 = category1;
	}



	public String getCategory2() {
		return Category2;
	}



	public void setCategory2(String category2) {
		Category2 = category2;
	}

	
	public String getCategory3() {
		return Category3;
	}



	public void setCategory3(String category3) {
		Category3 = category3;
	}
	
	
	
	
	
	
	
	
	
	

}
