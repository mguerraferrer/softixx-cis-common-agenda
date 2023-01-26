package mx.softixx.cis.common.agenda.payload;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonInclude(Include.NON_NULL)
public class MedicalScheduleResponse extends MedicalScheduleRequest {
	private Long id;
	private boolean active;
	@Getter(AccessLevel.NONE)
	private List<PlanningResponse> plannings;
	
	public List<PlanningResponse> getPlannings() {
		if (plannings == null) {
			plannings = new ArrayList<>();
		}
		return plannings;
	}
	
}