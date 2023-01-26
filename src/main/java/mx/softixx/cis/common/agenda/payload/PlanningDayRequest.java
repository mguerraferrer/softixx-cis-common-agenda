package mx.softixx.cis.common.agenda.payload;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.GroupSequence;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mx.softixx.cis.common.validation.annotation.NotNullNorEmpty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@GroupSequence({ PlanningDayRequest.class })
public class PlanningDayRequest {
	@NotNullNorEmpty
	private @Valid PlanningRequest planning;
	
	@Getter(AccessLevel.NONE)
	@NotNullNorEmpty
	private List<@Valid DayRequest> planningDays;

	public List<DayRequest> getPlanningDays() {
		if (planningDays == null) {
			return new ArrayList<>();
		}
		return planningDays;
	}
	
}