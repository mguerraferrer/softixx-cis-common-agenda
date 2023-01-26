package mx.softixx.cis.common.agenda.payload;

import jakarta.validation.GroupSequence;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import mx.softixx.cis.common.validation.annotation.NotNullNorEmpty;
import mx.softixx.cis.common.validation.group.Group1;
import mx.softixx.cis.common.validation.group.Group2;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@GroupSequence({ MedicalSchedulePlanningFixedRequest.class, Group1.class, Group2.class })
public class MedicalSchedulePlanningFixedRequest extends MedicalSchedulePlanningRequest {
	@NotNullNorEmpty(groups = Group1.class)
	private @Valid FixedRequest planningFixed;
}