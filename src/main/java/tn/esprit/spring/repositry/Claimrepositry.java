package  tn.esprit.spring.repositry;

import java.util.List;
import tn.esprit.spring.entities.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface Claimrepositry extends JpaRepository<Claim, Long> {
	
	@Query("SELECT a FROM Claim a WHERE subject_claim = ?1")
	public List<Claim> getPubliityBypublictyname(@Param("subject_claim") String subject_claim);
	
	@Query("SELECT a FROM Claim a WHERE idclaim= ?1")
	public Claim  getClaimById(@Param("idclaim") Long idclaim );

}
