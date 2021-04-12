package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class CodeP implements Serializable {
	
	
	public CodeP() {
		super();
	}

	/**
	 * @param codeP
	 * @param gouvernorat
	 * @param delegation
	 * @param localite
	 */
	public CodeP(int codeP, String gouvernorat, String delegation, String localite) {
		this.codep = codeP;
		this.gouvernorat = gouvernorat;
		this.delegation = delegation;
		this.localite = localite;
	}

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="CodeP")
	private int codep;
	
	private String gouvernorat;
	
	private String delegation;
	
	private String localite;
	
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="codep")
	private Set<Adress> adress;

	/**
	 * @return the codeP
	 */
	public int getCodeP() {
		return codep;
	}

	/**
	 * @param codeP the codeP to set
	 */
	public void setCodeP(int codeP) {
		this.codep = codeP;
	}

	/**
	 * @return the gouvernorat
	 */
	public String getGouvernorat() {
		return gouvernorat;
	}

	/**
	 * @param gouvernorat the gouvernorat to set
	 */
	public void setGouvernorat(String gouvernorat) {
		this.gouvernorat = gouvernorat;
	}

	/**
	 * @return the delegation
	 */
	public String getDelegation() {
		return delegation;
	}

	/**
	 * @param delegation the delegation to set
	 */
	public void setDelegation(String delegation) {
		this.delegation = delegation;
	}

	/**
	 * @return the localite
	 */
	public String getLocalite() {
		return localite;
	}

	/**
	 * @param localite the localite to set
	 */
	public void setLocalite(String localite) {
		this.localite = localite;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
