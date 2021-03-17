package tn.esprit.spring.entities;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity 

public class Sheet implements Serializable {
	
	
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
	 * @return the student
	 */
	public boolean isStudent() {
		return Student;
	}

	/**
	 * @param student the student to set
	 */
	public void setStudent(boolean student) {
		Student = student;
	}

	/**
	 * @return the job
	 */
	public boolean isJob() {
		return Job;
	}

	/**
	 * @param job the job to set
	 */
	public void setJob(boolean job) {
		Job = job;
	}

	/**
	 * @return the monthlyincome
	 */
	public MonthlyIncome getMonthlyincome() {
		return Monthlyincome;
	}

	/**
	 * @param monthlyincome the monthlyincome to set
	 */
	public void setMonthlyincome(MonthlyIncome monthlyincome) {
		Monthlyincome = monthlyincome;
	}

	/**
	 * @return the civilStatus
	 */
	public CivilStatus getCivilStatus() {
		return CivilStatus;
	}

	/**
	 * @param civilStatus the civilStatus to set
	 */
	public void setCivilStatus(CivilStatus civilStatus) {
		CivilStatus = civilStatus;
	}

	/**
	 * @return the kids
	 */
	public boolean isKids() {
		return Kids;
	}

	/**
	 * @param kids the kids to set
	 */
	public void setKids(boolean kids) {
		Kids = kids;
	}

	/**
	 * @return the oldPerson
	 */
	public boolean isOldPerson() {
		return OldPerson;
	}

	/**
	 * @param oldPerson the oldPerson to set
	 */
	public void setOldPerson(boolean oldPerson) {
		OldPerson = oldPerson;
	}

	/**
	 * @return the oldPHealthP
	 */
	public boolean isOldPHealthP() {
		return OldPHealthP;
	}

	/**
	 * @param oldPHealthP the oldPHealthP to set
	 */
	public void setOldPHealthP(boolean oldPHealthP) {
		OldPHealthP = oldPHealthP;
	}

	/**
	 * @return the kidsN
	 */
	public int getKidsN() {
		return KidsN;
	}

	/**
	 * @param kidsN the kidsN to set
	 */
	public void setKidsN(int kidsN) {
		KidsN = kidsN;
	}

	/**
	 * @return the workCapacity
	 */
	public boolean isWorkCapacity() {
		return WorkCapacity;
	}

	/**
	 * @param workCapacity the workCapacity to set
	 */
	public void setWorkCapacity(boolean workCapacity) {
		WorkCapacity = workCapacity;
	}

	/**
	 * @return the monoParent
	 */
	public boolean isMonoParent() {
		return MonoParent;
	}

	/**
	 * @param monoParent the monoParent to set
	 */
	public void setMonoParent(boolean monoParent) {
		MonoParent = monoParent;
	}

	/**
	 * @return the handicap
	 */
	public boolean isHandicap() {
		return Handicap;
	}

	/**
	 * @param handicap the handicap to set
	 */
	public void setHandicap(boolean handicap) {
		Handicap = handicap;
	}

	/**
	 * @return the handicapType
	 */
	public HandicapType getHandicapType() {
		return HandicapType;
	}

	/**
	 * @param handicapType the handicapType to set
	 */
	public void setHandicapType(HandicapType handicapType) {
		HandicapType = handicapType;
	}

	/**
	 * @return the pregnant
	 */
	public boolean isPregnant() {
		return Pregnant;
	}

	/**
	 * @param pregnant the pregnant to set
	 */
	public void setPregnant(boolean pregnant) {
		Pregnant = pregnant;
	}

	/**
	 * @return the category1
	 */
	public String getCategory1() {
		return Category1;
	}

	/**
	 * @param category1 the category1 to set
	 */
	public void setCategory1(String category1) {
		Category1 = category1;
	}

	/**
	 * @return the category2
	 */
	public String getCategory2() {
		return Category2;
	}

	/**
	 * @param category2 the category2 to set
	 */
	public void setCategory2(String category2) {
		Category2 = category2;
	}

	/**
	 * @return the category3
	 */
	public String getCategory3() {
		return Category3;
	}

	/**
	 * @param category3 the category3 to set
	 */
	public void setCategory3(String category3) {
		Category3 = category3;
	}
	
	
	
	
	
	
	
	
	
	

}
