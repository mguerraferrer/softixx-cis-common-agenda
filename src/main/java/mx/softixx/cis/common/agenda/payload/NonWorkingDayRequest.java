package mx.softixx.cis.common.agenda.payload;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import jakarta.validation.GroupSequence;
import jakarta.validation.constraints.Null;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mx.softixx.cis.common.validation.annotation.FutureOrPresent;
import mx.softixx.cis.common.validation.annotation.NotNullNorEmpty;
import mx.softixx.cis.common.validation.group.Group1;
import mx.softixx.cis.common.validation.group.OnCreate;
import mx.softixx.cis.common.validation.group.OnDelete;
import mx.softixx.cis.common.validation.group.OnUpdate;
import mx.softixx.cis.common.validation.message.ValidatorMessage;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@GroupSequence({ NonWorkingDayRequest.class, Group1.class })
public class NonWorkingDayRequest {
	@Null(groups = { OnUpdate.class, OnDelete.class }, message = ValidatorMessage.NULLABLE)
	@NotNullNorEmpty(groups = OnCreate.class)
	private Long medicalScheduleId;

	@Getter(AccessLevel.NONE)
	@Null(groups = { OnDelete.class }, message = ValidatorMessage.NULLABLE)
	@NotNullNorEmpty(groups = { OnCreate.class, OnUpdate.class })
	private List<@FutureOrPresent(groups = Group1.class) LocalDate> nonWorkingDays;

	@Getter(AccessLevel.NONE)
	@Null(groups = { OnCreate.class, OnUpdate.class }, message = ValidatorMessage.NULLABLE)
	@NotNullNorEmpty(groups = OnDelete.class)
	private List<@FutureOrPresent(groups = Group1.class) LocalDate> daysToDelete;

	public Stream<LocalDate> nonWorkingDaysStream() {
		return this.nonWorkingDays.isEmpty() ? Stream.empty() : this.nonWorkingDays.stream();
	}

	public Stream<LocalDate> daysToDeleteStream() {
		return this.daysToDelete.isEmpty() ? Stream.empty() : this.daysToDelete.stream();
	}

	public List<LocalDate> getNonWorkingDays() {
		if (nonWorkingDays == null) {
			return new ArrayList<>();
		}
		return nonWorkingDays;
	}

	public List<LocalDate> getDaysToDelete() {
		if (daysToDelete == null) {
			return new ArrayList<>();
		}
		return daysToDelete;
	}
}