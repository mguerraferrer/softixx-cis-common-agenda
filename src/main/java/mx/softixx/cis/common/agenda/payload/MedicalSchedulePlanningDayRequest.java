package mx.softixx.cis.common.agenda.payload;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.GroupSequence;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import mx.softixx.cis.common.validation.annotation.NotNullNorEmpty;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@GroupSequence({ MedicalSchedulePlanningDayRequest.class })
public class MedicalSchedulePlanningDayRequest extends MedicalSchedulePlanningRequest {
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