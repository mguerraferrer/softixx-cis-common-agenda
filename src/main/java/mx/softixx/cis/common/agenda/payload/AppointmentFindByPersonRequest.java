package mx.softixx.cis.common.agenda.payload;

import java.time.LocalDate;

import jakarta.validation.GroupSequence;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import mx.softixx.cis.common.validation.annotation.NotNullNorEmpty;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@GroupSequence({ AppointmentFindByPersonRequest.class })
public class AppointmentFindByPersonRequest extends AppointmentFindByBaseRequest {
	@NotNullNorEmpty
	private Long personId;
	
	public AppointmentFindByPersonRequest(Long specialityId, Long serviceId, Long personId, LocalDate date) {
		super(specialityId, serviceId, date);
		this.personId = personId;
	}
}