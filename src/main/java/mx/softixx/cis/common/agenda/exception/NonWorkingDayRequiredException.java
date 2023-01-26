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
public class NonWorkingDayRequiredException extends CustomException {

	public NonWorkingDayRequiredException() {
		super(MessageUtils.getMessage("exception.text.required.non.working.day"), HttpStatus.BAD_REQUEST,
				"NON_WORKING_DAY_REQUIRED");
	}

}