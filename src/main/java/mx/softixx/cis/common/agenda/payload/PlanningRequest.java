package mx.softixx.cis.common.agenda.payload;

import jakarta.validation.GroupSequence;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import mx.softixx.cis.common.validation.annotation.NotNullNorEmpty;
import mx.softixx.cis.common.validation.group.OnCreate;
import mx.softixx.cis.common.validation.group.OnUpdate;
import mx.softixx.cis.common.validation.message.ValidatorMessage;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@GroupSequence({ PlanningRequest.class })
public class PlanningRequest {
	@Null(groups = OnUpdate.class, message = ValidatorMessage.NULLABLE)
	private Long doctorSpecialityId;
	
	@Null(groups = OnUpdate.class, message = ValidatorMessage.NULLABLE)
	private Long doctorClinicalEntitySpecialityId;
	
	@NotNullNorEmpty(groups = OnCreate.class)
	private AgendaVisualization agendaVisualization;
	
	@NotNullNorEmpty
	private boolean fixedSchedule;
	
	@NotNullNorEmpty(groups = OnCreate.class)
	private Integer appointmentDuration;
}