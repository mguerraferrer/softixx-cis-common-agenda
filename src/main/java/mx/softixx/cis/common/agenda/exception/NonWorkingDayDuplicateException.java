package mx.softixx.cis.common.agenda.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.EqualsAndHashCode;
import mx.softixx.cis.common.core.message.MessageUtils;
import mx.softixx.cis.common.validation.exception.CustomException;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.BAD_REQUEST)
@EqualsAndHashCode(callSuper = false)
public class NonWorkingDayDuplicateException extends CustomException {

	public NonWorkingDayDuplicateException() {
		super(MessageUtils.getMessage("exception.text.duplicate.working.day"), HttpStatus.BAD_REQUEST,
				"NO_WORKING_DAY_DUPLICATE");
	}

}