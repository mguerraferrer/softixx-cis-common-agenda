package mx.softixx.cis.common.agenda.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import mx.softixx.cis.common.core.message.MessageUtils;
import mx.softixx.cis.common.validation.exception.CustomException;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AppointmentServiceConflictException extends CustomException {

	public AppointmentServiceConflictException() {
		super(MessageUtils.getMessage("exception.text.conflict.appointment.service"),
				HttpStatus.BAD_REQUEST, "APPOINTMENT_SPECIALITY_CONFLICT");
	}

}