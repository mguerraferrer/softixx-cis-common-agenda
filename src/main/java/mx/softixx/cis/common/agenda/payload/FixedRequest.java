package mx.softixx.cis.common.agenda.payload;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jakarta.validation.GroupSequence;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import mx.softixx.cis.common.core.datetime.WeekDay;
import mx.softixx.cis.common.validation.annotation.Before;
import mx.softixx.cis.common.validation.annotation.NotDuplicated;
import mx.softixx.cis.common.validation.annotation.NotNullNorEmpty;
import mx.softixx.cis.common.validation.group.Group1;
import mx.softixx.cis.common.validation.group.Group2;
import mx.softixx.cis.common.validation.group.OnCreate;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Before(from = "startTime", to = "endTime", groups = { Group2.class })
@GroupSequence({ FixedRequest.class, Group1.class, Group2.class })
public class FixedRequest {
	@NotNullNorEmpty(groups = { OnCreate.class, Group1.class })
	private LocalTime startTime;

	@NotNullNorEmpty(groups = { OnCreate.class, Group1.class })
	private LocalTime endTime;

	private Integer totalPatients;
	private Integer totalExtraSlot;
	
	@Getter(AccessLevel.NONE)
	@NotNullNorEmpty(groups = { OnCreate.class, Group1.class })
	@NotDuplicated(groups = Group2.class)
	private List<WeekDay> weekDays;
	
	@NotDuplicated(groups = Group2.class)
	private Integer[] intArray;
	
	@NotDuplicated(groups = Group2.class)
	private Map<String, String> map;
	
	@NotDuplicated(groups = Group2.class)
	private String str;
	
	@NotDuplicated(groups = Group2.class)
	private Integer intVal;

	public List<WeekDay> getWeekDays() {
		if (weekDays == null) {
			weekDays = new ArrayList<>();
		}
		return weekDays;
	}
	
	public List<String> getDays() {
		return getWeekDays().stream().map(WeekDay::name).toList();
	}
	
}