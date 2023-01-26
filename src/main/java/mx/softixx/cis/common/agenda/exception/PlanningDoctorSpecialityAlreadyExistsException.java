package mx.softixx.cis.common.agenda.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import mx.softixx.cis.common.core.message.MessageUtils;
import mx.softixx.cis.common.validation.exception.CustomException;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
public class PlanningDoctorSpecialityAlreadyExistsException extends CustomException {

	public PlanningDoctorSpecialityAlreadyExistsException() {
		super(MessageUtils.getMessage("exception.text.already.exists.planning.doctor.speciality"),
				HttpStatus.PRECONDITION_FAILED, "PLANNING_DOCTOR_SPECIALITY_ALREADY_EXISTS");
	}

}