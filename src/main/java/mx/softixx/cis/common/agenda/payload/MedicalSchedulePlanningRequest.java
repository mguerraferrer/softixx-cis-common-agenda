package mx.softixx.cis.common.agenda.payload;

import jakarta.validation.GroupSequence;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import mx.softixx.cis.common.validation.annotation.NotNullNorEmpty;
import mx.softixx.cis.common.validation.group.Group1;
import mx.softixx.cis.common.validation.group.Group2;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@GroupSequence({ MedicalSchedulePlanningRequest.class, Group1.class, Group2.class })
public class MedicalSchedulePlanningRequest {
	@NotNullNorEmpty(groups = Group1.class)
	private @Valid MedicalScheduleRequest medicalSchedule;
	
	@NotNullNorEmpty(groups = Group1.class)
	private @Valid PlanningRequest planning;
}