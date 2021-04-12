package tn.esprit.spring.payload;



import javax.validation.constraints.NotBlank;
import java.io.Serializable;


public class FacebookLoginRequest implements Serializable {

    
	private static final long serialVersionUID = 1L;
	@NotBlank
    private String accessToken;

	
	public String getAccessToken() {
		return accessToken;
	}

	
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}


	public FacebookLoginRequest(@NotBlank String accessToken) {
		this.accessToken = accessToken;
	}


	public FacebookLoginRequest() {
	}

	
}
