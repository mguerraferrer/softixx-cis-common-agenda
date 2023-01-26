package mx.softixx.cis.common.agenda.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.EqualsAndHashCode;
import mx.softixx.cis.common.core.message.MessageUtils;
import mx.softixx.cis.common.validation.exception.CustomException;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.BAD_REQUEST)
@EqualsAndHashCode(callSuper = false)
public class NonWorkingDayOutOfRangeException extends CustomException {

	public NonWorkingDayOutOfRangeException() {
		super(MessageUtils.getMessage("exception.text.out.of.range.working.day"), HttpStatus.BAD_REQUEST,
				"NO_WORKING_DAY_OUT_OF_RANGE");
	}

}