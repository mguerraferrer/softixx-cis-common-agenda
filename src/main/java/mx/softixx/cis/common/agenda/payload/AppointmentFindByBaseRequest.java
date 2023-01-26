package mx.softixx.cis.common.agenda.payload;

import java.time.LocalDate;

import jakarta.validation.GroupSequence;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import mx.softixx.cis.common.validation.annotation.NotNullNorEmpty;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@GroupSequence({ AppointmentFindByBaseRequest.class })
public class AppointmentFindByBaseRequest {
	@NotNullNorEmpty
	private Long specialityId;
	
	@NotNullNorEmpty
	private Long serviceId;
	
	@NotNullNorEmpty
	private LocalDate appointmentDate;
}