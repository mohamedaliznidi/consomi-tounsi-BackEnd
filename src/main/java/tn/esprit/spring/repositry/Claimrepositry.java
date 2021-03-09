package tn.esprit.spring.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entities.*;


public interface Claimrepositry extends JpaRepository<Claim, Long> {
	
	@Query("SELECT a FROM Claim a WHERE subject_claim = ?1")
	public List<Claim> getPubliityBypublictyname(@Param("subject_claim") String subject_claim);
	
	@Query("SELECT a FROM Claim a WHERE idclaim= ?1")
	public Claim  getClaimById(@Param("idclaim") Long idclaim );

}
