package mx.softixx.cis.common.agenda.payload;

import java.time.LocalDate;
import java.time.LocalTime;
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
public class AppointmentCloneResponse {
	private Long personId;
	private Long doctorSpecialityId;
	private Long privatePracticeServiceId;
	private Long doctorClinicalEntitySpecialityId;
	private Long doctorClinicalEntityServiceId;
	
	@Getter(AccessLevel.NONE)
	@JsonInclude(Include.NON_EMPTY)
	private List<AppointmentCloneInfo> clonedAppointments;
	
	@Data
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	@JsonInclude(Include.NON_NULL)
	public static class AppointmentCloneInfo {
		private Long id;
		private String folio;
		private AppointmentType type;
		private AppointmentOrigin origin;
		private AppointmentStatus status;
		private AppointmentConfirmation confirmation;
		private LocalDate appointmentDate;
		private LocalTime startTime;
		private LocalTime endTime;
		private Integer month;
		private Long originalAppointment;
		private String anotherPersonName;
		private Long relationshipId;
		private String additionalInfo;
	}

	public List<AppointmentCloneInfo> getClonedAppointments() {
		if (clonedAppointments == null) {
			clonedAppointments = new ArrayList<>();
		}
		return clonedAppointments;
	}

}