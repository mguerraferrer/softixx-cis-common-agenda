package mx.softixx.cis.common.agenda.payload;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.validation.GroupSequence;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.softixx.cis.common.validation.annotation.NotNullNorEmpty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@GroupSequence({ AppointmentDataRequest.class })
public class AppointmentDataRequest {
	@NotNullNorEmpty
	private List<@Valid AppointmentData> data;
	
	@Data
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	@GroupSequence({ AppointmentData.class })
	public static class AppointmentData {
		@NotNullNorEmpty
		private NotificationType notificationType;
		
		@NotNullNorEmpty
		private String mailsOrMobiles;
		
		@NotNullNorEmpty
		private LocalDateTime date;
	}
}