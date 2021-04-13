/*package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.com.entity.Delivery;
import tn.esprit.com.entity.Deliveryman;
import tn.esprit.com.repositry.Deliverymanrepositry;
import tn.esprit.com.repositry.Deliveryrepositry;

@Service
@Transactional
public class Prime implements Primes{
@Autowired
Deliverymanrepositry dev ; 

private JavaMailSender javaMailSender;
@Autowired
public Prime(JavaMailSender javaMailSender) {
this.javaMailSender = javaMailSender;
}

@Scheduled(fixedDelay=1000*60)

public void primeLiv() throws MailException{
	System.out.println("ioo iifhrfuih");
	SimpleMailMessage mail = new SimpleMailMessage();

	mail.setTo("yasmine.njim@esprit.tn");
	mail.setSubject("Prime");
	mail.setText("La communauté Consommi Tounsi vous remercie pour vos efforts et vous offre une prime de 100DT");
List <Deliveryman> liv= dev.findAll();


for(Deliveryman del : liv){
	System.out.println(del.getSalary());
	System.out.println(del.getEmail());
	System.out.println(del.getRank());
if(del.getRank()>73){
	del.setDelivery_id(del.getDelivery_id());
	del.incrementSalary();
	
del.setSalary(del.getSalary());
dev.save(del);


mail.setTo(del.getEmail());
mail.setSubject("Prime");
mail.setText("La communauté Consommi Tounsi vous remercie pour vos efforts et vous offre une prime de 100DT");

/*
* This send() contains an Object of SimpleMailMessage as an Parameter
*/
//javaMailSender.send(mail);
//}}}}







	/**public float primeslivreur(float  chargedetravail, Long id_de) {
		// TODO Auto-generated method stub
		
		float prime=0;
		for( Deliveryman d : dev.findAll() ) {
			float montantmax=d.getSalary() ;
			
			float note; 
			{
			note = chargedetravail*20/1680;
			if(note>=10)
			prime =0 ;
			else 
			 prime= note*montantmax/20 ;}
			 }
		
		return prime ;

	
	}**/
	


