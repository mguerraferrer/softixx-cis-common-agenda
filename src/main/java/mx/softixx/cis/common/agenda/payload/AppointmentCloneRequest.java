package mx.softixx.cis.common.agenda.payload;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.GroupSequence;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.softixx.cis.common.core.datetime.WeekDay;
import mx.softixx.cis.common.validation.annotation.FutureOrPresent;
import mx.softixx.cis.common.validation.annotation.NotNullNorEmpty;
import mx.softixx.cis.common.validation.group.Group1;
import mx.softixx.cis.common.validation.group.Group2;
import mx.softixx.cis.common.validation.group.Group3;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@GroupSequence({ AppointmentCloneRequest.class, Group1.class, Group2.class, Group3.class })
public class AppointmentCloneRequest {
	@NotNullNorEmpty(groups = Group1.class)
	private AppointmentCloneFrequency frequency;
	
	@NotNullNorEmpty(groups = Group1.class)
	private AppointmentCloneFrequencyInfo frequencyInfo;
	
	private Integer frequencyDay;
	private Integer frequencyEvery;
	private List<WeekDay> frequencyWeekDays;
	
	@NotNullNorEmpty(groups = Group1.class)
	@FutureOrPresent(groups = Group2.class)
	private LocalDate repetitionStartDate;
	
	@NotNullNorEmpty(groups = Group1.class)
	private AppointmentCloneRepetition repetition;
	
	@FutureOrPresent(groups = Group2.class)
	private LocalDate repetitionDueDate;
	
	private Integer numberOfRepetitions;
}