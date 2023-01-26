package mx.softixx.cis.common.agenda.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import mx.softixx.cis.common.core.message.MessageUtils;
import mx.softixx.cis.common.validation.exception.CustomException;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AppointmentSpecialityRequiredException extends CustomException {

	public AppointmentSpecialityRequiredException() {
		super(MessageUtils.getMessage("exception.text.required.appointment.speciality"), HttpStatus.BAD_REQUEST,
				"APPOINTMENT_SPECIALITY_REQUIRED");
	}

}