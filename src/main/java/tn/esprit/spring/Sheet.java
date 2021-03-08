package tn.esprit.spring;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class Sheet {
	
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
	
	public enum MonthlyIncome {Income1,Income2,Income3,Income4,Income5}
	public enum CivilStatus {
		marié, celibataire,divorcé, veuf}
	public enum HandicapType {
		physique,intellectuel,mental}
	
	
	
	
	
	
	
	

}
