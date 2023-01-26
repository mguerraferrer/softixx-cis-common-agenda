package mx.softixx.cis.common.agenda.exception;

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
public class MedicalScheduleAlreadyExistsException extends CustomException {

	@Getter
	private final Long doctorId;
	@Getter
	private final Long privatePracticeId;
	@Getter
	private final Long clinicalEntityId;

	public MedicalScheduleAlreadyExistsException(Long doctorId, Long privatePracticeId, Long clinicalEntityId) {
		super(MessageUtils.getMessage("exception.text.already.exists.medical.schedule"), HttpStatus.PRECONDITION_FAILED,
				"MEDICAL_SCHEDULE_ALREADY_EXISTS");
		this.doctorId = doctorId;
		this.privatePracticeId = privatePracticeId;
		this.clinicalEntityId = clinicalEntityId;
	}

}