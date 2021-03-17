package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;



@Entity

public class codeP implements Serializable {
	
	
	/**
	 * @param codeP
	 * @param gouvernorat
	 * @param delegation
	 * @param localite
	 */
	public codeP(int codeP, String gouvernorat, String delegation, String localite) {
		this.codeP = codeP;
		this.gouvernorat = gouvernorat;
		this.delegation = delegation;
		this.localite = localite;
	}

	private static final long serialVersionUID = 1L;
	
	@Id
	
	@Column(name="CodeP")
	private int codeP;
	
	private String gouvernorat;
	
	private String delegation;
	
	private String localite;

	/**
	 * @return the codeP
	 */
	public int getCodeP() {
		return codeP;
	}

	/**
	 * @param codeP the codeP to set
	 */
	public void setCodeP(int codeP) {
		this.codeP = codeP;
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
