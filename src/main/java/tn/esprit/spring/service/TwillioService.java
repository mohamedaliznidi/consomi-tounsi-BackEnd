package tn.esprit.spring.service;

public interface TwillioService {
	
	void NotifSms(String to, String from, String body);

}
