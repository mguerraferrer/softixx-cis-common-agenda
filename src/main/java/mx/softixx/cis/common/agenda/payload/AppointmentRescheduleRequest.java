package mx.softixx.cis.common.agenda.payload;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.GroupSequence;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.softixx.cis.common.validation.annotation.Before;
import mx.softixx.cis.common.validation.annotation.ConditionalIfPresent;
import mx.softixx.cis.common.validation.annotation.FutureOrPresent;
import mx.softixx.cis.common.validation.annotation.NotNullNorEmpty;
import mx.softixx.cis.common.validation.annotation.Required;
import mx.softixx.cis.common.validation.group.Group1;
import mx.softixx.cis.common.validation.group.Group2;
import mx.softixx.cis.common.validation.group.Group3;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Required(fieldOne = "doctorSpecialityId", fieldTwo = "doctorClinicalEntitySpecialityId", groups = Group1.class)
@ConditionalIfPresent.List({
	@ConditionalIfPresent(field = "doctorSpecialityId", conditionalField = "doctorClinicalEntityServiceId", groups = Group3.class),
	@ConditionalIfPresent(field = "doctorClinicalEntitySpecialityId", conditionalField = "privatePracticeServiceId", groups = Group3.class)
})
@Before(from = "startTime", to = "endTime", groups = Group2.class)
@GroupSequence({ AppointmentRescheduleRequest.class, Group1.class, Group2.class, Group3.class })
public class AppointmentRescheduleRequest {
	private Long doctorSpecialityId;

	private Long privatePracticeServiceId;

	private Long doctorClinicalEntitySpecialityId;

	private Long doctorClinicalEntityServiceId;
	
	@NotNullNorEmpty(groups = Group1.class)
	private AppointmentReschedule rescheduledBy;
	
	@NotNullNorEmpty(groups = Group1.class)
	@FutureOrPresent(groups = Group2.class)
	private LocalDate appointmentDate;

	@NotNullNorEmpty(groups = Group1.class)
	private LocalTime startTime;

	@NotNullNorEmpty(groups = Group1.class)
	private LocalTime endTime;
}