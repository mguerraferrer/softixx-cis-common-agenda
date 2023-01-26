package mx.softixx.cis.common.agenda.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import mx.softixx.cis.common.validation.exception.CustomException;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AppointmentCloneFrequencyException extends CustomException {

	public AppointmentCloneFrequencyException(String message) {
		super(message, HttpStatus.BAD_REQUEST, "APPOINTMENT_CLONE_FREQUENCY");
	}

}