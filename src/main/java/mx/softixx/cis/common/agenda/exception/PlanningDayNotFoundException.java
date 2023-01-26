package mx.softixx.cis.common.agenda.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import mx.softixx.cis.common.core.message.MessageUtils;
import mx.softixx.cis.common.validation.exception.CustomException;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
@EqualsAndHashCode(callSuper = false)
public class PlanningDayNotFoundException extends CustomException {

	@Getter
	private final Long id;

	public PlanningDayNotFoundException(Long id) {
		super(MessageUtils.getMessage("exception.text.not.found.planning.day"), HttpStatus.NOT_FOUND,
				"PLANNING_DAY_NOT_FOUND");
		this.id = id;
	}

}