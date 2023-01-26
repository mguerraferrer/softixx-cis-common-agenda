package mx.softixx.cis.common.agenda.exception;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import mx.softixx.cis.common.core.message.MessageUtils;
import mx.softixx.cis.common.validation.exception.CustomException;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
@Data
@EqualsAndHashCode(callSuper = false)
public class AppointmentAlreadyExistsException extends CustomException {

	@Getter
	private final Long doctorSpecialityId;
	@Getter
	private final Long privatePracticeServiceId;
	@Getter
	private final Long doctorClinicalEntitySpecialityId;
	@Getter
	private final Long doctorClinicalEntityServiceId;
	@Getter
	private final Long personId;
	@Getter
	private final LocalDate date;
	@Getter
	private final LocalTime startTime;

	public AppointmentAlreadyExistsException(Long doctorSpecialityId, Long privatePracticeServiceId,
			Long doctorClinicalEntitySpecialityId, Long doctorClinicalEntityServiceId, Long personId,
			LocalDate localDate) {
		super(MessageUtils.getMessage("exception.text.already.exists.appointment"), HttpStatus.PRECONDITION_FAILED,
				"APPOINTMENT_ALREADY_EXISTS");
		this.doctorSpecialityId = doctorSpecialityId;
		this.privatePracticeServiceId = privatePracticeServiceId;
		this.doctorClinicalEntitySpecialityId = doctorClinicalEntitySpecialityId;
		this.doctorClinicalEntityServiceId = doctorClinicalEntityServiceId;
		this.personId = personId;
		this.date = localDate;
		this.startTime = null;
	}

	public AppointmentAlreadyExistsException(Long doctorSpecialityId, Long privatePracticeServiceId,
			Long doctorClinicalEntitySpecialityId, Long doctorClinicalEntityServiceId, LocalDate localDate,
			LocalTime localTime) {
		super(MessageUtils.getMessage("exception.text.already.exists.appointment"), HttpStatus.PRECONDITION_FAILED,
				"APPOINTMENT_ALREADY_EXISTS");
		this.doctorSpecialityId = doctorSpecialityId;
		this.privatePracticeServiceId = privatePracticeServiceId;
		this.doctorClinicalEntitySpecialityId = doctorClinicalEntitySpecialityId;
		this.doctorClinicalEntityServiceId = doctorClinicalEntityServiceId;
		this.date = localDate;
		this.startTime = localTime;
		this.personId = null;
	}

}