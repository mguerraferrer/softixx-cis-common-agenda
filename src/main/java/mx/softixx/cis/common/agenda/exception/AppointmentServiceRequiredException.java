package mx.softixx.cis.common.agenda.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;
import mx.softixx.cis.common.core.message.MessageUtils;
import mx.softixx.cis.common.validation.exception.CustomException;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.BAD_REQUEST)
@Data
@EqualsAndHashCode(callSuper = false)
public class AppointmentServiceRequiredException extends CustomException {

	public AppointmentServiceRequiredException() {
		super(MessageUtils.getMessage("exception.text.required.appointment.service"), HttpStatus.BAD_REQUEST,
				"APPOINTMENT_SPECIALITY_REQUIRED");
	}

}