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
public class PlanningNotFoundException extends CustomException {

	@Getter
	private final Long id;
	@Getter
	private final Long msId;
	@Getter
	private final Long dsId;
	@Getter
	private final Long dcesId;
	@Getter
	private final String day;

	private static final String MESSAGE = MessageUtils.getMessage("exception.text.not.found.planning");
	
	public PlanningNotFoundException(Long id) {
		super(MESSAGE, HttpStatus.NOT_FOUND, "PLANNING_NOT_FOUND");
		this.id = id;
		this.msId = null;
		this.dsId = null;
		this.dcesId = null;
		this.day = null;
	}
	
	public PlanningNotFoundException(Long msId, Long dsId, Long dcesId, String day) {
		super(MESSAGE, HttpStatus.NOT_FOUND, "PLANNING_NOT_FOUND");
		this.msId = msId;
		this.dsId = dsId;
		this.dcesId = dcesId;
		this.day = day;
		this.id = null;
	}
	
}