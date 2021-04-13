package projet.pi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Section not found")

public class RayNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	

	public RayNotFoundException() {
		super();
	}

	public RayNotFoundException(String message) {
		super(message);
	}

}
