package mx.softixx.cis.common.agenda.payload;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.GroupSequence;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.softixx.cis.common.validation.annotation.Before;
import mx.softixx.cis.common.validation.annotation.ConditionalIfPresent;
import mx.softixx.cis.common.validation.annotation.FutureOrPresent;
import mx.softixx.cis.common.validation.annotation.NotNullNorEmpty;
import mx.softixx.cis.common.validation.annotation.RequiredIfPresent;
import mx.softixx.cis.common.validation.group.Group1;
import mx.softixx.cis.common.validation.group.Group2;
import mx.softixx.cis.common.validation.group.Group3;
import mx.softixx.cis.common.validation.group.OnCreate;
import mx.softixx.cis.common.validation.group.OnUpdate;
import mx.softixx.cis.common.validation.message.ValidatorMessage;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Before(from = "startTime", to = "endTime", groups = Group2.class)
@RequiredIfPresent.List({
	@RequiredIfPresent(field = "doctorSpecialityId", requiredField = "privatePracticeServiceId", groups = Group2.class),
	@RequiredIfPresent(field = "doctorClinicalEntitySpecialityId", requiredField = "doctorClinicalEntityServiceId", groups = Group2.class)
})
@ConditionalIfPresent.List({
	@ConditionalIfPresent(field = "doctorSpecialityId", conditionalField = "doctorClinicalEntityServiceId", groups = Group3.class),
	@ConditionalIfPresent(field = "doctorClinicalEntitySpecialityId", conditionalField = "privatePracticeServiceId", groups = Group3.class)
})
@GroupSequence({ AppointmentRequest.class, Group1.class, Group2.class, Group3.class })
public class AppointmentRequest {
	@Null(groups = OnUpdate.class, message = ValidatorMessage.NULLABLE)
	@NotNullNorEmpty(groups = OnCreate.class)
	private Long personId;

	private Long doctorSpecialityId;

	private Long privatePracticeServiceId;

	private Long doctorClinicalEntitySpecialityId;

	private Long doctorClinicalEntityServiceId;

	@NotNullNorEmpty(groups = OnCreate.class)
	private AppointmentType type;

	@NotNullNorEmpty(groups = OnCreate.class)
	private AppointmentOrigin origin;
	
	@Null(groups = OnCreate.class, message = ValidatorMessage.NULLABLE)
	@NotNullNorEmpty(groups = OnUpdate.class)
	private AppointmentStatus status;
	
	@NotNullNorEmpty(groups = Group1.class)
	@FutureOrPresent(groups = Group2.class)
	private LocalDate appointmentDate;

	@NotNullNorEmpty(groups = { OnCreate.class, Group1.class })
	private LocalTime startTime;

	@NotNullNorEmpty(groups = { OnCreate.class, Group1.class })
	private LocalTime endTime;

	private String anotherPersonName;
	private Long relationshipId;
	private AppointmentCancelled cancelledBy;
	private AppointmentReschedule rescheduledBy;
	private String additionalInfo;
}