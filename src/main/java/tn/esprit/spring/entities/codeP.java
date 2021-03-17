package tn.esprit.spring.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class codeP {
	@Id
	@NonNull
	@Column(name="CodeP")
	private int codeP;
	@NonNull
	private String gouvernorat;
	@NonNull
	private String delegation;
	@NonNull
	private String localite;

}
