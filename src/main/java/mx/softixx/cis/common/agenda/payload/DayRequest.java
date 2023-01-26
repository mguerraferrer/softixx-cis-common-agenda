package mx.softixx.cis.common.agenda.payload;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.validation.GroupSequence;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import mx.softixx.cis.common.core.datetime.WeekDay;
import mx.softixx.cis.common.validation.annotation.Before;
import mx.softixx.cis.common.validation.annotation.NotNullNorEmpty;
import mx.softixx.cis.common.validation.group.Group1;
import mx.softixx.cis.common.validation.group.Group2;
import mx.softixx.cis.common.validation.group.OnCreate;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
@Before(from = "startTime", to = "endTime", groups = Group2.class)
@GroupSequence({ DayRequest.class, Group1.class, Group2.class })
public class DayRequest {
	@NotNullNorEmpty(groups = Group1.class)
	private WeekDay day;

	@NotNullNorEmpty(groups = { OnCreate.class, Group1.class })
	private LocalTime startTime;

	@NotNullNorEmpty(groups = { OnCreate.class, Group1.class })
	private LocalTime endTime;

	private Integer totalPatients;
	private Integer totalExtraSlot;
}