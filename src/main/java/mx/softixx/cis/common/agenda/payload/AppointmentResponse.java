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
import mx.softixx.cis.common.agenda.payload.AppointmentDataRequest.AppointmentData;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class AppointmentResponse {
	private Long id;
	private Long personId;
	private Long doctorSpecialityId;
	private Long privatePracticeServiceId;
	private Long doctorClinicalEntitySpecialityId;
	private Long doctorClinicalEntityServiceId;
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
	private AppointmentCancelled cancelledBy;
	private AppointmentReschedule rescheduledBy;
	private String additionalInfo;
	
	@Getter(AccessLevel.NONE)
	@JsonInclude(Include.NON_EMPTY)
	private List<AppointmentData> reminders;

	@Getter(AccessLevel.NONE)
	@JsonInclude(Include.NON_EMPTY)
	private List<AppointmentData> notifications;

	public List<AppointmentData> getReminders() {
		if (reminders == null) {
			reminders = new ArrayList<>();
		}
		return reminders;
	}

	public List<AppointmentData> getNotifications() {
		if (notifications == null) {
			notifications = new ArrayList<>();
		}
		return notifications;
	}

}