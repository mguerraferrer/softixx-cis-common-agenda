package mx.softixx.cis.common.agenda.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;
import mx.softixx.cis.common.core.message.MessageUtils;
import mx.softixx.cis.common.validation.exception.CustomException;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
@Data
@EqualsAndHashCode(callSuper = false)
public class MedicalScheduleHealthcareCenterRequiredException extends CustomException {

	public MedicalScheduleHealthcareCenterRequiredException() {
		super(MessageUtils.getMessage("exception.text.required.healthcare.center"), HttpStatus.PRECONDITION_FAILED,
				"MEDICAL_SCHEDULE_HEALTHCARE_CENTER_REQUIRED");
	}

}