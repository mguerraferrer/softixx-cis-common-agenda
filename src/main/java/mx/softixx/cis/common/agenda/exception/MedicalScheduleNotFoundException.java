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
public class MedicalScheduleNotFoundException extends CustomException {

	@Getter
	private final Long id;
	@Getter
	private final Long doctorId;
	@Getter
	private final Long privatePracticeId;
	@Getter
	private final Long clinicalEntityId;

	public MedicalScheduleNotFoundException(Long id) {
		super(MessageUtils.getMessage("exception.text.not.found.medical.schedule"), HttpStatus.NOT_FOUND,
				"MEDICAL_SCHEDULE_NOT_FOUND");
		this.id = id;
		this.doctorId = null;
		this.privatePracticeId = null;
		this.clinicalEntityId = null;
	}

	public MedicalScheduleNotFoundException(Long doctorId, Long privatePracticeId, Long clinicalEntityId) {
		super(MessageUtils.getMessage("exception.text.not.found.medical.schedule"), HttpStatus.NOT_FOUND,
				"MEDICAL_SCHEDULE_NOT_FOUND");
		this.doctorId = doctorId;
		this.privatePracticeId = privatePracticeId;
		this.clinicalEntityId = clinicalEntityId;
		this.id = null;
	}

}