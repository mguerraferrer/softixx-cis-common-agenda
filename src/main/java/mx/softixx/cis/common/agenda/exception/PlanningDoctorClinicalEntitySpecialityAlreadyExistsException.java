package mx.softixx.cis.common.agenda.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import mx.softixx.cis.common.core.message.MessageUtils;
import mx.softixx.cis.common.validation.exception.CustomException;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
public class PlanningDoctorClinicalEntitySpecialityAlreadyExistsException extends CustomException {

	public PlanningDoctorClinicalEntitySpecialityAlreadyExistsException() {
		super(MessageUtils.getMessage("exception.text.already.exists.planning.doctor.clinical.entity.speciality"),
				HttpStatus.PRECONDITION_FAILED, "PLANNING_DOCTOR_CLINICAL_ENTITY_SPECIALITY_ALREADY_EXISTS");
	}

}