package mx.softixx.cis.common.agenda.payload;

import java.time.LocalDate;

import jakarta.validation.GroupSequence;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import mx.softixx.cis.common.validation.annotation.ConditionalIfPresent;
import mx.softixx.cis.common.validation.annotation.FutureOrPresent;
import mx.softixx.cis.common.validation.annotation.NotNullNorEmpty;
import mx.softixx.cis.common.validation.annotation.Required;
import mx.softixx.cis.common.validation.group.Group1;
import mx.softixx.cis.common.validation.group.Group2;
import mx.softixx.cis.common.validation.group.OnCreate;
import mx.softixx.cis.common.validation.group.OnUpdate;
import mx.softixx.cis.common.validation.message.ValidatorMessage;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Required(fieldOne = "privatePracticeId", fieldTwo = "clinicalEntityId", groups = OnCreate.class)
@ConditionalIfPresent(field = "privatePracticeId", conditionalField = "clinicalEntityId", groups = OnCreate.class)
@GroupSequence({MedicalScheduleRequest.class, Group1.class, Group2.class})
public class MedicalScheduleRequest {
	@Null(groups = OnUpdate.class, message = ValidatorMessage.NULLABLE)
	@NotNullNorEmpty(groups = OnCreate.class)
	private Long doctorId;
	
	@Null(groups = OnUpdate.class, message = ValidatorMessage.NULLABLE)
	private Long privatePracticeId;

	@Null(groups = OnUpdate.class, message = ValidatorMessage.NULLABLE)
	private Long clinicalEntityId;

	@NotNullNorEmpty(groups = Group1.class)
	@FutureOrPresent(groups = Group2.class)
	private LocalDate endDate;
}