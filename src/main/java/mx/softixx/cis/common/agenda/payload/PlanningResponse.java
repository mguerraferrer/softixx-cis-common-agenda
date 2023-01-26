package mx.softixx.cis.common.agenda.payload;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class PlanningResponse {
	private Long id;
	private Long medicalScheduleId;
	private Long doctorSpecialityId;
	private Long doctorClinicalEntitySpecialityId;
	private AgendaVisualization agendaVisualization;
	private Integer appointmentDuration;
	private boolean fixedSchedule;
	private FixedResponse planningFixed;
	@Getter(AccessLevel.NONE)
	@JsonInclude(Include.NON_EMPTY)
	private List<DayResponse> planningDays;

	public List<DayResponse> getPlanningDays() {
		if (planningDays == null) {
			planningDays = new ArrayList<>();
		}
		return planningDays;
	}
}