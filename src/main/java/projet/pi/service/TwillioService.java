package projet.pi.service;

public interface TwillioService {
	
	void NotifSms(String to, String from, String body);

}
