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
public class AppointmentNotFoundException extends CustomException {

	@Getter
	private final Long id;
	@Getter
	private final String folio;
	@Getter
	private final Long dsId;
	@Getter
	private final Long dcesId;
	@Getter
	private final Long personId;
	@Getter
	private final LocalDate date;

	private static final String ERROR_MESSAGE = "exception.text.not.found.appointment";
	private static final String ERROR_CODE = "APPOINTMENT_NOT_FOUND";

	public AppointmentNotFoundException(Long id) {
		super(MessageUtils.getMessage(ERROR_MESSAGE), HttpStatus.NOT_FOUND, ERROR_CODE);
		this.id = id;
		this.folio = null;
		this.dsId = null;
		this.dcesId = null;
		this.personId = null;
		this.date = null;
	}

	public AppointmentNotFoundException(String folio) {
		super(MessageUtils.getMessage(ERROR_MESSAGE), HttpStatus.NOT_FOUND, ERROR_CODE);
		this.folio = folio;
		this.id = null;
		this.dsId = null;
		this.dcesId = null;
		this.personId = null;
		this.date = null;
	}

	public AppointmentNotFoundException(Long dsId, Long dcesId, Long personId, LocalDate date) {
		super(MessageUtils.getMessage(ERROR_MESSAGE), HttpStatus.NOT_FOUND, ERROR_CODE);
		this.id = null;
		this.folio = null;
		this.dsId = dsId;
		this.dcesId = dcesId;
		this.personId = personId;
		this.date = date;
	}

}