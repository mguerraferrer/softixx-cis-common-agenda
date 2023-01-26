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
public class PlanningClinicalEntityRequiredException extends CustomException {

	public PlanningClinicalEntityRequiredException() {
		super(MessageUtils.getMessage("exception.text.required.clinical.entity"), HttpStatus.PRECONDITION_FAILED,
				"PLANNING_CLINICAL_ENTITY_REQUIRED");
	}

}