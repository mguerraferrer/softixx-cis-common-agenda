package mx.softixx.cis.common.agenda.payload;

import jakarta.validation.GroupSequence;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.softixx.cis.common.validation.annotation.NotNullNorEmpty;
import mx.softixx.cis.common.validation.message.ValidatorMessage;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@GroupSequence({ PlanningFixedRequest.class })
public class PlanningFixedRequest {
	@NotNullNorEmpty(message = ValidatorMessage.REQUIRED)
	private @Valid PlanningRequest planning;
	
	@NotNullNorEmpty(message = ValidatorMessage.REQUIRED)
	private @Valid FixedRequest planningFixed;
}