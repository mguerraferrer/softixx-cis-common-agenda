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
public class MedicalScheduleHealthcareCenterConflictException extends CustomException {

	public MedicalScheduleHealthcareCenterConflictException() {
		super(MessageUtils.getMessage("exception.text.conflict.healthcare.center"),
				HttpStatus.PRECONDITION_FAILED, "MEDICAL_SCHEDULE_HEALTHCARE_CENTER_CONFLICT");
	}

}