package mx.softixx.cis.common.agenda.payload;

import jakarta.validation.GroupSequence;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.softixx.cis.common.validation.annotation.NotNullNorEmpty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@GroupSequence({ AppointmentCancellationRequest.class })
public class AppointmentCancellationRequest {
	public static final AppointmentStatus status = AppointmentStatus.CANCELLED;
	
	@NotNullNorEmpty
	private AppointmentCancelled cancelledBy;
}