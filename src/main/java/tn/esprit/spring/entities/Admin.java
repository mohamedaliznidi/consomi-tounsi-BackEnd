package tn.esprit.spring.entities;


import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name="ADMIN")
public class Admin extends User {
	
}