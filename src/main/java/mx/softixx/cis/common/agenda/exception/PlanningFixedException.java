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
public class PlanningFixedException extends CustomException {

	public PlanningFixedException() {
		super(MessageUtils.getMessage("exception.text.invalid.planning.fixed"),
				HttpStatus.BAD_REQUEST, "PLANNING_FIXED_INVALID");
	}
	
}