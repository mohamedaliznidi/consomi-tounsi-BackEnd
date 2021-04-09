package tn.esprit.spring.payload;


public class JwtAuthenticationResponse {

	
    private String accessToken;
    private String tokenType = "Bearer";
	
	public JwtAuthenticationResponse( String accessToken) {
		this.setAccessToken(accessToken);
		
	}
	public String getTokenType() {
		return tokenType;
	}
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
}
