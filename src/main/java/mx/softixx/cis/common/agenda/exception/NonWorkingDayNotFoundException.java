package mx.softixx.cis.common.agenda.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import mx.softixx.cis.common.core.message.MessageUtils;
import mx.softixx.cis.common.validation.exception.CustomException;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
@EqualsAndHashCode(callSuper = false)
public class NonWorkingDayNotFoundException extends CustomException {

	@Getter
	private final Long id;
	@Getter
	private final LocalDate nwd;

	public NonWorkingDayNotFoundException(Long id) {
		super(MessageUtils.getMessage("exception.text.not.found.non.working.day"), HttpStatus.NOT_FOUND,
				"NO_WORKING_DAY_NOT_FOUND");
		this.id = id;
		this.nwd = null;
	}
	
	public NonWorkingDayNotFoundException(LocalDate nwd) {
		super(MessageUtils.getMessage("exception.text.not.found.non.working.day"), HttpStatus.NOT_FOUND,
				"NO_WORKING_DAY_NOT_FOUND");
		this.nwd = nwd;
		this.id = null;
	}

}